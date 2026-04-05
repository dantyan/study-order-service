package kg.megalab.order_service.service;


import kg.megalab.order_service.dto.order.OrderCreateDro;
import kg.megalab.order_service.dto.order.OrderReadDto;
import kg.megalab.order_service.exception.CustomerNotFound;

import java.util.List;

public interface OrderService {
    OrderReadDto save(OrderCreateDro orderCreateDro) throws CustomerNotFound;

    List<OrderReadDto> findAll();

    OrderReadDto findById(Long id);

    List<OrderReadDto> findByCustomerId(Long customerId);


}
