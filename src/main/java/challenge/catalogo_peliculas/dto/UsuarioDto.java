package challenge.catalogo_peliculas.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioDto {

    private String mail;
    private String username;
    private String password;
}
