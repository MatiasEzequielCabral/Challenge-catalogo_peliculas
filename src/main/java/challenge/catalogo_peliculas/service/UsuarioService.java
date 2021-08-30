package challenge.catalogo_peliculas.service;

import org.springframework.ui.Model;

public interface UsuarioService {

    String viewHomePage();
    String formularioRegistro(Model model);
}
