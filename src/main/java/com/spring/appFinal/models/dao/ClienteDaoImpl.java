package com.spring.appFinal.models.dao;

import com.spring.appFinal.models.entity.Cliente;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ClienteDaoImpl implements IClienteDao {

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")

    @Override
    public List<Cliente> listar() {
        return em.createQuery("from Cliente").getResultList();
    }

    @Override
    public void guardar(Cliente cliente) {
        if (cliente.getId() != 0){
            em.merge(cliente);
        }
        else{
            em.persist(cliente);
        }

    }

    @Override
    public Cliente buscarUno(int id) {
        return em.find(Cliente.class, id);
    }

    @Override
    public void eliminar(int id) {

        em.remove(buscarUno(id));
    }
}
