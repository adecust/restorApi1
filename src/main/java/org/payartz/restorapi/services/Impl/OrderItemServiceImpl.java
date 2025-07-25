package org.payartz.restorapi.services.Impl;

import lombok.RequiredArgsConstructor;
import org.payartz.restorapi.exception.ErrorCode;
import org.payartz.restorapi.exception.exceptions.ResourceNotFoundException;
import org.payartz.restorapi.model.converter.OrderItemConverter;
import org.payartz.restorapi.model.entity.OrderItem;
import org.payartz.restorapi.model.request.OrderItemRequest;
import org.payartz.restorapi.model.response.OrderItemResponse;
import org.payartz.restorapi.repository.OrderItemRepository;
import org.payartz.restorapi.services.OrderItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderItemConverter orderItemConverter;

    @Override
    public OrderItemResponse createOrderItem(OrderItemRequest request) {
        OrderItem item = orderItemConverter.dtoToEntity(request);
        OrderItem saved = orderItemRepository.save(item);
        return orderItemConverter.entityToResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public OrderItemResponse getOrderItemById(Long id) {
        OrderItem item = orderItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.ORDER_ITEM_NOT_FOUND, "Order Item bulunamadı: " + id));
        return orderItemConverter.entityToResponse(item);
    }

    @Override
    public OrderItemResponse updateOrderItem(Long id, OrderItemRequest request) {
        OrderItem existing = orderItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.ORDER_ITEM_NOT_FOUND, "Order Item bulunamadı: " + id));
        OrderItem updated = orderItemConverter.dtoToEntity(request);
        updated.setId(existing.getId());
        OrderItem saved = orderItemRepository.save(updated);
        return orderItemConverter.entityToResponse(saved);
    }

    @Override
    public void deleteOrderItem(Long id) {
        if (!orderItemRepository.existsById(id)) {
            throw new ResourceNotFoundException(ErrorCode.ORDER_ITEM_NOT_FOUND, "Order Item bulunamadı: " + id);
        }
        orderItemRepository.deleteById(id);
    }
}
