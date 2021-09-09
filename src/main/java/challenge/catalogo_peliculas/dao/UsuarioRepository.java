package challenge.catalogo_peliculas.dao;

import challenge.catalogo_peliculas.data.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);
}
