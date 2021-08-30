package challenge.catalogo_peliculas.Controller;


import challenge.catalogo_peliculas.dao.UsuarioRepository;
import challenge.catalogo_peliculas.data.Usuario;
import challenge.catalogo_peliculas.service.UsuarioService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Service
public class UsuarioController implements UsuarioService{

    UsuarioRepository repositorio;

    @GetMapping("")
    @Override
    public String viewHomePage(){
        return "index";
    }

    @GetMapping("/registrarse")
    @Override
    public String formularioRegistro(Model model){
        model.addAttribute("usuario", new Usuario());
        return "formulario_registro";
    }


}
