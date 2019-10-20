package com.spring.appFinal.models.service;

import com.spring.appFinal.models.entity.Cliente;

import java.util.List;

public interface IClienteService {

    public List<Cliente> listar();

    public void guardar(Cliente cliente);

    public Cliente buscarUno(int id);

    public void eliminar(int id);
}
