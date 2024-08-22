package com.raps.SpringBootService.Service;

import com.raps.SpringBootService.model.Persona;

import java.util.List;

public interface PersonaService {
    List<Persona> obtenerPersonas();
    Persona obtenerPersonaPorId(Long id);
    Persona crearPersona(Persona persona);
    Persona actualizarPersona(Long id, Persona persona);
    void eliminarPersona(Long id);
    long contarPersonas();
}
