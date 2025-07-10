package controller;

import dto.request.OrderRequest;
import dto.response.OrderResponse;
import jakarta.validation.Valid;
import model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{code}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable Integer code) {
        OrderResponse response = orderService.getOrder(code);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public Order addOrder(@RequestBody OrderRequest orderRequest) {
        Order createdOrder = orderService.addOrder(orderRequest);

        if (createdOrder != null) {
            System.out.println("Order created successfully: " + createdOrder.getId());
        } else {
            System.out.println("Failed to create order.");
        }

        return createdOrder;
    }
}
