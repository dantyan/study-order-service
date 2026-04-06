package kg.megalab.order_service.controller;


import kg.megalab.order_service.dto.order.OrderCreateDro;
import kg.megalab.order_service.dto.order.OrderReadDto;
import kg.megalab.order_service.exception.CustomerNotFound;
import kg.megalab.order_service.exception.OrderNotFound;
import kg.megalab.order_service.model.Customer;
import kg.megalab.order_service.service.CustomerService;
import kg.megalab.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody OrderCreateDro orderCreateDro) {
        try {
            OrderReadDto orderReadDto = orderService.toOrderReadDto(orderService.save(orderCreateDro));
            return ResponseEntity.ok(orderReadDto);
        } catch (CustomerNotFound e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<OrderReadDto> orderReadDto = orderService.findAll().stream().map(order -> orderService.toOrderReadDto(order)).toList();
        return ResponseEntity.ok(orderReadDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            OrderReadDto orderReadDto = orderService.toOrderReadDto(orderService.findById(id));
            return ResponseEntity.ok(orderReadDto);
        } catch (OrderNotFound e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<?> findByCustomerId(@PathVariable Long customerId) {
        try {
            Customer customer = customerService.findById(customerId);
            List<OrderReadDto> orderReadDto = orderService.findByCustomerId(customer.getId()).stream().map(order -> orderService.toOrderReadDto(order)).toList();
            return ResponseEntity.ok(orderReadDto);
        } catch (CustomerNotFound exc) {
            return ResponseEntity.notFound().build();
        }
    }
}
