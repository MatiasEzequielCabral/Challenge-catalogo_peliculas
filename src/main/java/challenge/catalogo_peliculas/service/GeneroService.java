package challenge.catalogo_peliculas.service;

import challenge.catalogo_peliculas.model.Genero;
import challenge.catalogo_peliculas.dto.GeneroCrearDto;
import challenge.catalogo_peliculas.dto.GeneroEditarDto;

import java.util.List;

public interface GeneroService {

    List<Genero> mostrarTodasGenero();
    Genero nuevaGenero(GeneroCrearDto nuevaGenero);
    Genero reemplazarGenero(Long id, GeneroEditarDto nuevaGenero);
    void borrarGenero(Long id);
}
