package az.online.shop.integration.repository;

import static org.assertj.core.api.Assertions.assertThat;

import az.online.shop.dao.ProductRepository;
import az.online.shop.entity.Product;
import az.online.shop.util.IntegrationTestBase;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

@RequiredArgsConstructor
class ProductRepositoryIT extends IntegrationTestBase {

    private final ProductRepository productRepository;

    @Test
    void findAllWhereCountMoreThanTwo() {
        var count = 2;

        List<Product> actualResult = productRepository.findAllByWhereCountMoreThan(count);
        assertThat(actualResult).hasSize(10);

        List<String> names = actualResult.stream().map(Product::getName).toList();
        assertThat(names).containsExactlyInAnyOrder("test", "test2", "test3", "test4", "test4", "test4", "test7", "test8", "test9", "test10");
    }

    @Test
    void findAllWhereCountMoreThanFifteen() {
        var count = 15;

        List<Product> actualResult = productRepository.findAllByWhereCountMoreThan(count);
        assertThat(actualResult).hasSize(3);

        List<String> names = actualResult.stream().map(Product::getName).toList();
        assertThat(names).containsExactlyInAnyOrder("test3", "test8", "test10");
    }
}