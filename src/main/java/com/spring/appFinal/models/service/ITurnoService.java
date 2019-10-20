package com.spring.appFinal.models.service;


import com.spring.appFinal.models.entity.Tarea;
import com.spring.appFinal.models.entity.Turno;

import java.util.List;

public interface ITurnoService {

    public List<Turno> listar();

    public void guardar(Turno turno);

    public Turno buscarUno(int id);

    public List<Tarea> buscarTodas();
}
