package ru.otus.shop.service;

import org.springframework.data.domain.Page;
import ru.otus.shop.db.entity.Product;
import ru.otus.shop.web.request.products.ProductGetByFilterRequest;

import java.util.List;

/**
 * Описывает сервис работы с продуктами
 */
public interface ProductService {
    List<Product> getAll();

    /**
     * Возвращает продукт по его идентификатору
     *
     * @param productId Идентификатор продукта
     * @return продукт
     */
    Product getById(Long productId);

    /**
     * Создает продукт
     *
     * @param product сущность продукта
     * @return продукт
     */
    Product create(Product product);

    /**
     * Обновление продукта по его идентификатору
     *
     * @param productId Идентификатор продукта
     * @param product   Сущность продукта
     * @return продукт
     */
    Product update(Long productId, Product product);

    /**
     * Получение списка продуктов по фильтру
     *
     * @param request Запрос на получение продуктов по фильтру
     * @return список продуктов
     */
    Page<Product> getByFilter(ProductGetByFilterRequest request);
}
