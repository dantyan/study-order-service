package kg.megalab.order_service.controller;


import kg.megalab.order_service.dto.customer.CustomerCreateDto;
import kg.megalab.order_service.dto.customer.CustomerReadDto;

import kg.megalab.order_service.exception.CustomerNotFound;
import kg.megalab.order_service.model.Customer;
import kg.megalab.order_service.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @PostMapping
    public ResponseEntity<?> create(@RequestBody CustomerCreateDto customerCreateDto) {
        Customer customer = customerService.save(customerCreateDto);
        CustomerReadDto customerReadDto = customerService.toCustomerReadDto(customer);
        return ResponseEntity.ok(customerReadDto);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<CustomerReadDto> customers = customerService.findAll().stream().map(customer -> customerService.toCustomerReadDto(customer)).toList();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            CustomerReadDto customer = customerService.toCustomerReadDto(customerService.findById(id));
            return ResponseEntity.ok(customer);
        } catch (CustomerNotFound exc) {
            return ResponseEntity.notFound().build();
        }
    }
}
