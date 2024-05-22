package org.example.productapi.repository;

import org.example.productapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для управления сущностями {@link Product}.
 * Предоставляет методы для выполнения CRUD операций.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
