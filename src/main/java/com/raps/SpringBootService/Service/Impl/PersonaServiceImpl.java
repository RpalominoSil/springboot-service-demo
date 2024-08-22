package com.raps.SpringBootService.Service.Impl;

import com.raps.SpringBootService.Service.PersonaService;
import com.raps.SpringBootService.model.Persona;
import com.raps.SpringBootService.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public List<Persona> obtenerPersonas() {
        return personaRepository.findAll();
    }

    @Override
    public Persona obtenerPersonaPorId(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    @Override
    public Persona crearPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Persona actualizarPersona(Long id,Persona persona) {
        return personaRepository.existsById(id) ? personaRepository.save(persona) : null;
    }

    @Override
    public void eliminarPersona(Long id) {
        if(personaRepository.existsById(id)){
            personaRepository.deleteById(id);
        }
    }

    @Override
    public long contarPersonas() {
        return personaRepository.count();
    }
}
