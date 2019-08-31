package com.imooc.product.repository;

import com.imooc.product.dataobject.ProductInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
//import org.junit.runner.RunWith;


//@RunWith(SpringRunner.class)
@SpringBootTest
class ProductInfoRepositoryTest{

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    void findByProductStatus() {
        List<ProductInfo> list = productInfoRepository.findByProductStatus(0);
        System.out.println(list.size());
    }

    @Test
    void findByPAndProductIdIn() {
        List<ProductInfo> list = productInfoRepository.findByProductIdIn(Arrays.asList("asadsr35437478"));
        System.out.println(list.size());
    }
}