package challenge.catalogo_peliculas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
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

    public void setPeli(Pelicula pelicula) {
        peliculas.add(pelicula);
    }
}
