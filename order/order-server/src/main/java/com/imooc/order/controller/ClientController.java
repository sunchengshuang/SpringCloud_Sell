package com.imooc.order.controller;


import com.imooc.order.client.ProductClient;
import com.imooc.order.dataobject.ProductInfo;
import com.imooc.order.dto.CartDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 *
 */
@RestController
@Slf4j
public class ClientController {

//    @Autowired
//    private LoadBalancerClient loadBalancerClient;

//    @Autowired
//    private  RestTemplate restTemplate;

    @Autowired
    private ProductClient productClient;

    @RequestMapping("/getProductMsg")
    public String getProductMsg(){
        //第一种方式(直接使用restTemplate ， url写死)
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject("http://localhost:8080/msg",String.class);

        //第二种方式（利用loadBalancerClient 通过应用名获取url, 然后在使用 restTemplate）
//        RestTemplate restTemplate = new RestTemplate();
//        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
//        String url = String.format("http://%s:%s",serviceInstance.getHost(),serviceInstance.getPort() + "/msg");
//        String response = restTemplate.getForObject(url,String.class);

        //第三种方式（利用@LoadBalanced标签 ， 可以在restTemplate里使用应用名字）
//        String response = restTemplate.getForObject("http://PRODUCT/msg",String.class);

        String response = productClient.productMsg();
        log.info("response{}" + response);
        return response;
    }

    @RequestMapping("/getProductList")
    public String getProductList(){
        List<ProductInfo> ProductInfoList = productClient.listForOrder(Arrays.asList("asadsr35437478"));
        log.info("Response{}"+ ProductInfoList);
        return "ok";
    }

    @RequestMapping("/decreaseStock")
    public String productDecreaseStock(){
         productClient.decreaseStock(Arrays.asList(new CartDTO("asadsr35437478",3)));
         return "ok";
    }
}
