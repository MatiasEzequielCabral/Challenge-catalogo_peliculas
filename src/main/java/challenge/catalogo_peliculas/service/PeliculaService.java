package challenge.catalogo_peliculas.service;

import challenge.catalogo_peliculas.data.Pelicula;
import challenge.catalogo_peliculas.dto.PeliculaDto;

import java.util.List;

public interface PeliculaService {

    List<Pelicula> mostrarTodasPeliculas();
    Pelicula buscarPorTitulo(String titulo);
    List<Pelicula> buscarPorCreacionAscendente();
    List<Pelicula> buscarPorCreacionDescendente();
    Pelicula nuevaPelicula(PeliculaDto nuevaPelicula);
    Pelicula reemplazarPelicula(Long id, PeliculaDto nuevaPelicula);
    void borrarPelicula(Long id);
}
