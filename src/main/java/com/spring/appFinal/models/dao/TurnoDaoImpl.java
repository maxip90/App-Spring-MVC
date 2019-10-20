package com.spring.appFinal.models.dao;

import com.spring.appFinal.models.entity.Tarea;
import com.spring.appFinal.models.entity.Turno;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TurnoDaoImpl implements ITurnoDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Turno> listar() {
        return em.createQuery("from Turno").getResultList();
    }

    @Override
    public void guardar(Turno turno) {
        if (turno.getId() != 0){
            em.merge(turno);
        }
        else{
            em.persist(turno);
        }

    }

    @Override
    public Turno buscarUno(int id) {
        return em.find(Turno.class, id);
    }

    @Override
    public List<Tarea> buscarTodas() {
        return em.createQuery("from tareas").getResultList();
    }
}
