package challenge.catalogo_peliculas.service;

import challenge.catalogo_peliculas.data.Genero;
import challenge.catalogo_peliculas.dto.GeneroDto;

import java.util.List;

public interface GeneroService {

    List<Genero> mostrarTodasGenero();
    List<Genero> mostrarTodasPeliculasPorId(Long id);
    Genero nuevaGenero(GeneroDto nuevaGenero);
    Genero reemplazarGenero(Long id, GeneroDto nuevaGenero);
    void borrarGenero(Long id);
}
