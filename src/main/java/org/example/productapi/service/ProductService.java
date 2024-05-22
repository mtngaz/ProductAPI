package org.example.productapi.service;

import org.example.productapi.entity.Product;

import java.util.List;
import java.util.Optional;

/**
 * Интерфейс сервиса для управления продуктами.
 * Определяет методы для выполнения CRUD операций.
 */
public interface ProductService {
    /**
     * Находит продукт по идентификатору.
     *
     * @param id идентификатор продукта.
     * @return найденный продукт, если он существует.
     */
    Optional<Product> findById(Long id);

    /**
     * Возвращает список всех продуктов.
     *
     * @return список всех продуктов.
     */
    List<Product> findAllProduct();

    /**
     * Сохраняет новый продукт.
     *
     * @param product продукт для сохранения.
     */
    void save(Product product);

    /**
     * Обновляет существующий продукт.
     *
     * @param id идентификатор продукта для обновления.
     * @param product обновленные данные продукта.
     */
    void update(Long id, Product product);

    /**
     * Удаляет продукт по идентификатору.
     *
     * @param id идентификатор продукта для удаления.
     */
    void delete(Long id);
}
