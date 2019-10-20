package com.spring.appFinal.controllers;


import com.spring.appFinal.models.entity.Cliente;
import com.spring.appFinal.models.entity.Turno;
import com.spring.appFinal.models.service.IClienteService;
import com.spring.appFinal.models.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ClienteController {

    @Autowired
    private IClienteService clienteService;
    @Autowired
    private ITurnoService turnoService;


    @GetMapping(value = "/listar")
    public String listar(Model model){
        model.addAttribute("titulo", "Listado de clientes");
        model.addAttribute("clientes" , clienteService.listar());
        return "listar";
    }

    @GetMapping(value = "/form")
    public String crear(Model model){

        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
        model.addAttribute("titulo", "Formulario de Cliente");

        return "form";
    }

    @PostMapping(value = "/form")
    public String guardar(Cliente cliente){
        clienteService.guardar(cliente);
        return "redirect:listar";
    }

    @GetMapping(value = "/form/{id}")
    public String editar(@PathVariable(value = "id") int id, Model model ){
        Cliente cliente = null;
        if(id>0){
            cliente = clienteService.buscarUno(id);

        }
        else {
            return "redirect:/listar";
        }
        model.addAttribute("titulo", "Editar Cliente");
        model.addAttribute("cliente", cliente);
        return "form";
    }


    @GetMapping(value = "/ver/{id}")
    public String ver(@PathVariable(value = "id") int id, Model model, RedirectAttributes flash){
        Cliente cliente = clienteService.buscarUno(id);
        if (cliente == null){
            flash.addFlashAttribute("error", "El Cliente no existe en la base de datos" );
            return "redirect:/listar";
        }

        model.addAttribute("cliente", cliente);
        model.addAttribute("titulo", "Detalle del Tunno del Cliente " + cliente.getNombre());
        return "ver";
    }

    @GetMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") int id){
        if (id>0){
            clienteService.eliminar(id);
        }
        return "redirect:/listar";
    }

    /**
    @GetMapping(value = "/formturno/{id}")
    public String asigar(@PathVariable(value = "id") int id, Model model){
        Cliente cliente = clienteService.buscarUno(id);
        model.addAttribute("titulo", "Gestion de Turnos");
        model.addAttribute("cliente", cliente);
        return "formturno";
    }

    @PostMapping(value = "/formturno")
    public String crearT(Model model){
        Turno turno = new Turno();

        return "";
    }*/
}
