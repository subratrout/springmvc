package com.subratrout.repositories;

import com.subratrout.domain.Order;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by subratrout on 4/7/17.
 */
public interface OrderRepository extends CrudRepository<Order, Integer>{
}
