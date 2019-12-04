package ru.otus.shop.service.impl;

import com.google.common.collect.Lists;
import com.querydsl.core.BooleanBuilder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.otus.shop.db.entity.Product;
import ru.otus.shop.db.repository.ProductRepository;
import ru.otus.shop.exception.DocumentNotFoundException;
import ru.otus.shop.service.ProductService;
import ru.otus.shop.utils.PaginationUtils;
import ru.otus.shop.web.request.PaginationParams;
import ru.otus.shop.web.request.SortParams;
import ru.otus.shop.web.request.products.ProductFilter;
import ru.otus.shop.web.request.products.ProductGetByFilterRequest;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;
import static ru.otus.shop.db.entity.QProduct.product;

@Service
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductServiceDefault implements ProductService {

    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        Iterable<Product> all = productRepository.findAll();
        return Lists.newArrayList(all);
    }

    @Override
    public Product getById(Long productId) {
        Optional<Product> byId = productRepository.findById(productId);
        return byId.orElseThrow(() -> new DocumentNotFoundException(Product.class.getName(), productId));
    }

    @Override
    public Product create(Product product) {
        Product save = productRepository.save(product);
        return save;
    }

    @Override
    public Product update(Long productId, Product product) {
        Product byId = getById(productId);
        BeanUtils.copyProperties(product, byId, "id");
        return productRepository.save(byId);
    }

    @Override
    public Page<Product> getByFilter(ProductGetByFilterRequest request) {
        ProductFilter filter = request.getFilter();
        BooleanBuilder builder = new BooleanBuilder();
        ofNullable(filter.getName()).ifPresent(name -> builder.and(product.name.eq(name)));
        ofNullable(filter.getCount()).ifPresent((count) -> builder.and(product.count.eq(count)));

        double minPrice = filter.getMinPrice() != null ? filter.getMinPrice() : 0;
        double maxPrice = filter.getMaxPrice() != null ? filter.getMaxPrice() : Double.MAX_VALUE;
        builder.and(product.price.between(minPrice, maxPrice));

        PaginationParams pagination = request.getPagination();
        SortParams sort = request.getSort();

        if (sort != null) {
            return productRepository.findAll(builder, PaginationUtils.createPageRequest(pagination, sort));
        } else {
            return productRepository.findAll(builder, PaginationUtils.createPageRequest(pagination));
        }

    }


}
