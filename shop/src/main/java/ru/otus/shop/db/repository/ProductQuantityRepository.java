package ru.otus.shop.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.shop.db.entity.ProductQuantity;

@Repository
public interface ProductQuantityRepository extends CrudRepository<ProductQuantity, Long> {
}
