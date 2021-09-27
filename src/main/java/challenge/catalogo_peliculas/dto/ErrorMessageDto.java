package challenge.catalogo_peliculas.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class ErrorMessageDto {
    private int statusCode;
    private Date timestamp;
    private String message;
    private String description;

    public ErrorMessageDto(int statusCode, Date timestamp, String message, String description) {
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.message = message;
        this.description = description;
    }

}
