package org.payartz.restorapi.model.converter;

import lombok.RequiredArgsConstructor;
import org.payartz.restorapi.model.dto.OrderItemDTO;
import org.payartz.restorapi.model.entity.MenuItem;
import org.payartz.restorapi.model.entity.Order;
import org.payartz.restorapi.model.entity.OrderItem;
import org.payartz.restorapi.model.request.OrderItemRequest;
import org.payartz.restorapi.model.response.OrderItemResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderItemConverter {

    public OrderItem dtoToEntity(OrderItemRequest request) {
        OrderItem item = new OrderItem();
        item.setQuantity(request.getQuantity());
        item.setPrice(request.getPrice());

        Order order = new Order();
        order.setId(request.getOrderId());
        item.setOrder(order);

        MenuItem menuItem = new MenuItem();
        menuItem.setId(request.getMenuItemId());
        item.setMenuItem(menuItem);

        return item;
    }

    public OrderItemResponse entityToResponse(OrderItem item) {
        OrderItemResponse response = new OrderItemResponse();
        response.setId(item.getId());
        response.setQuantity(item.getQuantity());
        response.setPrice(item.getPrice());
        response.setOrderId(item.getOrder().getId());
        response.setMenuItemId(item.getMenuItem().getId());
        return response;
    }
}

