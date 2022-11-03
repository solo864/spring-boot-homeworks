package az.online.shop.mapper;

import az.online.shop.dto.ProductReadDto;
import az.online.shop.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductReadMapper implements Mapper<Product, ProductReadDto> {

    @Override
    public ProductReadDto mapFrom(Product product) {
        return ProductReadDto.builder()
                .description(product.getDescription())
                .name(product.getName())
                .price(product.getPrice())
                .remainingQuantity(product.getRemainingQuantity())
                .build();
    }
}