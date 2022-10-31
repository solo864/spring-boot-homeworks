package az.online.shop.dao;

import static az.online.shop.entity.Order_.STATUS;

import az.online.shop.entity.Customer;
import az.online.shop.model.Status;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository extends RepositoryBase<Integer, Customer> {

    public CustomerRepository(EntityManager entityManager) {
        super(Customer.class, entityManager);
    }

    public List<Customer> findAllCustomersByStatus(Status status) {
        return getEntityManager().createQuery("""
                        select c
                        from Customer c
                        join c.orders o
                        on o.status= :status
                        """, Customer.class)
                .setParameter(STATUS, status)
                .getResultList();
    }
}