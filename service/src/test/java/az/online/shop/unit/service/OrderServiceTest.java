package az.online.shop.unit.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import az.online.shop.dao.OrderRepository;
import az.online.shop.dto.OrderReadDto;
import az.online.shop.entity.Order;
import az.online.shop.mapper.OrderReadMapper;
import az.online.shop.model.Status;
import az.online.shop.service.OrderService;
import az.online.shop.util.TestDataImporter;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderReadMapper orderReadMapper;
    @Mock
    private OrderRepository orderRepository;
    @InjectMocks
    private OrderService orderService;

    @Test
    void findById() {
        Integer id = 1;
        Order order = TestDataImporter.getIsobelleOrders().get(0);
        OrderReadDto dto = new OrderReadDto(id, LocalDate.now(), LocalDate.now(), Status.ACTIVE);
        when(orderRepository.findById(id)).thenReturn(Optional.of(order));
        when(orderReadMapper.mapFrom(order)).thenReturn(dto);

        Optional<OrderReadDto> actualResult = orderService.findById(id);
        assertThat(actualResult).isPresent();
        assertThat(actualResult).isEqualTo(Optional.of(dto));
    }

    @Test
    void getAllByStatus() {
        var status = Status.ACTIVE;
        List<Order> orders = TestDataImporter.getIsobelleOrders();
        List<OrderReadDto> orderReadDtos = List.of(new OrderReadDto(1, LocalDate.now(), LocalDate.of(2020, 3, 3), Status.ACTIVE));
        when(orderRepository.findAllByStatus(status)).thenReturn(orders);
        when(orderReadMapper.mapFrom(orders)).thenReturn(orderReadDtos);

        List<OrderReadDto> actualResult = orderService.getAllByStatus(status);
        assertThat(actualResult).hasSize(1);
        List<LocalDate> closingDates = actualResult.stream().map(OrderReadDto::closingDate).toList();
        assertThat(closingDates).containsExactlyInAnyOrder(LocalDate.of(2020, 3, 3));
    }
}