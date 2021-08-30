package challenge.catalogo_peliculas.service;

import challenge.catalogo_peliculas.data.Pelicula;

import java.util.List;

public interface PeliculaService {

    List<Pelicula> mostrarTodasPeliculas();
    Pelicula buscarPorTitulo(String titulo);
    List<Pelicula> buscarPorCreacionAscendente();
    List<Pelicula> buscarPorCreacionDescendente();
    Pelicula nuevaPelicula(Pelicula nuevaPelicula);
    Pelicula reemplazarPelicula(Pelicula nuevaPelicula, Long id);
    void borrarPelicula(Long id);
}
