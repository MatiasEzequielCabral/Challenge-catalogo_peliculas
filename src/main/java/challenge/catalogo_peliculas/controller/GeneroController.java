package challenge.catalogo_peliculas.controller;

import challenge.catalogo_peliculas.model.Genero;
import challenge.catalogo_peliculas.dto.GeneroCrearDto;
import challenge.catalogo_peliculas.dto.GeneroEditarDto;
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
        try{
            return new ResponseEntity<>(generoService.mostrarTodasGenero(), HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarGenero(@PathVariable Long id, @RequestBody GeneroEditarDto generoDto){
        try{
            return new ResponseEntity<>(generoService.reemplazarGenero(id, generoDto), HttpStatus.OK);

        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> guardarGenero(@RequestBody GeneroCrearDto generoDto){
        try{
            Genero genero = generoService.nuevaGenero(generoDto);
            return new ResponseEntity<>(genero, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarGenero(@PathVariable Long id){
        try{
            generoService.borrarGenero(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
