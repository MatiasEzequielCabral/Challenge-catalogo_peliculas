package challenge.catalogo_peliculas.service;

import challenge.catalogo_peliculas.model.Usuario;
import challenge.catalogo_peliculas.dto.UsuarioDto;

public interface UsuarioService {

    Usuario findByUsername(String username);
    Usuario save(UsuarioDto usuarioDto);
}
