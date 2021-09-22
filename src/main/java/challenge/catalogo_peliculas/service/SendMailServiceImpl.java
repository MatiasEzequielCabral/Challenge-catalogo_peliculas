package challenge.catalogo_peliculas.service;

import challenge.catalogo_peliculas.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendMailServiceImpl implements SendMailService{
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(Usuario usuario){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(usuario.getMail());
        mailMessage.setSubject("Bienvenido");
        mailMessage.setText("Su cuenta a sido creada con exito");
        mailSender.send(mailMessage);
    }
}
