package com.subratrout.services.reposervices;

import com.subratrout.domain.security.Role;
import com.subratrout.repositories.RoleRepository;
import com.subratrout.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by subratrout on 4/7/17.
 */
@Service
@Profile("springdatajpa")
public class RoleServiceRepoImpl implements RoleService {

    private RoleRepository roleRepsoitory;

    @Autowired
    public void setRoleRepsoitory(RoleRepository roleRepsoitory) {
        this.roleRepsoitory = roleRepsoitory;
    }


    @Override
    public List<?> listAll() {
        List<Role> roles = new ArrayList<>();
        roleRepsoitory.findAll().forEach(roles::add);
        return roles;
    }

    @Override
    public Role getById(Integer id) {
        return roleRepsoitory.findOne(id);
    }

    @Override
    public Role saveOrUpdate(Role domainObject) {
        return roleRepsoitory.save(domainObject);
    }

    @Override
    public void delete(Integer id) {
        roleRepsoitory.delete(id);
    }
}
