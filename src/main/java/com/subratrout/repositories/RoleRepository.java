package com.subratrout.repositories;

import com.subratrout.domain.security.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by subratrout on 4/7/17.
 */
public interface RoleRepository extends CrudRepository<Role, Integer> {
}
