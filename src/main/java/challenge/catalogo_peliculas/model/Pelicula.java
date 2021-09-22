package challenge.catalogo_peliculas.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Pelicula {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String imagen;
    private String titulo;
    private Date fechaCreacion;
    @Min(1)
    @Max(5)
    private int calificacion;
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
        this.fechaCreacion = new Date();
        this.personajes = new ArrayList<>();
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

    public void setPersonaje(Personaje personaje){
        this.personajes.add(personaje);
    }
}
