package com.imooc.product.impl;


import com.imooc.product.Utils.JsonUtil;
import com.imooc.product.common.CartDTO;
import com.imooc.product.common.ProductInfo;
import com.imooc.product.enums.ProductStatusEnum;
import com.imooc.product.enums.ResultEnum;
import com.imooc.product.exception.ProductException;
import com.imooc.product.repository.ProductInfoRepository;
import com.imooc.product.service.ProductService;
import com.rabbitmq.tools.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Autowired
    private AmqpTemplate amqpTemplate;
    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfo> findList(List<String> productIdList) {

        return productInfoRepository.findByProductIdIn(productIdList);
    }
    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> carDTOList) {
        for(CartDTO cartDTO:carDTOList){
            Optional<ProductInfo> productInfoOptional =productInfoRepository.findById(cartDTO.getProductId());
            // 判断商品是否存在
             if(!productInfoOptional.isPresent()){
                 throw new ProductException(ResultEnum.PRODUCT_NOY_EXIST);
             }

             ProductInfo productInfo = productInfoOptional.get();
             // 库存是否足够
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if(result < 0){
                throw  new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);

            // 发送MQ消息
//            amqpTemplate.convertAndSend("productInfo","1234567890");
            amqpTemplate.convertAndSend("productInfo", JsonUtil.toJson(productInfo));
            log.info(JsonUtil.toJson(productInfo));
        }
    }

    /**
     *测试类
     * @param args
     */
//    public static void main(String[] args) {
//        ProductServiceImpl productServiceImpl = new ProductServiceImpl();
//        List<ProductInfo> list = productServiceImpl.findUpAll();
//        System.out.println(list.size());
//    }
}
