package challenge.catalogo_peliculas.service;

import challenge.catalogo_peliculas.builder.PersonajeBuilder;
import challenge.catalogo_peliculas.dao.PeliculaRepository;
import challenge.catalogo_peliculas.dao.PersonajeRepository;
import challenge.catalogo_peliculas.data.Pelicula;
import challenge.catalogo_peliculas.data.Personaje;
import challenge.catalogo_peliculas.dto.PersonajeCrearDto;
import challenge.catalogo_peliculas.dto.PersonajeEditarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeServiceImpl implements PersonajeService{

    @Autowired
    private PersonajeRepository personajeRepository;
    @Autowired
    private PeliculaRepository peliculaRepository;

    public PersonajeServiceImpl(PersonajeRepository personajeRepository, PeliculaRepository peliculaRepository) {
        this.personajeRepository = personajeRepository;
        this.peliculaRepository = peliculaRepository;
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
        Pelicula pelicula = peliculaRepository.findById(id).get();
        return pelicula.getPersonajes();
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
    public Personaje newPersonaje(PersonajeCrearDto personaje) {
        Personaje nuevoPersonaje = new PersonajeBuilder().withPersonajeDto(personaje).build();
        return personajeRepository.save(nuevoPersonaje);
    }

    @Override
    public Personaje replacePersonaje(Long id, PersonajeEditarDto newPersonaje) {
        Personaje nuevoPersonaje = personajeRepository.findById(id).get();
        nuevoPersonaje = new PersonajeBuilder().withPersonajeDto(newPersonaje).edit(nuevoPersonaje);
        Pelicula pelicula = peliculaRepository.findById(newPersonaje.getIdPelicula()).get();
        nuevoPersonaje.setPeli(pelicula);
        //al asignarle una pelicula al personaje enlaza tambien la pelicula con el personaje
        pelicula.setPersonaje(nuevoPersonaje);
        peliculaRepository.save(pelicula);
        return personajeRepository.save(nuevoPersonaje);
    }

    @Override
    public void deletePersonaje(Long id) {
        personajeRepository.deleteById(id);
    }
}
