package services;

import dto.OrderItemDTO;
import model.MenuItem;
import model.Order;
import model.OrderItem;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.MenuItemRepository;
import repository.OrderItemRepository;
import repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

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

    public OrderItemDTO getOrderItem(Integer code) {
        OrderItem item = orderItemRepository.findByCode(code);
        return modelMapper.map(item, OrderItemDTO.class);
    }

    public OrderItemDTO addOrderItem(OrderItemDTO dto) {
        OrderItem item = modelMapper.map(dto, OrderItem.class);
        Order order = orderRepository.findByCode(dto.getOrderCode());
        MenuItem menuItem = menuItemRepository.findByCode(dto.getMenuItemCode());

        item.setOrder(order);
        item.setMenuItem(menuItem);

        item = orderItemRepository.save(item);
        item.setCode(60000 + item.getId().intValue());
        item = orderItemRepository.save(item);

        return modelMapper.map(item, OrderItemDTO.class);
    }
    public List<OrderItemDTO> addOrderItems(List<OrderItemDTO> dtos) {
        List<OrderItemDTO> savedItems = new ArrayList<>();

        for (OrderItemDTO dto : dtos) {
            OrderItem item = modelMapper.map(dto, OrderItem.class);

            Order order = orderRepository.findByCode(dto.getOrderCode());
            if (order == null) {
                throw new RuntimeException("Order not found with code: " + dto.getOrderCode());
            }

            MenuItem menuItem = menuItemRepository.findByCode(dto.getMenuItemCode());
            if (menuItem == null) {
                throw new RuntimeException("MenuItem not found with code: " + dto.getMenuItemCode());
            }

            item.setOrder(order);
            item.setMenuItem(menuItem);

            item = orderItemRepository.save(item);
            item.setCode(60000 + item.getId().intValue());
            item = orderItemRepository.save(item);

            savedItems.add(modelMapper.map(item, OrderItemDTO.class));
        }

        return savedItems;
    }

}
