package challenge.catalogo_peliculas.service;

import challenge.catalogo_peliculas.builder.UsuarioBuilder;
import challenge.catalogo_peliculas.dao.UsuarioRepository;
import challenge.catalogo_peliculas.data.Usuario;
import challenge.catalogo_peliculas.dto.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements  UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private SendMailService sendMailService;

    @Override
    public Usuario findByUsername(String username){
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public Usuario save(UsuarioDto usuarioDto){
        Usuario usuario = new UsuarioBuilder().withUsuarioDto(usuarioDto).build();
        usuario = usuarioRepository.save(usuario);
        //sendMailService.sendEmail(usuario);
        return usuario;
    }
}
