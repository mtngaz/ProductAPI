package org.example.productapi.controller;

import org.example.productapi.entity.Product;
import org.example.productapi.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер для управления продуктами.
 * Обрабатывает HTTP-запросы для выполнения операций CRUD с сущностями {@link Product}.
 */
@RestController
@RequestMapping("/api")
public class ProductController {
    private final ProductService productService;
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    /**
     * Конструктор контроллера продукта.
     *
     * @param productService сервис для управления продуктами.
     */
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Возвращает список всех продуктов.
     *
     * @return список всех продуктов.
     */
    @GetMapping("/products")
    public List<Product> findAllProduct() {
        logger.info("Fetching all products");
        return productService.findAllProduct();
    }

    /**
     * Возвращает продукт по заданному идентификатору.
     *
     * @param id идентификатор продукта.
     * @return продукт с заданным идентификатором.
     */
    @GetMapping("/products/{id}")
    public Product findById(@PathVariable Long id) {
        logger.info("Fetching product with id:" + id);
        return productService.findById(id).get();
    }

    /**
     * Сохраняет новый продукт.
     *
     * @param product продукт для сохранения.
     * @return ответ с сообщением об успешном сохранении.
     */
    @PostMapping("/products")
    public ResponseEntity<String> save(@RequestBody Product product) {
        logger.info("Saving product: " + product);
        productService.save(product);
        logger.info("The product was saved successfully");
        return ResponseEntity.ok("The product was saved successfully");
    }

    /**
     * Обновляет продукт с заданным идентификатором.
     *
     * @param id      идентификатор продукта для обновления.
     * @param product обновленные данные продукта.
     * @return ответ с сообщением об успешном обновлении.
     */
    @PutMapping("/products/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Product product) {
        logger.info("Updating product with id: " + id);
        productService.update(id, product);
        logger.info("The product was update successfully");
        return ResponseEntity.ok("The product was update successfully");
    }

    /**
     * Удаляет продукт с заданным идентификатором.
     *
     * @param id идентификатор продукта для удаления.
     * @return ответ с сообщением об успешном удалении.
     */
    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        logger.info("Deleting product with id: " + id);
        productService.delete(id);
        logger.info("The product was delete successfully");
        return ResponseEntity.ok("The product was delete successfully");
    }
}
