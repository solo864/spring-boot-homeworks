package az.online.shop.integration.repository;

import az.online.shop.annotations.IT;
import az.online.shop.dao.PersonalInfoRepository;
import az.online.shop.entity.PersonalInfo;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@IT
@RequiredArgsConstructor
class PersonalInfoRepositoryIT {

    private final PersonalInfoRepository personalInfoRepository;

    @Test
    void getByIdIfPersonalInfoExist() {
        Optional<PersonalInfo> actualResult = personalInfoRepository.findById(1);
        Assertions.assertThat(actualResult).isPresent();
    }

    @Test
    void getByIdIfPersonalInfoIsNotExist() {
        Optional<PersonalInfo> actualResult = personalInfoRepository.findById(Integer.MAX_VALUE);
        Assertions.assertThat(actualResult).isNotPresent();
    }
}