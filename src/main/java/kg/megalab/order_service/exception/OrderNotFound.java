package kg.megalab.order_service.exception;

public class OrderNotFound extends RuntimeException {
    public OrderNotFound(Long id) {
        super("Could not find order with id " + id);
    }
}
