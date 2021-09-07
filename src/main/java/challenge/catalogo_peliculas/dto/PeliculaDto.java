package challenge.catalogo_peliculas.dto;

public class PeliculaDto {
    private String imagen;
    private String titulo;
    private int calificacion;
    private Long idPersonaje;

    public PeliculaDto() {
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

    public Long getIdPersonaje() {
        return idPersonaje;
    }

    public void setIdPersonaje(Long idPersonaje) {
        this.idPersonaje = idPersonaje;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
}


