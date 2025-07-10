package controller;

import dto.request.OrderItemRequest;
import dto.response.OrderItemResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.OrderItemService;

import java.util.List;

@RestController
@RequestMapping("/orderitems")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping("/{code}")
    public ResponseEntity<OrderItemResponse> getOrderItem(@PathVariable Integer code) {
        OrderItemResponse response = orderItemService.getOrderItem(code);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<OrderItemResponse> addOrderItem(@Valid @RequestBody OrderItemRequest request) {
        OrderItemResponse response = orderItemService.addOrderItem(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/batch")
    public ResponseEntity<List<OrderItemResponse>> addOrderItems(@Valid @RequestBody List<OrderItemRequest> requests) {
        List<OrderItemResponse> responses = orderItemService.addOrderItems(requests);
        return ResponseEntity.status(HttpStatus.CREATED).body(responses);
    }
}
