package challenge.catalogo_peliculas.data;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Pelicula {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String imagen;
    private String titulo;
    private Date fechaCreacion;
    private int calificacion;
    @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JsonBackReference
    private List<Personaje> personajes;

    public Pelicula(String imagen, String titulo, Date fechaCreacion, int calificacion, ArrayList<Personaje> personajes){
        this.imagen = imagen;
        this.titulo = titulo;
        this.fechaCreacion = fechaCreacion;
        this.calificacion = calificacion;
        this.personajes = personajes;
    }

    public Pelicula(String imagen, String titulo, int calificacion) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.calificacion = calificacion;
        if(calificacion < 1 || calificacion > 5){
            throw new IllegalArgumentException("La nota tiene que ser de 1 a 5");
        }
        this.fechaCreacion = new Date();
    }

    public Pelicula(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fecha_creacion) {
        this.fechaCreacion = fecha_creacion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public List<Personaje> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(List<Personaje> personajes) {
        this.personajes = personajes;
    }
}
