package ru.otus.shop.service;

import ru.otus.shop.db.entity.Order;

import java.util.List;

/**
 * Описывает сервис работы с заказами
 */
public interface OrderService {


    //todo :: add filer
    List<Order> getByFilter();

    /**
     * Возвращает заказ по его идентификатору
     *
     * @param orderId Идентификатор заказа
     * @return заказ
     */
    Order getById(Long orderId);

    /**
     * Возвращает список всех заказов
     *
     * @return список заказов
     */
    List<Order> getAllOrders();

    /**
     * Создает заказ
     *
     * @param order заказ
     * @return созданный заказ
     */
    Order create(Order order);

    /**
     * Обновляет заказ
     *
     * @param orderId Идентификатор заказа
     * @param order   заказ
     */
    void updateById(Long orderId, Order order);
}
