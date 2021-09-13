package challenge.catalogo_peliculas.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class BussinesException extends RuntimeException{

    public BussinesException(String message){
        super(message);
    }
}
