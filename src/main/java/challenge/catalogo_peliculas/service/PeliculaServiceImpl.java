package challenge.catalogo_peliculas.service;

import challenge.catalogo_peliculas.builder.PeliculaBuilder;
import challenge.catalogo_peliculas.dao.PeliculaRepository;
import challenge.catalogo_peliculas.data.Pelicula;
import challenge.catalogo_peliculas.dto.PeliculaDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PeliculaServiceImpl implements PeliculaService{

    PeliculaRepository peliculaRepository;

    public PeliculaServiceImpl(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
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
    public Pelicula nuevaPelicula(@RequestBody PeliculaDto pelicula) {
        Pelicula nuevaPelicula = new PeliculaBuilder().withPeliculaDto(pelicula).build();
        return peliculaRepository.save(nuevaPelicula);
    }

    @Override
    public Pelicula reemplazarPelicula(@RequestBody Pelicula nuevaPelicula, @PathVariable Long id) {
        return peliculaRepository.findById(id)
                .map(pelicula -> {
                    pelicula.setTitulo(nuevaPelicula.getTitulo());
                    return peliculaRepository.save(pelicula);
                })
                .orElseGet(() -> {
                    nuevaPelicula.setId(id);
                    return peliculaRepository.save(nuevaPelicula);
                });
    }

    @Override
    public void borrarPelicula(@PathVariable Long id) {
        peliculaRepository.deleteById(id);
    }
}
