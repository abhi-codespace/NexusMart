package com.nexusmart.nexusmart_backend.serviceInterface;

import java.util.List;

import com.nexusmart.nexusmart_backend.entity.OrderItem;

public interface OrderItemService {

    List<OrderItem> getAllOrderItems();

    OrderItem getOrderItemById(Long id);

    List<OrderItem> getOrderItemByOrderId(Long id);

    OrderItem createOrderItem(OrderItem orderItem);

    OrderItem updateOrderItem(Long id,OrderItem orderItem);

    void deleteOrderItem(Long id);
}
