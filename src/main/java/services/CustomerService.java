package services;

import dto.CustomerDTO;
import model.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CustomerDTO getCustomer(Integer code) {
        Customer customer = customerRepository.findByCode(code);
        return modelMapper.map(customer, CustomerDTO.class);
    }

    public CustomerDTO addCustomer(CustomerDTO dto) {
        Customer customer = modelMapper.map(dto, Customer.class);
        customer = customerRepository.save(customer);
        customer.setCode(10000 + customer.getId().intValue());
        customer = customerRepository.save(customer);
        return modelMapper.map(customer, CustomerDTO.class);
    }
}
