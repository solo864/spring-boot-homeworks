package az.online.shop.integration.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import az.online.shop.dto.PersonalInfoReadDto;
import az.online.shop.annotations.IT;
import az.online.shop.util.TestDataImporter;
import az.online.shop.mapper.PersonalInfoMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@IT
@RequiredArgsConstructor
class PersonalInfoMapperTest {

    private final PersonalInfoMapper personalInfoMapper;

    @Test
    void mapEntityToDto() {
        var expectedResult = TestDataImporter.getClevelandPersonalInfo();
        PersonalInfoReadDto actualResult = personalInfoMapper.mapFrom(expectedResult);

        Assertions.assertAll(
                () -> assertThat(actualResult.gender()).isEqualTo(expectedResult.getGender()),
                () -> assertThat(actualResult.address()).isEqualTo(expectedResult.getAddress()),
                () -> assertThat(actualResult.phoneNumber()).isEqualTo(expectedResult.getPhoneNumber())
        );
    }
}