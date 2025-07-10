package controller;

import dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{code}")
    public CustomerDTO getCustomer(@PathVariable Integer code) {
        return customerService.getCustomer(code);
    }

    @PostMapping
    public CustomerDTO addCustomer(@RequestBody CustomerDTO dto) {
        return customerService.addCustomer(dto);
    }
}
