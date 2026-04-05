package kg.megalab.order_service.exception;

public class CustomerNotFond extends RuntimeException {
    public CustomerNotFond(Long id) {
        super("Customer not fond with id " + id);
    }
}
