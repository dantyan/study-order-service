package kg.megalab.order_service.dto.order;

import kg.megalab.order_service.dto.customer.CustomerBaseDto;
import kg.megalab.order_service.dto.customer.CustomerReadDto;

public class OrderBaseDto
{
    private String description;
    private Double amount;
    private CustomerReadDto customer;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public CustomerReadDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerReadDto customer) {
        this.customer = customer;
    }
}
