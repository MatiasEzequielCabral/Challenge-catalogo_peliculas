package challenge.catalogo_peliculas.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Genero {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String nombre;
    private String imagen;
    @Null
    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Pelicula> peliculas;

    public Genero(String nombre, String imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.peliculas = new ArrayList<>();
    }

    public Genero() {

    }

    public void setPeli(Pelicula pelicula) {
        peliculas.add(pelicula);
    }
}
