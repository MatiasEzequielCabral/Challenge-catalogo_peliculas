package challenge.catalogo_peliculas.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Genero {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String nombre;
    private String imagen;
    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Pelicula> peliculas;
}
