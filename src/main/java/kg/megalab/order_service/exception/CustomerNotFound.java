package kg.megalab.order_service.exception;

public class CustomerNotFound extends RuntimeException {
    public CustomerNotFound(Long id) {
        super("Customer not fond with id " + id);
    }
}
