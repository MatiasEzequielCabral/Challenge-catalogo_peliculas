package challenge.catalogo_peliculas.data;

import javax.persistence.*;
import java.util.List;

@Entity
public class Genero {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String nombre;
    private String imagen;
    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Pelicula> peliculas;

    public Genero(String nombre, String imagen, List<Pelicula> peliculas) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.peliculas = peliculas;
    }

    public Genero() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }
}
