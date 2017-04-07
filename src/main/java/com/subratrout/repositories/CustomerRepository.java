package com.subratrout.repositories;

import com.subratrout.domain.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by subratrout on 4/7/17.
 */
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
