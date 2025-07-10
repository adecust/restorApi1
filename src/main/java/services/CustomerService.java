package services;

import dto.request.CustomerRequest;
import dto.response.CustomerResponse;
import model.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CustomerRepository;

import java.time.LocalDateTime;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CustomerResponse getCustomer(Integer code) {
        Customer customer = customerRepository.findByCode(code);
        return modelMapper.map(customer, CustomerResponse.class);
    }

    public CustomerResponse addCustomer(CustomerRequest request) {
        Customer customer = modelMapper.map(request, Customer.class);
        customer.setCreatedAt(LocalDateTime.now().toString());

        customer = customerRepository.save(customer);
        customer.setCode(10000 + customer.getId().intValue());
        customer = customerRepository.save(customer);

        return modelMapper.map(customer, CustomerResponse.class);
    }
}
