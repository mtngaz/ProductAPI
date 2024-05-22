package org.example.productapi.validation;

import org.example.productapi.controller.ProductController;
import org.example.productapi.entity.Product;
import org.example.productapi.exception.CharacterLimitException;
import org.example.productapi.exception.ProductNameNullException;
import org.example.productapi.exception.ProductPriceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Валидатор для проверки корректности данных продукта.
 */
public class ProductValidator {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    /**
     * Проверяет корректность данных продукта.
     *
     * @param product продукт, который необходимо проверить.
     * @throws ProductNameNullException если имя продукта отсутствует.
     * @throws CharacterLimitException если имя продукта или описание превышают допустимую длину.
     * @throws ProductPriceException если цена продукта меньше 0.
     */
    public static void isProduct(Product product) {
        if (product.getName() == null) {
            logger.error("The product name is required when creating");
            throw new ProductNameNullException("The product name is required when creating");
        }
        if (product.getName().length() > 256 || product.getDescription().length() > 4096) {
            logger.error("The name of the product name or description is exceeded by the number of characters");
            throw new CharacterLimitException("The name of the product name or description is exceeded by the number of characters");
        }
        if (product.getPrice() < 0) {
            logger.error("The price of the product cannot be less than 0");
            throw new ProductPriceException("The price of the product cannot be less than 0");
        }
    }
}
