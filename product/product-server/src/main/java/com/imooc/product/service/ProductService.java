package com.imooc.product.service;


import com.imooc.product.common.CartDTO;
import com.imooc.product.common.ProductInfo;

import java.util.List;

public interface ProductService {
    /**
     * 查询所有在架商品列表
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询商品列表
     * @param productIdList
     * @return
     */
    List<ProductInfo> findList(List<String> productIdList);

    /**
     * 扣库存
     * @param carDTOList
     */
    void decreaseStock(List<CartDTO> carDTOList);
}
