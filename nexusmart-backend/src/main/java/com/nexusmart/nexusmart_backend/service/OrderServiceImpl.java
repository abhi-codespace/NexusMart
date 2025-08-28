package com.nexusmart.nexusmart_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nexusmart.nexusmart_backend.entity.Order;
import com.nexusmart.nexusmart_backend.entity.OrderStatus;
import com.nexusmart.nexusmart_backend.repository.OrderRepository;
import com.nexusmart.nexusmart_backend.serviceInterface.OrderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id " + id));
    }

    @Override
    public Order createOrder(Order order) {
        order.setStatus(OrderStatus.CREATED);
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Long id, Order order) {
        return orderRepository.findById(id).map(existingOrder -> {
            existingOrder.setUser(order.getUser());
            existingOrder.setOrderItems(order.getOrderItems());
            existingOrder.setTotalAmount(order.getTotalAmount());
            existingOrder.setStatus(order.getStatus());
            existingOrder.setOrderDate(order.getOrderDate());
            return orderRepository.save(existingOrder);
        }).orElseThrow(() -> new RuntimeException("Order not found with id " + id));
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<Order> getOrderByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    @Override
    public Order updateOrderStatus(Long id, OrderStatus status) {
        return orderRepository.findById(id).map(existingOrder -> {
            if (!isValidTransition(existingOrder.getStatus(), status)) {
                throw new RuntimeException("Invalid status transition: "
                        + existingOrder.getStatus() + " → " + status);
            }
            existingOrder.setStatus(status);
            return orderRepository.save(existingOrder);
        }).orElseThrow(() -> new RuntimeException("Order not found with id " + id));
    }

      private boolean isValidTransition(OrderStatus current, OrderStatus next) {
        return switch (current) {
            case CREATED -> (next == OrderStatus.PAID || next == OrderStatus.CANCELLED);
            case PAID -> (next == OrderStatus.SHIPPED || next == OrderStatus.CANCELLED);
            case SHIPPED -> (next == OrderStatus.DELIVERED || next == OrderStatus.CANCELLED);
            case DELIVERED, CANCELLED -> false; // Final states
        };
    }
}
