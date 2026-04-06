package kg.megalab.order_service.service.impl;

import kg.megalab.order_service.dto.customer.CustomerReadDto;
import kg.megalab.order_service.dto.order.OrderCreateDro;
import kg.megalab.order_service.dto.order.OrderReadDto;
import kg.megalab.order_service.exception.CustomerNotFound;
import kg.megalab.order_service.exception.OrderNotFound;
import kg.megalab.order_service.model.Customer;
import kg.megalab.order_service.model.Order;
import kg.megalab.order_service.repo.OrderRepository;
import kg.megalab.order_service.service.CustomerService;
import kg.megalab.order_service.service.OrderService;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerService customerService;


    @Override
    public Order save(OrderCreateDro orderCreateDro) throws CustomerNotFound {

        Order order = new Order();
        order.setDescription(orderCreateDro.getDescription());
        order.setAmount(orderCreateDro.getAmount());

        Long customerId = orderCreateDro.getCustomerId();
        Customer customer = customerService.findById(customerId);

        order.setCustomer(customer);
        order = orderRepository.save(order);

        return order;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new OrderNotFound(id));
    }

    @Override
    public List<Order> findByCustomerId(Long customerId) {
        return orderRepository.findAllByCustomerId(customerId);
    }

    @Override
    public @NonNull OrderReadDto toOrderReadDto(@NonNull Order order) {
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
