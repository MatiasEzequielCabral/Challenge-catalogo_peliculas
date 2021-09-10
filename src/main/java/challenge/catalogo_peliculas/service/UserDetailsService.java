package challenge.catalogo_peliculas.service;

import challenge.catalogo_peliculas.data.Usuario;
import challenge.catalogo_peliculas.dto.UsuarioDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsService {

    UserDetails loadUserByUsername(String username);
}
