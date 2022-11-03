package az.online.shop.service;

import az.online.shop.dao.PersonalInfoRepository;
import az.online.shop.dto.PersonalInfoReadDto;
import az.online.shop.mapper.PersonalInfoMapper;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonalInfoService {

    private final PersonalInfoRepository personalInfoRepository;
    private final PersonalInfoMapper personalInfoMapper;

    public Optional<PersonalInfoReadDto> getById(Integer id) {
        return personalInfoRepository.findById(id)
                .map(personalInfoMapper::mapFrom);
    }
}