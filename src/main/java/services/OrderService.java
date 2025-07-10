package services;

import dto.OrderDTO;
import model.Customer;
import model.Order;
import model.Restaurant;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CustomerRepository;
import repository.OrderRepository;
import repository.RestaurantRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private ModelMapper modelMapper;

    public OrderDTO getOrder(Integer code) {
        Order order = orderRepository.findByCode(code);
        return modelMapper.map(order, OrderDTO.class);
    }

    public OrderDTO addOrder(OrderDTO dto) {
        Order order = modelMapper.map(dto, Order.class);
        Customer customer = customerRepository.findByCode(dto.getCustomerCode());
        Restaurant restaurant = restaurantRepository.findByCode(dto.getRestaurantCode());
        order.setCustomer(customer);
        order.setRestaurant(restaurant);

        order = orderRepository.save(order);
        order.setCode(50000 + order.getId().intValue());
        order = orderRepository.save(order);

        return modelMapper.map(order, OrderDTO.class);
    }
}
