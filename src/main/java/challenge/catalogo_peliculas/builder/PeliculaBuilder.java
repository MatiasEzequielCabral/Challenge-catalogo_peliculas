package challenge.catalogo_peliculas.builder;

import challenge.catalogo_peliculas.data.Pelicula;
import challenge.catalogo_peliculas.dto.PeliculaCrearDto;
import challenge.catalogo_peliculas.dto.PeliculaEditarDto;

public class PeliculaBuilder {

    private String imagen;
    private String titulo;
    private int calificacion;

    public PeliculaBuilder withPeliculaDto(PeliculaCrearDto peliculaDto){
        this.imagen = peliculaDto.getImagen();
        this.titulo = peliculaDto.getTitulo();
        this.calificacion = peliculaDto.getCalificacion();
        return this;
    }

    public PeliculaBuilder withPeliculaDto(PeliculaEditarDto peliculaDto){
        this.imagen = peliculaDto.getImagen();
        this.titulo = peliculaDto.getTitulo();
        this.calificacion = peliculaDto.getCalificacion();
        return this;
    }

    public Pelicula build(){
        return new Pelicula(this.imagen, this.titulo, this.calificacion);
    }

    public Pelicula edit(Pelicula pelicula){
        pelicula.setImagen(this.imagen);
        pelicula.setTitulo(this.titulo);
        pelicula.setCalificacion(this.calificacion);
        return pelicula;
    }
}
