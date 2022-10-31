package az.online.shop.integration.repository;

import static org.assertj.core.api.Assertions.assertThat;

import az.online.shop.annotations.IT;
import az.online.shop.dao.CustomerRepository;
import az.online.shop.entity.Customer;
import az.online.shop.model.Status;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

@IT
@RequiredArgsConstructor
class CustomerRepositoryIT {

    private final CustomerRepository customerRepository;

    @Test
    void getAllWhenOrderStatusIsActive() {
        var status = Status.ACTIVE;

        List<Customer> actualResult = customerRepository.findAllCustomersByStatus(status);
        assertThat(actualResult).hasSize(3);

        List<String> names = actualResult.stream().map(Customer::getFirstName).toList();
        assertThat(names).containsExactlyInAnyOrder("Cleveland", "Isobelle", "Findlay");
    }

    @Test
    void findAllByStatusIfStatusInactive() {
        var status = Status.INACTIVE;

        List<Customer> actualResult = customerRepository.findAllCustomersByStatus(Status.INACTIVE);
        assertThat(actualResult).hasSize(2);

        List<String> names = actualResult.stream().map(Customer::getFirstName).toList();
        assertThat(names).containsExactlyInAnyOrder("Findlay", "Cleveland");
    }
}