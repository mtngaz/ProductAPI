package org.example.productapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

/**
 * Глобальный обработчик исключений для обработки исключений в приложении.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Обработчик исключения {@link ProductNotSuchException}.
     *
     * @param ex исключение {@link ProductNotSuchException}.
     * @return ответ с объектом ошибки и статусом NOT_FOUND.
     */
    @ExceptionHandler(ProductNotSuchException.class)
    public ResponseEntity<ErrObject> handleProductNotFoundException(ProductNotSuchException ex) {
        ErrObject errObject = new ErrObject(HttpStatus.NOT_FOUND.value(), ex.getMessage(), new Date());
        return new ResponseEntity<>(errObject, HttpStatus.NOT_FOUND);
    }

    /**
     * Обработчик исключений {@link CharacterLimitException}, {@link ProductNameNullException} и {@link ProductPriceException}.
     *
     * @param ex исключение {@link RuntimeException}.
     * @return ответ с объектом ошибки и статусом BAD_REQUEST.
     */
    @ExceptionHandler({CharacterLimitException.class, ProductNameNullException.class, ProductPriceException.class})
    public ResponseEntity<ErrObject> handleCharacterLimitException(RuntimeException ex) {
        ErrObject errObject = new ErrObject(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), new Date());
        return new ResponseEntity<>(errObject, HttpStatus.BAD_REQUEST);
    }
}
