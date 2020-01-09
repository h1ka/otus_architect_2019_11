package ru.otus.shop.enums;

import lombok.Getter;

/**
 * Статусы заказа
 */
@Getter
public enum OrderStatus {
    CREATED("Заказ создан"),
    ADDRESSED("Добавлен адресс доставки"),
    PAYMENT("Заказ оплачен"),
    DELIVERY("Оформлена доставка"),
    RECEIVED("Заказ получен");


    private String description;

    OrderStatus(String description) {
        this.description = description;
    }
}
