package controller;

import dto.OrderItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.OrderItemService;

import java.util.List;

@RestController
@RequestMapping("/orderitems")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping("/{code}")
    public OrderItemDTO getOrderItem(@PathVariable Integer code) {
        return orderItemService.getOrderItem(code);
    }
    @PostMapping("/batch")
    public List<OrderItemDTO> addOrderItems(@RequestBody List<OrderItemDTO> dtos) {
        return orderItemService.addOrderItems(dtos);
    }

    @PostMapping
    public OrderItemDTO addOrderItem(@RequestBody OrderItemDTO dto) {
        return orderItemService.addOrderItem(dto);
    }
}
