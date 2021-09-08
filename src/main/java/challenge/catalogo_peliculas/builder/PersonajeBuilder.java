package challenge.catalogo_peliculas.builder;

import challenge.catalogo_peliculas.data.Pelicula;
import challenge.catalogo_peliculas.data.Personaje;
import challenge.catalogo_peliculas.dto.PersonajeDto;

public class PersonajeBuilder {

    private String imagen;
    private String nombre;
    private int edad;
    private int peso;
    private String historia;

    public PersonajeBuilder withPersonajeDto(PersonajeDto personajeDto){
        this.imagen = personajeDto.getImagen();
        this.nombre = personajeDto.getNombre();
        this.edad = personajeDto.getEdad();
        this.peso = personajeDto.getPeso();
        this.historia = personajeDto.getHistoria();
        return this;
    }

    public Personaje build(){
        return new Personaje(this.imagen, this.nombre, this.edad, this.peso, this.historia) ;
    }

    public Personaje edit(Personaje personaje){
        personaje.setImagen(this.imagen);
        personaje.setNombre(this.nombre);
        personaje.setEdad(this.edad);
        personaje.setPeso(this.peso);
        personaje.setHistoria(this.historia);
        return personaje;
    }
}
