package com.imooc.order.service;

import com.imooc.order.dto.OrderDTO;

/**
 *创建订单
 *
 */
public interface OrderService {

    OrderDTO create(OrderDTO orderDTO);
}
