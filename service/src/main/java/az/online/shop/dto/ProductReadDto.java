package az.online.shop.dto;

import java.math.BigDecimal;
import lombok.Builder;

@Builder
public record ProductReadDto(String name,
                             String description,
                             BigDecimal price,
                             Integer remainingQuantity) {
}
