package kg.megalab.order_service.model;


import jakarta.persistence.*;

@Entity
@Table(name="orders")
public class Order
{
    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private Double amount;

    @ManyToOne
    private Customer customer;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
