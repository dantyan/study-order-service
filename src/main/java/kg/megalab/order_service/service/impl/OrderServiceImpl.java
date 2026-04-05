package kg.megalab.order_service.service.impl;

import kg.megalab.order_service.dto.customer.CustomerReadDto;
import kg.megalab.order_service.dto.order.OrderCreateDro;
import kg.megalab.order_service.dto.order.OrderReadDto;
import kg.megalab.order_service.exception.CustomerNotFound;
import kg.megalab.order_service.exception.OrderNotFound;
import kg.megalab.order_service.model.Customer;
import kg.megalab.order_service.model.Order;
import kg.megalab.order_service.repo.CustomerRepository;
import kg.megalab.order_service.repo.OrderRepository;
import kg.megalab.order_service.service.CustomerService;
import kg.megalab.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public OrderReadDto save(OrderCreateDro orderCreateDro) throws CustomerNotFound {

        Order order = new Order();
        order.setDescription(orderCreateDro.getDescription());
        order.setAmount(orderCreateDro.getAmount());

        Long customerId = orderCreateDro.getCustomerId();
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFound(customerId));

        order.setCustomer(customer);
        order = orderRepository.save(order);

        return toOrderReadDto(order);
    }

    @Override
    public List<OrderReadDto> findAll() {
        return orderRepository.findAll().stream().map(this::toOrderReadDto).toList();
    }

    @Override
    public OrderReadDto findById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new OrderNotFound(id));
        return toOrderReadDto(order);
    }

    @Override
    public List<OrderReadDto> findByCustomerId(Long customerId) {
        return orderRepository.findAllByCustomerId(customerId).stream().map(this::toOrderReadDto).toList();
    }

    private OrderReadDto toOrderReadDto(Order order) {
        OrderReadDto orderReadDto = new OrderReadDto();
        orderReadDto.setId(order.getId());
        orderReadDto.setDescription(order.getDescription());
        orderReadDto.setAmount(order.getAmount());

        Customer customer = order.getCustomer();
        CustomerReadDto customerReadDto = customerService.toCustomerReadDto(customer);

        orderReadDto.setCustomer(customerReadDto);
        return orderReadDto;
    }
}
