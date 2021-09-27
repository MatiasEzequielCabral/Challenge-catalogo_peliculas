package challenge.catalogo_peliculas.dto;

import challenge.catalogo_peliculas.model.Personaje;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PeliculaMostrarDto {

    private List<Personaje> personajes;

}
