package com.subratrout.services.mapservices;

import com.subratrout.domain.DomainObject;
import com.subratrout.domain.User;
import com.subratrout.services.UserService;

import java.util.List;

/**
 * Created by subratrout on 3/29/17.
 */
public class UserServiceMapImpl extends AbstractMapService implements UserService {

    @Override
    public List<DomainObject> listAll(){
        return super.listAll();
    }

    @Override
    public User getById(Integer id){
        return (User) super.getById(id);
    }

    @Override
    public User saveOrUpdate(User domainObject) {
        return (User) super.saveOrUpdate(domainObject);
    }

    @Override
    public  void delete(Integer id){
        super.delete(id);
    }

    @Override
    protected void loadDomainObjects() {

    }
}
