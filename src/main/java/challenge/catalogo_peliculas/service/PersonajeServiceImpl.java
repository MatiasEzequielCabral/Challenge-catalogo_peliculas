package challenge.catalogo_peliculas.service;

import challenge.catalogo_peliculas.builder.PersonajeBuilder;
import challenge.catalogo_peliculas.dao.PersonajeRepository;
import challenge.catalogo_peliculas.data.Personaje;
import challenge.catalogo_peliculas.dto.PersonajeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeServiceImpl implements PersonajeService{

    private PersonajeRepository personajeRepository;

    public PersonajeServiceImpl(PersonajeRepository personajeRepository) {
        this.personajeRepository = personajeRepository;
    }


    @Override
    public List<Personaje> showAll() {
        return personajeRepository.findAll();
    }

    @Override
    public List<String> showNombresAndImagen() {
        return personajeRepository.getAllNombresAndImagen();
    }

    @Override
    public List<Personaje> mostrarPeliculasPorId(Long id) {
        return personajeRepository.getAllPeliculasById(id);
    }

    @Override
    public List<Personaje> buscarPorNombre(String nombre) {
        return personajeRepository.findByNombre(nombre);
    }

    @Override
    public List<Personaje> buscarPorEdad(int edad) {
        return personajeRepository.findByEdad(edad);
    }

    @Override
    public List<Personaje> buscarPorPeso(int peso) {
        return personajeRepository.findByPeso(peso);
    }

    @Override
    public Personaje newPersonaje(PersonajeDto personaje) {
        Personaje nuevoPersonaje = new PersonajeBuilder().withPersonajeDto(personaje).build();
        return personajeRepository.save(nuevoPersonaje);
    }

    @Override
    public Personaje replacePersonaje(Personaje newPersonaje, Long id) {
        return null;
    }

    @Override
    public void deletePersonaje(Long id) {
        personajeRepository.deleteById(id);
    }
}
