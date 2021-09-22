package challenge.catalogo_peliculas.builder;

import challenge.catalogo_peliculas.model.Usuario;
import challenge.catalogo_peliculas.dto.UsuarioDto;

public class UsuarioBuilder {

    private String mail;
    private String username;
    private String password;

    public UsuarioBuilder withUsuarioDto(UsuarioDto usuarioDto){
        this.mail = usuarioDto.getMail();
        this.username = usuarioDto.getUsername();
        this.password = usuarioDto.getPassword();
        return this;
    }

    public Usuario build(){
        return new Usuario(this.mail, this.username, this.password) ;
    }
}
