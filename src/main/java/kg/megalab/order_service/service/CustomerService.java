package kg.megalab.order_service.service;

import kg.megalab.order_service.dto.customer.CustomerCreateDto;
import kg.megalab.order_service.dto.customer.CustomerReadDto;
import kg.megalab.order_service.exception.CustomerNotFound;
import kg.megalab.order_service.model.Customer;
import org.jspecify.annotations.NonNull;


import java.util.List;


public interface CustomerService {

    Customer save(CustomerCreateDto customer);

    List<Customer> findAll();

    Customer findById(Long id) throws CustomerNotFound;

    @NonNull CustomerReadDto toCustomerReadDto(@NonNull Customer customer);
}
