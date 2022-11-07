    package az.online.shop.test;

    import static org.mockito.Mockito.when;

    import az.online.shop.dao.CustomerRepository;
    import az.online.shop.dto.CustomerCreateDto;
    import az.online.shop.mapper.CustomerCreateMapper;
    import az.online.shop.mapper.CustomerReadMapper;
    import az.online.shop.model.Role;
    import az.online.shop.service.CustomerService;
    import az.online.shop.util.TestDataImporter;
    import java.time.LocalDate;
    import org.assertj.core.api.Assertions;
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
        void test() {
            CustomerCreateDto customerCreateDto =
                    new CustomerCreateDto(null, "Anar", "Musayev", "anarmusayeev@gmail.com", "Anar1337", Role.ADMIN, LocalDate.now());
            var customer = TestDataImporter.getCleveland();

            when(customerCreateMapper.mapFrom(customerCreateDto)).thenReturn(customer);
            when(customerRepository.save(customer)).thenReturn(customer);

            Integer actualResult = customerService.create(customerCreateDto);
            Assertions.assertThat(actualResult).isEqualTo(customer.getId());
        }


    }
