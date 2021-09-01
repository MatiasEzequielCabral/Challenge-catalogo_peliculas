package challenge.catalogo_peliculas.service;

import challenge.catalogo_peliculas.builder.GeneroBuilder;
import challenge.catalogo_peliculas.dao.GeneroRepository;
import challenge.catalogo_peliculas.data.Genero;
import challenge.catalogo_peliculas.dto.GeneroDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class GeneroServiceImpl implements GeneroService{

    private GeneroRepository generoRepository;


    public GeneroServiceImpl(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    @Override
    public List<Genero> mostrarTodasGenero() {
        return generoRepository.findAll();
    }

    @Override
    public List<Genero> mostrarTodasPeliculasPorId(@PathVariable Long id){
        return generoRepository.getAllPeliculasById(id);
    }

    @Override
    public Genero nuevaGenero(GeneroDto generoDto) {
        Genero nuevoGenero = new GeneroBuilder().withGeneroDto(generoDto).build();
        return generoRepository.save(nuevoGenero);
    }

    @Override
    public Genero reemplazarGenero(Long id, GeneroDto generoDto) {
        return null;
    }

    @Override
    public void borrarGenero(@PathVariable Long id) {
        generoRepository.deleteById(id);
    }
}
