package org.payartz.restorapi.services;

import org.payartz.restorapi.model.request.OrderRequest;
import org.payartz.restorapi.model.response.OrderResponse;

public interface OrderService {
    OrderResponse createOrder(OrderRequest request);
    OrderResponse getOrderById(Long id);
    OrderResponse updateOrder(Long id, OrderRequest request);
    void deleteOrder(Long id);
}

