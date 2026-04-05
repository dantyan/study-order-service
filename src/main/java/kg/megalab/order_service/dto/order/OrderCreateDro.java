package kg.megalab.order_service.dto.order;


public class OrderCreateDro extends OrderBaseDto {
    private Long customerId;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

}
