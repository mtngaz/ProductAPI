package org.example.productapi.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * Класс для представления объекта ошибки.
 * Содержит код состояния, сообщение об ошибке и временную метку.
 */
@Data
@AllArgsConstructor
public class ErrObject {
    /**
     * Код состояния HTTP.
     */
    private Integer statusCode;

    /**
     * Сообщение об ошибке.
     */
    private String message;

    /**
     * Временная метка ошибки.
     */
    private Date timestamp;
}
