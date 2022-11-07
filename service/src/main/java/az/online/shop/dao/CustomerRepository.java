package az.online.shop.dao;

import az.online.shop.entity.Customer;
import az.online.shop.model.Status;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select distinct c from Customer c join c.orders o where o.status= :status")
    List<Customer> findAllByStatus(Status status);
}
