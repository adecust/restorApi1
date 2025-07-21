package org.payartz.restorapi.services;

import org.payartz.restorapi.model.request.OrderItemRequest;
import org.payartz.restorapi.model.response.OrderItemResponse;

public interface OrderItemService {
    OrderItemResponse createOrderItem(OrderItemRequest request);
    OrderItemResponse getOrderItemById(Long id);
    OrderItemResponse updateOrderItem(Long id, OrderItemRequest request);
    void deleteOrderItem(Long id);
}
