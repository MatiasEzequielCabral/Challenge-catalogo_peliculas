package challenge.catalogo_peliculas.controller;

import challenge.catalogo_peliculas.data.Pelicula;
import challenge.catalogo_peliculas.dto.PeliculaCrearDto;
import challenge.catalogo_peliculas.dto.PeliculaEditarDto;
import challenge.catalogo_peliculas.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
@CrossOrigin("*")
public class PeliculaController{

    @Autowired
    private final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping
    public ResponseEntity<?> mostrarPeliculas(){
        try{
            return new ResponseEntity<>(peliculaService.mostrarTodasPeliculas(), HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("titulo/{titulo}")
    public ResponseEntity<?> mostrarPeliculasPorTitulo(@PathVariable String titulo){
        try{
            return new ResponseEntity<>(peliculaService.buscarPorTitulo(titulo), HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("genero/{id}")
    public ResponseEntity<?> mostrarPorGenero(@PathVariable Long id){
        try{
            return new ResponseEntity<>(peliculaService.buscarTodasPelisPorGeneroId(id), HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("orden/ASC")
    public ResponseEntity<?> mostrarPeliculasPorCreacionAscendente(){
        try{
            return new ResponseEntity<>(peliculaService.buscarPorCreacionAscendente(), HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("orden/DESC")
    public ResponseEntity<?> mostrarPeliculasPorCreacionDescendiente(){
        try{
            return new ResponseEntity<>(peliculaService.buscarPorCreacionDescendente(), HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarGenero(@PathVariable Long id, @RequestBody PeliculaEditarDto peliculaDto){
        try{
            Pelicula pelicula = peliculaService.reemplazarPelicula(id, peliculaDto);
            return new ResponseEntity<>(pelicula, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> guardarPelicula(@RequestBody PeliculaCrearDto peliculaDto){
        try{
            Pelicula pelicula = peliculaService.nuevaPelicula(peliculaDto);
            return new ResponseEntity<>(pelicula, HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarPeliculaPorId(@PathVariable Long id){
        try{
            peliculaService.borrarPelicula(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
