package az.online.shop.integration.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import az.online.shop.annotations.IT;
import az.online.shop.dto.CustomerCreateDto;
import az.online.shop.entity.PersonalInfo;
import az.online.shop.mapper.CustomerCreateMapper;
import az.online.shop.model.Gender;
import az.online.shop.model.Role;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@IT
@RequiredArgsConstructor
class CustomerCreateMapperTest {

    private final CustomerCreateMapper customerCreateMapper;

    @Test
    void mapDtoToEntity() {
        var expectedResult = new CustomerCreateDto(new PersonalInfo("test", "test", Gender.MALE, null),
                "test", "test", "test@gmail.com", "password", Role.ADMIN, LocalDate.now());

        var actualResult = customerCreateMapper.mapFrom(expectedResult);

        Assertions.assertAll(
                () -> assertThat(actualResult.getPersonalInfo()).isEqualTo(expectedResult.personalInfo()),
                () -> assertThat(actualResult.getPersonalInfo().getPhoneNumber()).isEqualTo(expectedResult.personalInfo().getPhoneNumber()),
                () -> assertThat(actualResult.getPersonalInfo().getAddress()).isEqualTo(expectedResult.personalInfo().getAddress()),
                () -> assertThat(actualResult.getPersonalInfo().getGender()).isEqualTo(expectedResult.personalInfo().getGender()),
                () -> assertThat(actualResult.getFirstName()).isEqualTo(expectedResult.firstName()),
                () -> assertThat(actualResult.getSurname()).isEqualTo(expectedResult.surname()),
                () -> assertThat(actualResult.getEmail()).isEqualTo(expectedResult.email()),
                () -> assertThat(actualResult.getPassword()).isEqualTo(expectedResult.password()),
                () -> assertThat(actualResult.getRole()).isEqualTo(expectedResult.role()),
                () -> assertThat(actualResult.getBirthDate()).isEqualTo(expectedResult.birthDate())
        );
    }
}