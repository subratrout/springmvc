package com.subratrout.repositories;

import com.subratrout.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by subratrout on 4/7/17.
 */
public interface UserRepository extends CrudRepository<User, Integer>{
}
