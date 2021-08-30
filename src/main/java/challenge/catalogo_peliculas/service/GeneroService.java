package challenge.catalogo_peliculas.service;

import challenge.catalogo_peliculas.data.Genero;

import java.util.List;

public interface GeneroService {

    List<Genero> mostrarTodasGenero();
    List<Genero> mostrarTodasPeliculasPorId(Long id);
    Genero nuevaGenero(Genero nuevaGenero);
    Genero reemplazarGenero(Genero nuevaGenero, Long id);
    void borrarGenero(Long id);
}
