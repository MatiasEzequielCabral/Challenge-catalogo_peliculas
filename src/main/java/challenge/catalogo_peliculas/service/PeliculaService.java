package challenge.catalogo_peliculas.service;

import challenge.catalogo_peliculas.data.Pelicula;
import challenge.catalogo_peliculas.dto.PeliculaCrearDto;
import challenge.catalogo_peliculas.dto.PeliculaEditarDto;

import java.util.List;

public interface PeliculaService {

    List<Pelicula> mostrarTodasPeliculas();
    Pelicula buscarPorTitulo(String titulo);
    List<Pelicula> buscarPorCreacionAscendente();
    List<Pelicula> buscarPorCreacionDescendente();
    Pelicula nuevaPelicula(PeliculaCrearDto nuevaPelicula);
    Pelicula reemplazarPelicula(Long id, PeliculaEditarDto nuevaPelicula);
    List<Pelicula> buscarTodasPelisPorGeneroId(Long id);
    void borrarPelicula(Long id);
}
