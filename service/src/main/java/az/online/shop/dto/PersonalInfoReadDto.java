package az.online.shop.dto;

import az.online.shop.model.Gender;
import lombok.Builder;

@Builder
public record PersonalInfoReadDto(String phoneNumber,
                                  String address,
                                  Gender gender) {
}
