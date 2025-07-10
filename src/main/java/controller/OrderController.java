package controller;

import dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{code}")
    public OrderDTO getOrder(@PathVariable Integer code) {
        return orderService.getOrder(code);
    }

    @PostMapping
    public OrderDTO addOrder(@RequestBody OrderDTO dto) {
        return orderService.addOrder(dto);
    }
}
