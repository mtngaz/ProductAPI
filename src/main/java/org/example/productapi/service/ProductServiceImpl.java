package org.example.productapi.service;

import org.example.productapi.controller.ProductController;
import org.example.productapi.entity.Product;
import org.example.productapi.exception.ProductNotSuchException;
import org.example.productapi.repository.ProductRepository;
import org.example.productapi.validation.ProductValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Реализация сервиса для управления продуктами.
 * Использует {@link ProductRepository} для выполнения CRUD операций.
 */
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    /**
     * Конструктор сервиса продукта.
     *
     * @param productRepository репозиторий для управления продуктами.
     */
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Product> findById(Long id) {
        if (!productRepository.existsById(id)) {
            logger.error("A product with this id: " + id + " was not found");
            throw new ProductNotSuchException("A product with this id: " + id + " was not found");
        }
        return productRepository.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Product product) {
        ProductValidator.isProduct(product);
        productRepository.save(product);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(Long id, Product product) {
        if (!productRepository.existsById(id)) {
            logger.error("A product with this id: " + id + " was not found");
            throw new ProductNotSuchException("A product with this id: " + id + " was not found");
        }
        ProductValidator.isProduct(product);
        product.setId(id);
        productRepository.save(product);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Long id) {
        if (!productRepository.existsById(id)) {
            logger.error("A product with this id: " + id + " was not found");
            throw new ProductNotSuchException("A product with this id: " + id + " was not found");
        }
        productRepository.deleteById(id);
    }
}
