package az.online.shop.dao;

import az.online.shop.entity.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("select p from Product p join p.orderProducts op where op.count>:count")
    List<Product> findAllByWhereCountMoreThan(Integer count);
}