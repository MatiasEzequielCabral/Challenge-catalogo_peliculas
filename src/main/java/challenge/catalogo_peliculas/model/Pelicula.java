package challenge.catalogo_peliculas.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Pelicula {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String imagen;
    private String titulo;
    private Date fechaCreacion;
    @Min(1)
    @Max(5)
    private int calificacion;
    @Null
    @ManyToMany(fetch = FetchType.LAZY,
            cascade =
                    {
                            CascadeType.DETACH,
                            CascadeType.MERGE,
                            CascadeType.REFRESH,
                            CascadeType.PERSIST
                    },
            targetEntity = Personaje.class)
    @JoinTable(name = "pelicula_personajes",
            inverseJoinColumns = @JoinColumn(name = "personaje_id",
                    nullable = false,
                    updatable = false),
            joinColumns = @JoinColumn(name = "pelicula_id",
                    nullable = false,
                    updatable = false),
            foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
            inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    @JsonBackReference
    private List<Personaje> personajes;

    public Pelicula(String imagen, String titulo, Date fechaCreacion, int calificacion) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.fechaCreacion = fechaCreacion;
        this.calificacion = calificacion;
        this.personajes = new ArrayList<>();
    }

    public Pelicula(String imagen, String titulo, int calificacion) {

    }

    public Pelicula() {

    }

    public void setPersonaje(Personaje personaje){
        personajes.add(personaje);
    }
}
