package challenge.catalogo_peliculas.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Personaje{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imagen;
    private String nombre;
    private int edad;
    private int peso;
    private String historia;
    @Null
    @ManyToMany(fetch = FetchType.LAZY,
            cascade =
                    {
                            CascadeType.DETACH,
                            CascadeType.MERGE,
                            CascadeType.REFRESH,
                            CascadeType.PERSIST
                    },
            targetEntity = Pelicula.class)
    @JoinTable(name = "personaje_peliculas",
            inverseJoinColumns = @JoinColumn(name = "pelicula_id",
                    nullable = false,
                    updatable = false),
            joinColumns = @JoinColumn(name = "personaje_id",
                    nullable = false,
                    updatable = false),
            foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
            inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    @JsonManagedReference
    private List<Pelicula> peliculas;

    public Personaje(String url, String nombre, int edad, int peso, String historia) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.historia = historia;
        this.peliculas = new ArrayList<>();
    }

    public Personaje() {

    }

    public void setPeli(Pelicula pelicula){
        peliculas.add(pelicula);
    }
}
