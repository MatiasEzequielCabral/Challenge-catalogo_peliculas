package challenge.catalogo_peliculas.Controller;

import challenge.catalogo_peliculas.data.AuthenticationRequest;
import challenge.catalogo_peliculas.data.Usuario;
import challenge.catalogo_peliculas.dto.UsuarioDto;
import challenge.catalogo_peliculas.service.UserDetailsService;
import challenge.catalogo_peliculas.service.UserDetailsServiceImpl;
import challenge.catalogo_peliculas.service.UsuarioService;
import challenge.catalogo_peliculas.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authentication")
    public ResponseEntity<?> createAuthentication(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        UserDetails usuario = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        String jwt = jwtUtil.generateToken(usuario);
        return new ResponseEntity<>(jwt, HttpStatus.ACCEPTED); //revisar error aqui

    }

    @PostMapping("/register")
    public ResponseEntity<?> createAccount(@RequestBody UsuarioDto usuarioDto){
        Usuario usuario = usuarioService.save(usuarioDto);
        return new ResponseEntity<>(usuario, HttpStatus.ACCEPTED);
    }
}
