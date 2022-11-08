package az.online.shop.unit.service;


import static org.assertj.core.api.Assertions.assertThat;

import az.online.shop.dao.PersonalInfoRepository;
import az.online.shop.dto.PersonalInfoReadDto;
import az.online.shop.mapper.PersonalInfoMapper;
import az.online.shop.model.Gender;
import az.online.shop.service.PersonalInfoService;
import az.online.shop.util.TestDataImporter;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PersonalInfoServiceTest {

    @Mock
    private PersonalInfoRepository personalInfoRepository;
    @Mock
    private PersonalInfoMapper personalInfoMapper;
    @InjectMocks
    private PersonalInfoService personalInfoService;

    @Test
    void getById() {
        var id = 1;
        var personalInfoDto = new PersonalInfoReadDto("test", "test", Gender.MALE);
        var personalInfo = TestDataImporter.getClevelandPersonalInfo();

        Mockito.when(personalInfoRepository.findById(id)).thenReturn(Optional.of(personalInfo));
        Mockito.when(personalInfoMapper.mapFrom(personalInfo)).thenReturn(personalInfoDto);

        Optional<PersonalInfoReadDto> actualResult = personalInfoService.getById(id);
        assertThat(actualResult).isPresent();
        actualResult.ifPresent(dto -> assertThat(dto.address()).isEqualTo("test"));

    }
}