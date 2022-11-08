package az.online.shop.integration.repository;

import static org.assertj.core.api.Assertions.assertThat;

import az.online.shop.dao.OrderRepository;
import az.online.shop.entity.Order;
import az.online.shop.util.IntegrationTestBase;
import az.online.shop.model.Status;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

@RequiredArgsConstructor
class OrderRepositoryIT extends IntegrationTestBase {

    private final OrderRepository orderRepository;

    @Test
    void findAllIfStatusIsActive() {
        Status status = Status.ACTIVE;

        List<Order> actualResult = orderRepository.findAllByStatus(status);
        assertThat(actualResult).hasSize(7);

        List<LocalDate> registrationDates = actualResult.stream().map(Order::getRegistrationDate).toList();
        assertThat(registrationDates).containsExactlyInAnyOrder(
                LocalDate.of(2021, 5, 6),
                LocalDate.of(2022, 6, 7),
                LocalDate.of(2022, 6, 7),
                LocalDate.of(2022, 6, 7),
                LocalDate.of(2022, 6, 7),
                LocalDate.of(2021, 5, 6),
                LocalDate.of(2022, 6, 7));
    }
}
