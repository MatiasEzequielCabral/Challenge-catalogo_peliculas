package challenge.catalogo_peliculas.Controller;

import challenge.catalogo_peliculas.data.Genero;
import challenge.catalogo_peliculas.dto.GeneroDto;
import challenge.catalogo_peliculas.service.GeneroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/generos")
@CrossOrigin("*")
public class GeneroController{
    private final GeneroService generoService;

    public GeneroController(GeneroService generoService) {
        this.generoService = generoService;
    }


    @GetMapping
    public ResponseEntity<?> mostrarGeneros(){
        return new ResponseEntity<>(generoService.mostrarTodasGenero(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/movies/genero/{id}")
    public ResponseEntity<?> mostrarPeliculasPorId(@PathVariable Long id){
        return new ResponseEntity<>(generoService.mostrarTodasPeliculasPorId(id), HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarGenero(@PathVariable Long id, @RequestBody GeneroDto generoDto){
        return new ResponseEntity<>(generoService.reemplazarGenero(id, generoDto), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> guardarGenero(@RequestBody GeneroDto generoDto){
        Genero genero = generoService.nuevaGenero(generoDto);
        return new ResponseEntity<>(genero, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarGenero(@PathVariable Long id){
        generoService.borrarGenero(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
