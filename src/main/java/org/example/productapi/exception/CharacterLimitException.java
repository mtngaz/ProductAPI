package org.example.productapi.exception;

/**
 * Исключение, выбрасываемое при превышении допустимого лимита символов.
 */
public class CharacterLimitException extends RuntimeException {
    /**
     * Конструктор с сообщением об ошибке.
     *
     * @param message сообщение об ошибке.
     */
    public CharacterLimitException(String message) {
        super(message);
    }
}
