package com.imooc.product.controller;


import com.imooc.product.Utils.ResultVOUtil;
import com.imooc.product.common.CartDTO;
import com.imooc.product.common.ProductInfo;
import com.imooc.product.dataobject.ProductCategory;
import com.imooc.product.service.CategoryService;
import com.imooc.product.service.ProductService;
import com.imooc.product.vo.ProductInfoVO;
import com.imooc.product.vo.ProductVo;
import com.imooc.product.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 商品
 */
@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;
    /**
     * 1.查询所有在架的商品
     * 2.获取类目type列表
     * 3.查询类目
     * 4.构造数据
     */
    @GetMapping("/list")
    public ResultVO<ProductVo> list(){
        //1.查询所有在架的商品
        List<ProductInfo> productInfolist = productService.findUpAll();
        //2.获取类目type列表
        List<Integer>cagegoryTypeList = productInfolist.stream()// 方法返回的List取某个字段重新放在一个list里
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());
        //3.从数据库查询类目
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(cagegoryTypeList);
        //4.构造数据
        List<ProductVo> productVoList = new ArrayList<>();
        for(ProductCategory productCategory:categoryList){
            ProductVo productVo = new ProductVo();
            productVo.setCategoryName(productCategory.getCategoryName());
            productVo.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo:productInfolist ){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVo.setProductInfoVOList(productInfoVOList);
            productVoList.add(productVo);
        }

        return ResultVOUtil.success(productVoList);
    }

    @PostMapping("/listForOrder")
    public List<ProductInfo> listForOrder(@RequestBody List<String> productIdList){
        log.info("调用啊成功！！！！");
        return productService.findList(productIdList);
    }

    @PostMapping("/decreaseStock")
    public void  decreaseStock(@RequestBody List<CartDTO> cartDTOList){
        log.info("调用啊成功！！！！");
         productService.decreaseStock(cartDTOList);
    }
}
