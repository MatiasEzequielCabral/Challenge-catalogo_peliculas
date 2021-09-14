package challenge.catalogo_peliculas.service;

import challenge.catalogo_peliculas.builder.GeneroBuilder;
import challenge.catalogo_peliculas.builder.PeliculaBuilder;
import challenge.catalogo_peliculas.dao.GeneroRepository;
import challenge.catalogo_peliculas.dao.PeliculaRepository;
import challenge.catalogo_peliculas.dao.PersonajeRepository;
import challenge.catalogo_peliculas.data.Genero;
import challenge.catalogo_peliculas.data.Pelicula;
import challenge.catalogo_peliculas.data.Personaje;
import challenge.catalogo_peliculas.dto.PeliculaCrearDto;
import challenge.catalogo_peliculas.dto.PeliculaEditarDto;
import challenge.catalogo_peliculas.excepciones.BussinesException;
import challenge.catalogo_peliculas.excepciones.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PeliculaServiceImpl implements PeliculaService{
    @Autowired
    private PeliculaRepository peliculaRepository;
    @Autowired
    private PersonajeRepository personajeRepository;
    @Autowired
    private GeneroRepository generoRepository;

    public PeliculaServiceImpl(PeliculaRepository peliculaRepository, PersonajeRepository personajeRepository, GeneroRepository generoRepository) {
        this.peliculaRepository = peliculaRepository;
        this.personajeRepository = personajeRepository;
        this.generoRepository = generoRepository;
    }

    @Override
    public List<Pelicula> mostrarTodasPeliculas() {
        try{
            return peliculaRepository.findAll();
        } catch (Exception e){
            throw new BussinesException("Error al mostrar la entidad");
        }
    }

    @Override
    public Pelicula buscarPorTitulo(@PathVariable String titulo) {
        try{
            return peliculaRepository.findByTitulo(titulo);
        } catch (Exception e){
            throw new ResourceNotFoundException("no se encontro la entidad");
        }
    }

    @Override
    public List<Pelicula> buscarPorCreacionAscendente() {
        try{
            return peliculaRepository.findAllByOrderByFechaCreacionAsc();
        } catch (Exception e){
            throw new BussinesException("Error al mostrar la entidad");
        }
    }

    @Override
    public List<Pelicula> buscarPorCreacionDescendente() {
        try{
            return peliculaRepository.findAllByOrderByFechaCreacionDesc();
        } catch (Exception e){
            throw new BussinesException("Error al mostrar la entidad");
        }
    }

    @Override
    public List<Pelicula> buscarTodasPelisPorGeneroId(Long id) {
        try{
            Genero genero = generoRepository.findById(id).get();
            return genero.getPeliculas(); //parametro querry
        } catch (Exception e){
            throw new ResourceNotFoundException("no se encontro el id de la entidad");
        }
    }

    @Override
    public Pelicula nuevaPelicula(@RequestBody PeliculaCrearDto pelicula) {
        try{
            Pelicula nuevaPelicula = new PeliculaBuilder().withPeliculaDto(pelicula).build();
            return peliculaRepository.save(nuevaPelicula);
        } catch (Exception e){
            throw new BussinesException("imposible generar nueva entidad");
        }
    }

    @Override
    public Pelicula reemplazarPelicula(Long id, PeliculaEditarDto pelicula) {
        try{
            Pelicula nuevaPelicula = peliculaRepository.findById(id).get();
            nuevaPelicula = new PeliculaBuilder().withPeliculaDto(pelicula).edit(nuevaPelicula);
            if(pelicula.getIdPersonaje() != null){
                Personaje personaje = personajeRepository.findById(pelicula.getIdPersonaje()).get();
                nuevaPelicula.setPersonaje(personaje);
                //al asignarle un personaje a la pelicula enlaza tambien el personaje a la pelicula que le corresponde
                personaje.setPeli(nuevaPelicula);
                personajeRepository.save(personaje);
            }
            return peliculaRepository.save(nuevaPelicula);
        } catch (Exception e){
            throw new ResourceNotFoundException("no se encontro el id de la entidad");
        }
    }

    @Override
    public void borrarPelicula(@PathVariable Long id) {
        try{
            peliculaRepository.deleteById(id);
        } catch (Exception e){
            throw new ResourceNotFoundException("no se encontro el id de la entidad");
        }
    }
}
