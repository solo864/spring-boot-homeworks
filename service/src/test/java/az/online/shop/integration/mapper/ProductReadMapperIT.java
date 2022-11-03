package az.online.shop.integration.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import az.online.shop.annotations.IT;
import az.online.shop.dto.ProductReadDto;
import az.online.shop.mapper.ProductReadMapper;
import az.online.shop.util.TestDataImporter;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@IT
@RequiredArgsConstructor
class ProductReadMapperIT {

    private final ProductReadMapper productReadMapper;

    @Test
    void mapEntityToDto() {
        var expectedResult = TestDataImporter.getProducts().get(0);
        ProductReadDto actualResult = productReadMapper.mapFrom(expectedResult);

        Assertions.assertAll(
                () -> assertThat(actualResult.description()).isEqualTo(expectedResult.getDescription()),
                () -> assertThat(actualResult.name()).isEqualTo(expectedResult.getName()),
                () -> assertThat(actualResult.price()).isEqualTo(expectedResult.getPrice()),
                () -> assertThat(actualResult.remainingQuantity()).isEqualTo(expectedResult.getRemainingQuantity())
        );
    }
}