package com.nexusmart.nexusmart_backend.controller;

import com.nexusmart.nexusmart_backend.entity.OrderItem;
import com.nexusmart.nexusmart_backend.serviceInterface.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order-items")
public class OrderItemController {

    private final OrderItemService orderItemService;

    // Get all order items
    @GetMapping
    public ResponseEntity<List<OrderItem>> getAllOrderItems() {
        List<OrderItem> orderItems = orderItemService.getAllOrderItems();
        return ResponseEntity.ok(orderItems);
    }

    // Get order item by ID
    @GetMapping("/{id}")
    public ResponseEntity<OrderItem> getOrderItemById(@PathVariable Long id) {
        OrderItem orderItem = orderItemService.getOrderItemById(id);
        if (orderItem == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(orderItem);
    }

    // Get all order items by id
    @GetMapping("/by-order/{id}")
    public ResponseEntity<List<OrderItem>> getOrderItemsByOrderId(@PathVariable Long id) {
        List<OrderItem> items = orderItemService.getOrderItemByOrderId(id);
        return ResponseEntity.ok(items);
    }

    // Create order item
    @PostMapping
    public ResponseEntity<OrderItem> createOrderItem(@RequestBody OrderItem orderItem) {
        OrderItem savedItem = orderItemService.createOrderItem(orderItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedItem);
    }

    // Update order item
    @PutMapping("/{id}")
    public ResponseEntity<OrderItem> updateOrderItem(@PathVariable Long id, @RequestBody OrderItem orderItem) {
        OrderItem updatedItem = orderItemService.updateOrderItem(id, orderItem);
        if (updatedItem == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedItem);
    }

    // Delete order item
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrderItem(@PathVariable Long id) {
        orderItemService.deleteOrderItem(id);
        return ResponseEntity.ok("Order item deleted successfully");
    }
}
