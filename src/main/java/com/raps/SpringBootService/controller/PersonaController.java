package com.raps.SpringBootService.controller;

import com.raps.SpringBootService.Service.PersonaService;
import com.raps.SpringBootService.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/crear")
    public String mostrarFormularioCrear(Model model){
        model.addAttribute("persona",new Persona());
        model.addAttribute("accion","/personas/guardar");
        return "formulario";
    }

    @GetMapping("/actualizar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id ,Model model){
        model.addAttribute("persona",personaService.obtenerPersonaPorId(id));
        model.addAttribute("accion","/personas/actualizar/"+id);
        return "formulario";
    }

    @GetMapping
    public String listarPersonas(Model model){
        List<Persona> personas = personaService.obtenerPersonas();
        model.addAttribute("personas",personas);
        return "listar";
    }

    @PostMapping("/guardar")
    public String guardarPersona(@ModelAttribute Persona persona){
        personaService.crearPersona(persona);
        return "redirect:/personas";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarPersona(@PathVariable Long id, @ModelAttribute Persona persona){
        personaService.actualizarPersona(id,persona);
        return "redirect:/personas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPersona(@PathVariable Long id){
        personaService.eliminarPersona(id);
        return "redirect:/personas";
    }
}
