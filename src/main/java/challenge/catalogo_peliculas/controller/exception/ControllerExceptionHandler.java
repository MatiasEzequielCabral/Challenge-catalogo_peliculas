package challenge.catalogo_peliculas.controller.exception;

import challenge.catalogo_peliculas.dto.ErrorMessageDto;
import challenge.catalogo_peliculas.excepciones.BussinesException;
import challenge.catalogo_peliculas.excepciones.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessageDto resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorMessageDto message = new ErrorMessageDto(HttpStatus.NOT_FOUND.value(), new Date(), ex.getMessage(), request.getDescription(false));
        return message;
        }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessageDto globalExceptionHandler(Exception ex, WebRequest request) {
        ErrorMessageDto message = new ErrorMessageDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(), ex.getMessage(), request.getDescription(false));
        return message;
    }
}
