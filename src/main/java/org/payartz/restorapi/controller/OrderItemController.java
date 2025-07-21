package org.payartz.restorapi.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.payartz.restorapi.model.request.OrderItemRequest;
import org.payartz.restorapi.model.response.OrderItemResponse;
import org.payartz.restorapi.services.OrderItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order-items")
@RequiredArgsConstructor
public class OrderItemController {

    private final OrderItemService orderItemService;

    @PostMapping
    public ResponseEntity<OrderItemResponse> create(@RequestBody @Valid OrderItemRequest request) {
        return ResponseEntity.ok(orderItemService.createOrderItem(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItemResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(orderItemService.getOrderItemById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderItemResponse> update(@PathVariable Long id, @RequestBody @Valid OrderItemRequest request) {
        return ResponseEntity.ok(orderItemService.updateOrderItem(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        orderItemService.deleteOrderItem(id);
        return ResponseEntity.noContent().build();
    }
}

