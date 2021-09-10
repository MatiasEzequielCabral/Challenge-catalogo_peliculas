package challenge.catalogo_peliculas.service;

import challenge.catalogo_peliculas.builder.GeneroBuilder;
import challenge.catalogo_peliculas.dao.GeneroRepository;
import challenge.catalogo_peliculas.dao.PeliculaRepository;
import challenge.catalogo_peliculas.data.Genero;
import challenge.catalogo_peliculas.dto.GeneroCrearDto;
import challenge.catalogo_peliculas.dto.GeneroEditarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class GeneroServiceImpl implements GeneroService{

    @Autowired
    private GeneroRepository generoRepository;

    @Autowired
    private PeliculaRepository peliculaRepository;

    public GeneroServiceImpl(GeneroRepository generoRepository, PeliculaRepository peliculaRepository) {
        this.generoRepository = generoRepository;
        this.peliculaRepository = peliculaRepository;
    }

    @Override
    public List<Genero> mostrarTodasGenero() {
        return generoRepository.findAll();
    }

    @Override
    public Genero nuevaGenero(GeneroCrearDto generoDto) {
        Genero nuevoGenero = new GeneroBuilder().withGeneroDto(generoDto).build();
        return generoRepository.save(nuevoGenero);
    }

    @Override
    public Genero reemplazarGenero(Long id, GeneroEditarDto generoDto) {
        Genero nuevoGenero = generoRepository.findById(id).get();
        nuevoGenero = new GeneroBuilder().withGeneroDto(generoDto).edit(nuevoGenero);
        nuevoGenero.setPeli(peliculaRepository.findById(generoDto.getIdPelicula()).get());
        return generoRepository.save(nuevoGenero);
    }

    @Override
    public void borrarGenero(@PathVariable Long id) {
        generoRepository.deleteById(id);
    }
}
