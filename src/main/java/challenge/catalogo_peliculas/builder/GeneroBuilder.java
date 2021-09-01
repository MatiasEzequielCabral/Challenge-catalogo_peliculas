package challenge.catalogo_peliculas.builder;

import challenge.catalogo_peliculas.data.Genero;
import challenge.catalogo_peliculas.dto.GeneroDto;

public class GeneroBuilder {

    private String nombre;
    private String imagen;

    public GeneroBuilder withGeneroDto(GeneroDto generoDto){
        this.nombre = generoDto.getNombre();
        this.imagen = generoDto.getImagen();
        return this;
    }

    public Genero build(){
        return new Genero(this.nombre, this.imagen);
    }


}
