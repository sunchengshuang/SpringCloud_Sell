package com.imooc.order.repository;

import com.imooc.order.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {


//    public static void main(String[] args) {
//        OrderDetailRepository OrderDetailRepository = OrderDetailRepository();
//        OrderDetailRepository.setOrderStatus(setOrderStatusEnum.NEW.getCode());
//    }
}
