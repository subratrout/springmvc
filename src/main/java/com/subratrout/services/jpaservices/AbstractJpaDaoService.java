package com.subratrout.services.jpaservices;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 * Created by subratrout on 3/29/17.
 */
public class AbstractJpaDaoService {

    protected EntityManagerFactory emf;

    @PersistenceUnit
    public  void setEmf(EntityManagerFactory emf){
        this.emf = emf;
    }
}
