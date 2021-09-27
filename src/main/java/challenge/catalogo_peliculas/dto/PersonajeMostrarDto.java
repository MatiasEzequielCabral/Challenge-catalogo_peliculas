package challenge.catalogo_peliculas.dto;

import challenge.catalogo_peliculas.model.Pelicula;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PersonajeMostrarDto {

    private List<Pelicula> peliculas;

}
