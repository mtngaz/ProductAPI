package org.example.productapi;

import org.example.productapi.entity.Product;
import org.example.productapi.exception.ProductNameNullException;
import org.example.productapi.exception.ProductNotSuchException;
import org.example.productapi.exception.ProductPriceException;
import org.example.productapi.repository.ProductRepository;
import org.example.productapi.service.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductApiApplicationTests {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    private List<Product> productList;

    @BeforeEach
    void setup() {
        productList = new ArrayList<>();
        productList.add(new Product(1L, "Laptop", "A high-performance laptop suitable for all your computing needs.", 999.99, true));
        productList.add(new Product(2L, "Smartphone", "", 699.99, true));
        productList.add(new Product(3L, "Wireless Mouse", "Ergonomic wireless mouse with long battery life.", 29.99, false));
        productList.add(new Product(4L, "USB-C Cable", "Durable USB-C to USB-A cable, 1 meter long.", 9.99, false));
        productList.add(new Product(5L, "Notebook", "A simple, lined notebook for all your", 0, true));
    }

    @Test
    @DisplayName("Test findAllProduct method")
    public void findAllProductTest() {
        Mockito.doReturn(productList).when(productRepository).findAll();
        List<Product> resultList = productService.findAllProduct();

        Assertions.assertEquals(resultList, productList);
    }

    @Test
    @DisplayName("Test findByIdProduct method")
    public void findByIdProduct() {
        Mockito.doReturn(true).when(productRepository).existsById(2L);
        Mockito.doReturn(Optional.of(productList.get(1))).when(productRepository).findById(2L);

        Optional<Product> optionalProduct = productService.findById(2L);

        Assertions.assertEquals(optionalProduct, Optional.of(productList.get(1)));
    }

    @Test
    @DisplayName("Test findByIdProduct Exceptions method")
    public void findByIdProductThrow() {
        Mockito.when(productRepository.findById(2L)).thenThrow(ProductNotSuchException.class);

        Assertions.assertThrows(ProductNotSuchException.class, () -> {
            productService.findById(2L);
        });
    }

    @Test
    @DisplayName("Test product save with missing name")
    public void shouldThrowExceptionWhenProductNameIsMissing() {
        Product product = new Product(1L, null, "JOIJEOIjfoiwjf", 23.0, true);

        Mockito.when(productRepository.save(product)).thenThrow(ProductNameNullException.class);

        Assertions.assertThrows(ProductNameNullException.class, () -> {
            productRepository.save(product);
        });
    }

    @Test
    @DisplayName("Test product creation with negative price")
    public void shouldThrowExceptionWhenProductPriceIsNegative() {
        Product product = new Product(1L, "product", "JOIJEOIjfoiwjf", -23.0, true);

        Mockito.when(productRepository.save(product)).thenThrow(ProductPriceException.class);

        Assertions.assertThrows(ProductPriceException.class, () -> {
            productRepository.save(product);
        });
    }

}
