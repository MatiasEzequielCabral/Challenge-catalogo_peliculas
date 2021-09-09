package challenge.catalogo_peliculas.dto;

public class GeneroCrearDto {

    private String nombre;
    private String imagen;

    public GeneroCrearDto() {
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
}
