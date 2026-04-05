package kg.megalab.order_service.service.impl;

import kg.megalab.order_service.dto.customer.CustomerCreateDto;
import kg.megalab.order_service.dto.customer.CustomerReadDto;
import kg.megalab.order_service.exception.CustomerNotFond;
import kg.megalab.order_service.model.Customer;
import kg.megalab.order_service.repo.CustomerRepository;
import kg.megalab.order_service.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerReadDto save(CustomerCreateDto customerCreateDto) {

        Customer customer = new Customer();
        customer.setName(customerCreateDto.getName());
        customer.setEmail(customerCreateDto.getEmail());

        customer = customerRepository.save(customer);

        CustomerReadDto customerReadDto = new CustomerReadDto();
        customerReadDto.setId(customer.getId());
        customerReadDto.setName(customer.getName());
        customerReadDto.setEmail(customer.getEmail());

        return customerReadDto;
    }

    @Override
    public List<CustomerReadDto> findAll() {
        return customerRepository.findAll().stream().map(this::toCustomerReadDto).toList();
    }

    @Override
    public CustomerReadDto findById(Long id) throws CustomerNotFond {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new CustomerNotFond(id));
        return toCustomerReadDto(customer);
    }

    private CustomerReadDto toCustomerReadDto(Customer customer) {
        CustomerReadDto customerReadDto = new CustomerReadDto();
        customerReadDto.setId(customer.getId());
        customerReadDto.setName(customer.getName());
        customerReadDto.setEmail(customer.getEmail());
        return customerReadDto;
    }

}
