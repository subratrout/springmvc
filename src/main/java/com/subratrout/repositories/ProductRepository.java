package com.subratrout.repositories;

import com.subratrout.domain.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by subratrout on 4/7/17.
 */
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
