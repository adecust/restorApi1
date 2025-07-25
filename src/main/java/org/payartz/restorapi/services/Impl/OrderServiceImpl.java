package org.payartz.restorapi.services.Impl;

import lombok.RequiredArgsConstructor;
import org.payartz.restorapi.exception.ErrorCode;
import org.payartz.restorapi.exception.exceptions.ResourceNotFoundException;
import org.payartz.restorapi.model.converter.OrderConverter;
import org.payartz.restorapi.model.entity.Order;
import org.payartz.restorapi.model.request.OrderRequest;
import org.payartz.restorapi.model.response.OrderResponse;
import org.payartz.restorapi.repository.OrderRepository;
import org.payartz.restorapi.services.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderConverter orderConverter;

    @Override
    public OrderResponse createOrder(OrderRequest request) {
        Order order = orderConverter.dtoToEntity(request);
        Order saved = orderRepository.save(order);
        return orderConverter.entityToResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public OrderResponse getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.ORDER_NOT_FOUND, "Order bulunamadı: " + id));
        return orderConverter.entityToResponse(order);
    }

    @Override
    public OrderResponse updateOrder(Long id, OrderRequest request) {
        Order existing = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.ORDER_NOT_FOUND, "Order bulunamadı: " + id));
        Order updated = orderConverter.dtoToEntity(request);
        updated.setId(existing.getId());
        Order saved = orderRepository.save(updated);
        return orderConverter.entityToResponse(saved);
    }

    @Override
    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new ResourceNotFoundException(ErrorCode.ORDER_NOT_FOUND, "Order bulunamadı: " + id);
        }
        orderRepository.deleteById(id);
    }
}
