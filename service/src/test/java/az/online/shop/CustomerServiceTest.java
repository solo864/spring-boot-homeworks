package az.online.shop;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import az.online.shop.dao.CustomerRepository;
import az.online.shop.dto.CustomerCreateDto;
import az.online.shop.dto.CustomerReadDto;
import az.online.shop.entity.Customer;
import az.online.shop.mapper.CustomerCreateMapper;
import az.online.shop.mapper.CustomerReadMapper;
import az.online.shop.model.Role;
import az.online.shop.model.Status;
//import az.online.shop.service.CustomerService;
import az.online.shop.util.TestDataImporter;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private CustomerReadMapper customerReadMapper;
    @Mock
    private CustomerCreateMapper customerCreateMapper;
    @InjectMocks
    private CustomerService customerService;

    @Test
    void create() {
        var customerCreateDto = new CustomerCreateDto(null, "test", "test", "test", "test", Role.ADMIN, LocalDate.now());
        var customer = TestDataImporter.getCleveland();

        when(customerCreateMapper.mapFrom(customerCreateDto)).thenReturn(customer);
        when(customerRepository.save(customer)).thenReturn(customer);

        Integer actualId = customerService.create(customerCreateDto);
        assertThat(actualId).isEqualTo(customer.getId());
    }

    @Test
    void getAllCustomersByOrderStatus() {
        var status = Status.ACTIVE;
        List<Customer> customers = List.of(TestDataImporter.getCleveland());
        List<CustomerReadDto> dto = List.of(new CustomerReadDto(1, "test", "test", LocalDate.now(), Role.ADMIN, Collections.emptyList()));

        when(customerRepository.findAllCustomersByStatus(status)).thenReturn(customers);
        when(customerReadMapper.mapFrom(customers)).thenReturn(dto);

        List<CustomerReadDto> actualResult = customerService.getAllCustomersByOrderStatus(status);
        assertThat(actualResult).hasSize(1);
        List<String> firstNames = actualResult.stream().map(CustomerReadDto::firstName).toList();
        assertThat(firstNames).containsExactlyInAnyOrder("test");
    }
}
