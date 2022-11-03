package az.online.shop.integration.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import az.online.shop.annotations.IT;
import az.online.shop.dto.CustomerReadDto;
import az.online.shop.entity.Customer;
import az.online.shop.mapper.CustomerReadMapper;
import az.online.shop.mapper.OrderReadMapper;
import az.online.shop.model.Role;
import az.online.shop.util.TestDataImporter;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@IT
@RequiredArgsConstructor
class CustomerReadMapperTest {

    private final OrderReadMapper orderReadMapper;
    private final CustomerReadMapper customerReadMapper;

    @Test
    void mapEntityToDto() {
        var expectedResult = new Customer("test", "test", "test@gmail.com", "test123", LocalDate.now(), Role.ADMIN, null,
                List.of(TestDataImporter.getClevelandOrders().get(0)));
        CustomerReadDto actualResult = customerReadMapper.mapFrom(expectedResult);

        Assertions.assertAll((
                ) -> assertThat(actualResult.firstName()).isEqualTo(expectedResult.getFirstName()),
                () -> assertThat(actualResult.birthDate()).isEqualTo(expectedResult.getBirthDate()),
                () -> assertThat(actualResult.role()).isEqualTo(expectedResult.getRole())
        );
    }

    @Test
    void mapEntitiesToDtos() {
        var expectedResults = List.of(TestDataImporter.getCleveland(), TestDataImporter.getIsobelle());
        List<CustomerReadDto> actualResults = customerReadMapper.mapFrom(expectedResults);

        for (int i = 0; i < actualResults.size(); i++) {
            assertThat(actualResults.get(i).firstName()).isEqualTo(expectedResults.get(i).getFirstName());
            assertThat(actualResults.get(i).birthDate()).isEqualTo(expectedResults.get(i).getBirthDate());
            assertThat(actualResults.get(i).role()).isEqualTo(expectedResults.get(i).getRole());
        }
    }
}