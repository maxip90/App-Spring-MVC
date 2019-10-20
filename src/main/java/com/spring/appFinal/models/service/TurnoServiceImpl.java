package com.spring.appFinal.models.service;

import com.spring.appFinal.models.dao.ITurnoDao;
import com.spring.appFinal.models.entity.Tarea;
import com.spring.appFinal.models.entity.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TurnoServiceImpl implements ITurnoService {

    @Autowired
    private ITurnoDao turnoDao;

    @Transactional(readOnly = true)
    @Override
    public List<Turno> listar() {
        return turnoDao.listar();
    }

    @Override
    @Transactional
    public void guardar(Turno turno) {
        turnoDao.guardar(turno);
    }

    @Override
    @Transactional(readOnly = true)
    public Turno buscarUno(int id) {
        return turnoDao.buscarUno(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Tarea> buscarTodas() {
        return turnoDao.buscarTodas();
    }
}
