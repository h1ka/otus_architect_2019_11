package ru.otus.shop.db.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.shop.db.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long>, QuerydslPredicateExecutor<Order> {
}
