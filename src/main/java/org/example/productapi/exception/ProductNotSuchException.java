package org.example.productapi.exception;

/**
 * Исключение, выбрасываемое при отсутствии продукта с заданным идентификатором.
 */
public class ProductNotSuchException extends RuntimeException {
    /**
     * Конструктор с сообщением об ошибке.
     *
     * @param message сообщение об ошибке.
     */
    public ProductNotSuchException(String message) {
        super(message);
    }
}
