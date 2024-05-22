package org.example.productapi.exception;

/**
 * Исключение, выбрасываемое при отсутствии имени продукта.
 */
public class ProductNameNullException extends RuntimeException {
    /**
     * Конструктор с сообщением об ошибке.
     *
     * @param message сообщение об ошибке.
     */
    public ProductNameNullException(String message) {
        super(message);
    }
}
