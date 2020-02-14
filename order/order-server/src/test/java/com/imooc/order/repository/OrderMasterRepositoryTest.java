package com.imooc.order.repository;


import com.imooc.order.dataobject.OrderMaster;
import com.imooc.order.enums.OrderStatusEnum;
import com.imooc.order.enums.PayStatusEnum;
// import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class OrderMasterRepositoryTest {// extends OrderApplicationTests

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void testSave(){
    OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("12345678");
        orderMaster.setBuyerName("师兄");
        orderMaster.setBuyerPhone("134766678980");
        orderMaster.setBuyerAddress("北京市总部");
        orderMaster.setBuyerOpenid("11001101");
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setCreateTime(new Date());
    OrderMaster result = orderMasterRepository.save(orderMaster);
//    Assert.asserTure(condition:result != null);
        System.out.println(result);
    }
}