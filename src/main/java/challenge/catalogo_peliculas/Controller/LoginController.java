package challenge.catalogo_peliculas.Controller;

import challenge.catalogo_peliculas.data.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/auth")
public class LoginController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/register")
    public ResponseEntity<> registerUsuario(@RequestBody UsuarioDto usuarioDto){
        Usuario usuario = usuarioService.registerUser(usuarioDto);
        return new ResponseEntity<>(usuario, HttpStatus.ACCEPTED);
    }
}
