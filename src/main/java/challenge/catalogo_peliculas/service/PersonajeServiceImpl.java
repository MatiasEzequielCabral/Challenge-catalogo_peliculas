package challenge.catalogo_peliculas.service;

import challenge.catalogo_peliculas.builder.PeliculaBuilder;
import challenge.catalogo_peliculas.builder.PersonajeBuilder;
import challenge.catalogo_peliculas.dao.PeliculaRepository;
import challenge.catalogo_peliculas.dao.PersonajeRepository;
import challenge.catalogo_peliculas.data.Pelicula;
import challenge.catalogo_peliculas.data.Personaje;
import challenge.catalogo_peliculas.dto.PersonajeCrearDto;
import challenge.catalogo_peliculas.dto.PersonajeEditarDto;
import challenge.catalogo_peliculas.excepciones.BussinesException;
import challenge.catalogo_peliculas.excepciones.ResourceNotFoundException;
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
        try{
            return personajeRepository.findAll();
        } catch (Exception e){
            throw new BussinesException("Error al mostrar la entidad");
        }
    }

    @Override
    public List<String> showNombresAndImagen() {
        try{
            return personajeRepository.getAllNombresAndImagen();
        } catch (Exception e){
            throw new BussinesException("Error al mostrar la entidad");
        }
    }

    @Override
    public List<Personaje> mostrarPeliculasPorId(Long id) {
        try{
            Pelicula pelicula = peliculaRepository.findById(id).get();
            return pelicula.getPersonajes();
        } catch (Exception e){
            throw new ResourceNotFoundException("no se encontro el id de la entidad");
        }
    }

    @Override
    public List<Personaje> buscarPorNombre(String nombre) {
        try{
            return personajeRepository.findByNombre(nombre);
        } catch (Exception e){
            throw new ResourceNotFoundException("no se encontro la entidad");
        }
    }

    @Override
    public List<Personaje> buscarPorEdad(int edad) {
        try{
            return personajeRepository.findByEdad(edad);
        } catch (Exception e){
            throw new ResourceNotFoundException("no se encontro la entidad");
        }
    }

    @Override
    public List<Personaje> buscarPorPeso(int peso) {
        try{
            return personajeRepository.findByPeso(peso);
        } catch (Exception e){
            throw new ResourceNotFoundException("no se encontro la entidad");
        }
    }

    @Override
    public Personaje newPersonaje(PersonajeCrearDto personaje) {
        try{
            Personaje nuevoPersonaje = new PersonajeBuilder().withPersonajeDto(personaje).build();
            return personajeRepository.save(nuevoPersonaje);
        } catch (Exception e){
            throw new BussinesException("imposible generar nueva entidad");
        }
    }

    @Override
    public Personaje replacePersonaje(Long id, PersonajeEditarDto newPersonaje) {
        try{
            Personaje nuevoPersonaje = personajeRepository.findById(id).get();
            nuevoPersonaje = new PersonajeBuilder().withPersonajeDto(newPersonaje).edit(nuevoPersonaje);
            if(newPersonaje.getIdPelicula() != null){
                Pelicula pelicula = peliculaRepository.findById(newPersonaje.getIdPelicula()).get();
                nuevoPersonaje.setPeli(pelicula);
                //al asignarle una pelicula al personaje enlaza tambien la pelicula con el personaje
                pelicula.setPersonaje(nuevoPersonaje);
                peliculaRepository.save(pelicula);
            }
            return personajeRepository.save(nuevoPersonaje);
        } catch (Exception e){
            throw new ResourceNotFoundException("no se encontro el id de la entidad");
        }
    }

    @Override
    public void deletePersonaje(Long id) {
        try{
            personajeRepository.deleteById(id);
        } catch (Exception e){
            throw new ResourceNotFoundException("no se encontro el id de la entidad");
        }
    }
}
