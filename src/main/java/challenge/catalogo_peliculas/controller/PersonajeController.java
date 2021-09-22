package challenge.catalogo_peliculas.controller;

import challenge.catalogo_peliculas.data.Personaje;
import challenge.catalogo_peliculas.dto.PersonajeCrearDto;
import challenge.catalogo_peliculas.dto.PersonajeEditarDto;
import challenge.catalogo_peliculas.service.PersonajeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/characters")
@CrossOrigin("*")
public class PersonajeController {

    private final PersonajeService personajeService;

    public PersonajeController(PersonajeService personajeService) {
        this.personajeService = personajeService;
    }

    @GetMapping("/personajes")
    public ResponseEntity<?> mostrarPersonajes(){
        try{
            return new ResponseEntity<>(personajeService.showAll(), HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<?> mostrarPorNombresEImagenes(){
        try{
            return new ResponseEntity<>(personajeService.showNombresAndImagen(), HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("movies/{id}")
    public ResponseEntity<?> mostrarPelisPorId(@PathVariable Long id){
        try{
            return new ResponseEntity<>(personajeService.mostrarPeliculasPorId(id), HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<?> mostrarPorNombre(@PathVariable String nombre){
        try{
            return new ResponseEntity<>(personajeService.buscarPorNombre(nombre), HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/edad/{edad}")
    public ResponseEntity<?> mostrarPorEdad(@PathVariable int edad){
        try{
            return new ResponseEntity<>(personajeService.buscarPorEdad(edad), HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/peso/{peso}")
    public ResponseEntity<?> mostrarPorPeso(@PathVariable int peso){
        try{
            return new ResponseEntity<>(personajeService.buscarPorPeso(peso), HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarPersonaje(@PathVariable Long id, @RequestBody PersonajeEditarDto personajeDto){
        try{
            return new ResponseEntity<>(personajeService.replacePersonaje(id, personajeDto), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> guardarPersonaje(@RequestBody PersonajeCrearDto personaje){
        try{
            Personaje nuevoPersonaje = personajeService.newPersonaje(personaje);
            return new ResponseEntity<>(nuevoPersonaje, HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarPersonaje(@PathVariable Long id){
        try{
            personajeService.deletePersonaje(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
