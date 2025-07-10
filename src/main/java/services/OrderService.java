package services;

import dto.request.OrderRequest;
import dto.response.OrderResponse;
import model.Customer;
import model.Order;
import model.Restaurant;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CustomerRepository;
import repository.OrderRepository;
import repository.RestaurantRepository;

import java.util.List;
import java.util.UUID;

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

    public OrderResponse getOrder(Integer code) {
        Order order = orderRepository.findByCode(code);
        return modelMapper.map(order, OrderResponse.class);
    }
    private Integer generateOrderCode() {
        Integer lastCode = orderRepository.findMaxCode();
        if (lastCode == null) {
            return 50001; // ilk sipariş kodu
        } else {
            return lastCode + 1;
        }
    }

    public Order addOrder(OrderRequest orderRequest) {

        Customer customer = null;
        List<Customer> customers = customerRepository.findAll();
        for (Customer c : customers) {
            if (c.getCode().equals(orderRequest.getCustomerCode())) {
                customer = c;
                break;
            }
        }
        if (customer == null) {
            System.out.println("Customer not found " + orderRequest.getCustomerCode());
            return null;
        }

        Restaurant restaurant = null;
        List<Restaurant> restaurants = restaurantRepository.findAll();
        for (Restaurant r : restaurants) {
            if (r.getCode().equals(orderRequest.getRestaurantCode())) {
                restaurant = r;
                break;
            }
        }
        if (restaurant == null) {
            System.out.println("Restaurant not found " + orderRequest.getRestaurantCode());
            return null;
        }

        Order order = new Order();
        order.setOrderTime(orderRequest.getOrderTime());
        order.setStatus(orderRequest.getStatus());
        order.setTotalPrice(orderRequest.getTotalPrice());
        order.setCustomer(customer);
        order.setRestaurant(restaurant);
        order.setCode(Math.abs(UUID.randomUUID().hashCode()));

        return orderRepository.save(order);
    }
}
