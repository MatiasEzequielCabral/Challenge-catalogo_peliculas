package challenge.catalogo_peliculas.service;

import challenge.catalogo_peliculas.builder.PeliculaBuilder;
import challenge.catalogo_peliculas.dao.GeneroRepository;
import challenge.catalogo_peliculas.dao.PeliculaRepository;
import challenge.catalogo_peliculas.dao.PersonajeRepository;
import challenge.catalogo_peliculas.data.Genero;
import challenge.catalogo_peliculas.data.Pelicula;
import challenge.catalogo_peliculas.dto.PeliculaDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PeliculaServiceImpl implements PeliculaService{

    private PeliculaRepository peliculaRepository;
    private PersonajeRepository personajeRepository;
    private GeneroRepository generoRepository;

    public PeliculaServiceImpl(PeliculaRepository peliculaRepository, PersonajeRepository personajeRepository, GeneroRepository generoRepository) {
        this.peliculaRepository = peliculaRepository;
        this.personajeRepository = personajeRepository;
        this.generoRepository = generoRepository;
    }

    @Override
    public List<Pelicula> mostrarTodasPeliculas() {
        return peliculaRepository.findAll();
    }

    @Override
    public Pelicula buscarPorTitulo(@PathVariable String titulo) {
        return peliculaRepository.findByTitulo(titulo);
    }

    @Override
    public List<Pelicula> buscarPorCreacionAscendente() {
        return peliculaRepository.findAllByOrderByFechaCreacionAsc();
    }

    @Override
    public List<Pelicula> buscarPorCreacionDescendente() {
        return peliculaRepository.findAllByOrderByFechaCreacionDesc();
    }

    @Override
    public List<Pelicula> buscarTodasPelisPorGeneroId(Long id) {
        Genero genero = generoRepository.findById(id).get();
        return genero.getPeliculas();
    }

    @Override
    public Pelicula nuevaPelicula(@RequestBody PeliculaDto pelicula) {
        Pelicula nuevaPelicula = new PeliculaBuilder().withPeliculaDto(pelicula).build();
        return peliculaRepository.save(nuevaPelicula);
    }

    @Override
    public Pelicula reemplazarPelicula(Long id, PeliculaDto pelicula) {
        Pelicula nuevaPelicula = peliculaRepository.findById(id).get();
        nuevaPelicula = new PeliculaBuilder().withPeliculaDto(pelicula).edit(nuevaPelicula);
        nuevaPelicula.setPersonaje(personajeRepository.findById(pelicula.getIdPersonaje()).get());
        return peliculaRepository.save(nuevaPelicula);
    }

    @Override
    public void borrarPelicula(@PathVariable Long id) {
        peliculaRepository.deleteById(id);
    }
}
