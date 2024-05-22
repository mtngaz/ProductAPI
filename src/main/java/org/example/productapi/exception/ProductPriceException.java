package org.example.productapi.exception;

/**
 * Исключение, выбрасываемое при некорректной цене продукта.
 */
public class ProductPriceException extends RuntimeException {
    /**
     * Конструктор с сообщением об ошибке.
     *
     * @param message сообщение об ошибке.
     */
    public ProductPriceException(String message) {
        super(message);
    }
}
