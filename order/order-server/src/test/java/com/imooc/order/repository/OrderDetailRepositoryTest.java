package com.imooc.order.repository;

import com.imooc.order.dataobject.OrderDetail;
// import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
class OrderDetailRepositoryTest {// extends OrderApplicationTests

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void testSave(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("12367");
        orderDetail.setOrderId("1234567"); // 要与OrderMaster表里的OrderId字段对应
        orderDetail.setProductIcon("http://xxxx.com");
        orderDetail.setProductId("asadsr35437478"); // 找一个真实存在的
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal(0.01));
        orderDetail.setProductQuantity(2);
        orderDetail.setCreateTime(new Date());
        OrderDetail result = orderDetailRepository.save(orderDetail);
        System.out.println( );
    }

}