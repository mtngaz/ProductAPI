package org.example.productapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Класс-сущность, представляющий продукт.
 * Используется для хранения информации о продуктах в базе данных.
 */
@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    /**
     * Уникальный идентификатор продукта.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Название продукта.
     * Поле не может быть пустым.
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Описание продукта.
     * Максимальная длина составляет 4096 символов.
     */
    @Column(name = "description", length = 4096)
    private String description;

    /**
     * Цена продукта.
     */
    @Column(name = "price")
    private double price;

    /**
     * Наличие продукта на складе.
     * Поле true, если продукт доступен, и false в противном случае.
     */
    @Column(name = "availability")
    private boolean availability;
}
