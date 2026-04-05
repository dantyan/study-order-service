package kg.megalab.order_service.dto.order;

import kg.megalab.order_service.dto.customer.CustomerReadDto;

public class OrderReadDto extends OrderBaseDto {
    private Long id;
    private CustomerReadDto customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerReadDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerReadDto customer) {
        this.customer = customer;
    }
}
