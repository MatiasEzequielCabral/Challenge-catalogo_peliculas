package challenge.catalogo_peliculas.dto;

import challenge.catalogo_peliculas.data.Pelicula;

import java.util.List;

public class PersonajeMostrarDto {

    private List<Pelicula> peliculas;

    public PersonajeMostrarDto(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }
}
