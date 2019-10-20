package com.spring.appFinal.models.service;

import com.spring.appFinal.models.dao.IClienteDao;
import com.spring.appFinal.models.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private IClienteDao clienteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> listar() {
        return clienteDao.listar();
    }

    @Override
    @Transactional
    public void guardar(Cliente cliente) {
        clienteDao.guardar(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente buscarUno(int id) {
        return clienteDao.buscarUno(id);
    }

    @Override
    @Transactional
    public void eliminar(int id) {
        clienteDao.eliminar(id);
    }
}
