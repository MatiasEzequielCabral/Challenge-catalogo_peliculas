package challenge.catalogo_peliculas.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mail;
    private String username;
    private String password;

    public Usuario(String mail, String username, String password) {
        this.mail = mail;
        this.username = username;
        this.password = password;
    }

    public Usuario() {

    }
}
