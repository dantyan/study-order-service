package kg.megalab.order_service.service;


import kg.megalab.order_service.dto.order.OrderCreateDro;
import kg.megalab.order_service.dto.order.OrderReadDto;
import kg.megalab.order_service.exception.CustomerNotFound;
import kg.megalab.order_service.model.Order;
import org.jspecify.annotations.NonNull;

import java.util.List;

public interface OrderService {
    Order save(OrderCreateDro orderCreateDro) throws CustomerNotFound;

    List<Order> findAll();

    Order findById(Long id);

    List<Order> findByCustomerId(Long customerId);

    @NonNull OrderReadDto toOrderReadDto(@NonNull Order order);
}
