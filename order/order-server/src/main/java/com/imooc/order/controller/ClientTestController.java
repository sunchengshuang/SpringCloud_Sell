package com.imooc.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

/**
 * @Author lizhengwei
 * @Description //TODO $
 * @Date $ $
 * @Param $
 * @return $
 **/
@Slf4j
@RequestMapping("/lizw")
@Controller
public class ClientTestController {

    //@Autowired
    //private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/lizw")
    public void getProduct(){

        log.info("进入");
        RestTemplate restTemplate = new RestTemplate();
        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
        String URL = String.format("http://%s:%s",serviceInstance.getHost(),serviceInstance.getPort()+"/product/lizw");
        String result = restTemplate.getForObject(URL,String.class);

        }
        }
