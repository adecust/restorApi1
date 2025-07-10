package services;

import dto.request.OrderItemRequest;
import dto.response.OrderItemResponse;
import model.MenuItem;
import model.Order;
import model.OrderItem;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.MenuItemRepository;
import repository.OrderItemRepository;
import repository.OrderRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Autowired
    private ModelMapper modelMapper;

    public OrderItemResponse getOrderItem(Integer code) {
        OrderItem item = orderItemRepository.findByCode(code);
        return modelMapper.map(item, OrderItemResponse.class);
    }

    public OrderItemResponse addOrderItem(OrderItemRequest request) {
        OrderItem item = modelMapper.map(request, OrderItem.class);
        Order order = orderRepository.findByCode(request.getOrderCode());
        MenuItem menuItem = menuItemRepository.findByCode(request.getMenuItemCode());
        item.setOrder(order);
        item.setMenuItem(menuItem);

        item = orderItemRepository.save(item);
        item.setCode(60000 + item.getId().intValue());
        item = orderItemRepository.save(item);

        return modelMapper.map(item, OrderItemResponse.class);
    }

    public List<OrderItemResponse> addOrderItems(List<OrderItemRequest> requests) {
        return requests.stream()
                .map(this::addOrderItem)
                .collect(Collectors.toList());
    }
}
