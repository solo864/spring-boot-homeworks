package az.online.shop.dto;

import az.online.shop.entity.PersonalInfo;
import az.online.shop.model.Role;
import java.time.LocalDate;

public record CustomerCreateDto(PersonalInfo personalInfo,
                                String firstName,
                                String surname,
                                String email,
                                String password,
                                Role role,
                                LocalDate birthDate) {
}