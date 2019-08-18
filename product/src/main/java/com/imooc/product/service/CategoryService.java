package com.imooc.product.service;

import com.imooc.product.dataobject.ProductCategory;


import java.util.List;

/**
 * 查询所有在架商品列表
 */

public interface CategoryService {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
