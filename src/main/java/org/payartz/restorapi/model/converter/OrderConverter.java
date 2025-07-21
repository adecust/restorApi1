package org.payartz.restorapi.model.converter;

import lombok.RequiredArgsConstructor;
import org.payartz.restorapi.model.dto.OrderDTO;
import org.payartz.restorapi.model.entity.Branch;
import org.payartz.restorapi.model.entity.Order;
import org.payartz.restorapi.model.entity.User;
import org.payartz.restorapi.model.request.OrderRequest;
import org.payartz.restorapi.model.response.OrderResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
@Component
public class OrderConverter {

    public Order dtoToEntity(OrderRequest request) {
        Order order = new Order();
        order.setOrderTime(request.getOrderTime());
        order.setStatus(request.getStatus());
        order.setTotalPrice(request.getTotalPrice());

        User user = new User();
        user.setId(request.getUserId());
        order.setUser(user);

        Branch branch = new Branch();
        branch.setId(request.getBranchId());
        order.setBranch(branch);

        return order;
    }

    public OrderResponse entityToResponse(Order order) {
        OrderResponse response = new OrderResponse();
        response.setId(order.getId());
        response.setOrderTime(order.getOrderTime());
        response.setStatus(order.getStatus());
        response.setTotalPrice(order.getTotalPrice());
        response.setUserId(order.getUser().getId());
        response.setBranchId(order.getBranch().getId());
        return response;
    }
}
