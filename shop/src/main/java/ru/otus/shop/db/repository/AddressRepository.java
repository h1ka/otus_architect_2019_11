package ru.otus.shop.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.shop.db.entity.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
}
