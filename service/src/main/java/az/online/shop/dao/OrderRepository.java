package az.online.shop.dao;

import az.online.shop.entity.Order;
import az.online.shop.model.Status;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findAllByStatus(Status status);
}
