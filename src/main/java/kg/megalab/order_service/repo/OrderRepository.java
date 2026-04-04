package kg.megalab.order_service.repo;

import kg.megalab.order_service.model.Customer;
import kg.megalab.order_service.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {}
