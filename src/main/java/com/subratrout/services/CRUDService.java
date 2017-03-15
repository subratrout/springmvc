package com.subratrout.services;

import java.util.List;

/**
 * Created by subratrout on 3/14/17.
 */
public interface CRUDService<T> {
    List<?> listAll();

    T getById(Integer id);

    T saveOrUpdate(T domainObject);

    void delete(Integer id);
}
