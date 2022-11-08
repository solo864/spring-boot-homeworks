package az.online.shop.unit.mapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import az.online.shop.dto.CustomerReadDto;
import az.online.shop.dto.OrderReadDto;
import az.online.shop.entity.Customer;
import az.online.shop.entity.Order;
import az.online.shop.mapper.CustomerReadMapper;
import az.online.shop.mapper.OrderReadMapper;
import az.online.shop.model.Role;
import az.online.shop.model.Status;
import az.online.shop.util.TestDataImporter;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CustomerReadMapperTest {

    @Mock
    private OrderReadMapper orderReadMapper;
    @InjectMocks
    private CustomerReadMapper customerReadMapper;

    @Test
    void mapEntityToDto() {
        List<Order> orders = TestDataImporter.getIsobelleOrders();
        Customer customer = new Customer("test", "test", "test@gmail.com", "test123", LocalDate.now(), Role.ADMIN, null, orders);
        CustomerReadDto customerReadDto =
                new CustomerReadDto(1, "Anar", "Musayev", LocalDate.now(), Role.ADMIN, List.of(new OrderReadDto(1, LocalDate.now(), LocalDate.now(),
                        Status.ACTIVE)));
        var orderReadDto = new OrderReadDto(1, LocalDate.now(), LocalDate.now(), Status.ACTIVE);

        when(orderReadMapper.mapFrom(customer.getOrders())).thenReturn(List.of(orderReadDto));

        CustomerReadDto actualResult = customerReadMapper.mapFrom(customer);
        assertThat(actualResult).isNotNull();
        assertThat(actualResult.firstName()).isEqualTo("test");
    }
}