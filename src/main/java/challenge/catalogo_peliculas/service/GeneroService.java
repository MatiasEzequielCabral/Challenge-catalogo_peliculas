package challenge.catalogo_peliculas.service;

import challenge.catalogo_peliculas.data.Genero;
import challenge.catalogo_peliculas.dto.GeneroCrearDto;
import challenge.catalogo_peliculas.dto.GeneroEditarDto;
import challenge.catalogo_peliculas.excepciones.BussinesException;

import java.util.List;

public interface GeneroService {

    List<Genero> mostrarTodasGenero();
    Genero nuevaGenero(GeneroCrearDto nuevaGenero);
    Genero reemplazarGenero(Long id, GeneroEditarDto nuevaGenero);
    void borrarGenero(Long id);
}
