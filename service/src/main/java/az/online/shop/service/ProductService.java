package az.online.shop.service;

import az.online.shop.dao.ProductRepository;
import az.online.shop.dto.ProductReadDto;
import az.online.shop.mapper.ProductReadMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductReadMapper productReadMapper;

    public List<ProductReadDto> getAllWhereCountMoreThan(Integer count) {
        return productRepository.findAllByWhereCountMoreThan(count)
                .stream().map(productReadMapper::mapFrom).toList();
    }
}