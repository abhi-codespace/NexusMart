package com.nexusmart.nexusmart_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nexusmart.nexusmart_backend.entity.OrderItem;
import com.nexusmart.nexusmart_backend.repository.OrderItemRepository;
import com.nexusmart.nexusmart_backend.serviceInterface.OrderItemService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;

    // Inteface

    // List<OrderItem> getAllOrderItems();

    // OrderItem getOrderItemById(Long id);

    // List<OrderItem> getOrderItemByOrderId(Long id);

    // OrderItem createOrderItem(OrderItem orderItem);

    // OrderItem updateOrderItem(Long id,OrderItem orderItem);

    // void deleteOrderItem(Long id);
    
    @Override
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    @Override
    public OrderItem getOrderItemById(Long id) {
        return orderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrderItem not found with id " + id));
    }

    @Override
    public List<OrderItem> getOrderItemByOrderId(Long orderId) {
        return orderItemRepository.findByOrderId(orderId);
    }

    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public OrderItem updateOrderItem(Long id, OrderItem orderItem) {
        return orderItemRepository.findById(id).map(existingItem -> {
            existingItem.setOrder(orderItem.getOrder());
            existingItem.setProduct(orderItem.getProduct());
            existingItem.setQuantity(orderItem.getQuantity());
            existingItem.setPrice(orderItem.getPrice());
            return orderItemRepository.save(existingItem);
        }).orElse(null);
    }

    @Override
    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }
}

    