package kg.megalab.order_service.dto.customer;

public class CustomerReadDto extends CustomerBaseDto {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
