package ru.otus.shop.db.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.shop.db.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>, QuerydslPredicateExecutor<Product> {
}
