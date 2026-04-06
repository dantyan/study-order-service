package kg.megalab.order_service.service.impl;

import kg.megalab.order_service.dto.customer.CustomerCreateDto;
import kg.megalab.order_service.dto.customer.CustomerReadDto;
import kg.megalab.order_service.exception.CustomerNotFound;
import kg.megalab.order_service.model.Customer;
import kg.megalab.order_service.repo.CustomerRepository;
import kg.megalab.order_service.service.CustomerService;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer save(CustomerCreateDto customerCreateDto) {

        Customer customer = new Customer();
        customer.setName(customerCreateDto.getName());
        customer.setEmail(customerCreateDto.getEmail());

        customer = customerRepository.save(customer);

        return customer;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) throws CustomerNotFound {
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFound(id));
    }

    @Override
    public @NonNull CustomerReadDto toCustomerReadDto(@NonNull Customer customer) {
        CustomerReadDto customerReadDto = new CustomerReadDto();
        customerReadDto.setId(customer.getId());
        customerReadDto.setName(customer.getName());
        customerReadDto.setEmail(customer.getEmail());
        return customerReadDto;
    }
}
