package kg.megalab.order_service.controller;


import kg.megalab.order_service.dto.customer.CustomerCreateDto;
import kg.megalab.order_service.dto.customer.CustomerReadDto;

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
        CustomerReadDto customerReadDto = customerService.save(customerCreateDto);
        return ResponseEntity.ok(customerReadDto);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<CustomerReadDto> customers = customerService.findAll();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        CustomerReadDto customer = customerService.findById(id);
        return ResponseEntity.ok(customer);
    }
}
