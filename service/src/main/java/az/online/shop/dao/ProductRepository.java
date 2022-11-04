package az.online.shop.dao;

import static az.online.shop.entity.OrderProduct_.COUNT;

import az.online.shop.entity.Product;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository extends RepositoryBase<Integer, Product> {

    public ProductRepository(EntityManager entityManager) {
        super(Product.class, entityManager);
    }

    public List<Product> findAllWhereCountMoreThan(Integer count) {
        return getEntityManager().createQuery("""
                        select p 
                        from Product p
                        inner join 
                        p.orderProducts op 
                        where op.count> :count
                        """, Product.class)
                .setParameter(COUNT, count)
                .getResultList();
    }
}