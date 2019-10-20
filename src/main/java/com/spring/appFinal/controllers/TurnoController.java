package com.spring.appFinal.controllers;

import com.spring.appFinal.models.entity.Cliente;
import com.spring.appFinal.models.entity.Turno;
import com.spring.appFinal.models.service.IClienteService;
import com.spring.appFinal.models.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("turno")
public class TurnoController {

    @Autowired
    ITurnoService turnoService;

    @Autowired
    IClienteService clienteService;


    @GetMapping(value = "/formturno/{id}")
    public String crear(@PathVariable(value = "id") int id, Model model){
        Cliente cliente = clienteService.buscarUno(id);
        Turno turno = new Turno();
        turno.setCliente(cliente);
        model.addAttribute("titulo", "Gestion de Turnos");
        model.addAttribute("turno", turno);
        model.addAttribute("cliente", cliente);
        return "formturno";
    }


    @PostMapping(value = "/formturno")
    public String guardar(Turno turno){
        turnoService.guardar(turno);
        return "redirect:/listar";
    }

    @GetMapping(value = "/listaturnos")
    public String listaTurnos(Model model){
        model.addAttribute("titulo", "Listado de turnos");
        model.addAttribute("turnos", turnoService.listar());

        return "listaturnos";
    }

}
