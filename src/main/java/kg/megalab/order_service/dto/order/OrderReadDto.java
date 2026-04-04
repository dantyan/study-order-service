package kg.megalab.order_service.dto.order;

import kg.megalab.order_service.dto.customer.CustomerReadDto;

public class OrderReadDto extends OrderBaseDto {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
