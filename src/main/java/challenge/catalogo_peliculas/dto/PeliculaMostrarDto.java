package challenge.catalogo_peliculas.dto;

import challenge.catalogo_peliculas.model.Personaje;

import java.util.List;

public class PeliculaMostrarDto {

    private List<Personaje> personajes;

    public PeliculaMostrarDto(List<Personaje> personajes) {
        this.personajes = personajes;
    }

    public List<Personaje> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(List<Personaje> personajes) {
        this.personajes = personajes;
    }
}
