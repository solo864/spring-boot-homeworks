package az.online.shop.unit.service;

import static org.mockito.Mockito.when;

import az.online.shop.dao.ProductRepository;
import az.online.shop.dto.ProductReadDto;
import az.online.shop.mapper.ProductReadMapper;
import az.online.shop.service.ProductService;
import az.online.shop.util.TestDataImporter;
import java.math.BigDecimal;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;
    @Mock
    private ProductReadMapper productReadMapper;
    @InjectMocks
    private ProductService productService;

    @Test
    void getAllWhereCountMoreThan() {
        var count = 1;
        var productReadDto = List.of(new ProductReadDto("test", "test", BigDecimal.ONE, 1));
        var products = List.of(TestDataImporter.getProducts().get(0));

        when(productRepository.findAllByWhereCountMoreThan(count)).thenReturn(products);
        when(productReadMapper.mapFrom(products.get(0))).thenReturn(productReadDto.get(0));

        List<ProductReadDto> actualResult = productService.getAllWhereCountMoreThan(count);
        Assertions.assertThat(actualResult).hasSize(1);

        List<String> descriptions = actualResult.stream().map(ProductReadDto::description).toList();
        Assertions.assertThat(descriptions).containsExactlyInAnyOrder("test");
    }
}
