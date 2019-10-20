package com.spring.appFinal.models.dao;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class EmpleadoDaoImpl implements IEmpleadoDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void apruebaTarea() {

    }
}
