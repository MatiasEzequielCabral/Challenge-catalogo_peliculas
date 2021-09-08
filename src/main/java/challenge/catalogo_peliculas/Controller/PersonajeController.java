package challenge.catalogo_peliculas.Controller;

import challenge.catalogo_peliculas.data.Personaje;
import challenge.catalogo_peliculas.dto.PersonajeDto;
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
        return new ResponseEntity<>(personajeService.showAll(), HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<?> mostrarPorNombresEImagenes(){
        return new ResponseEntity<>(personajeService.showNombresAndImagen(), HttpStatus.ACCEPTED);
    }

    @GetMapping("movies/{id}")
    public ResponseEntity<?> mostrarPelisPorId(@PathVariable Long id){
        return new ResponseEntity<>(personajeService.mostrarPeliculasPorId(id), HttpStatus.ACCEPTED);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<?> mostrarPorNombre(@PathVariable String nombre){
        return new ResponseEntity<>(personajeService.buscarPorNombre(nombre), HttpStatus.ACCEPTED);
    }

    @GetMapping("/edad/{edad}")
    public ResponseEntity<?> mostrarPorEdad(@PathVariable int edad){
        return new ResponseEntity<>(personajeService.buscarPorEdad(edad), HttpStatus.ACCEPTED);
    }

    @GetMapping("/peso/{peso}")
    public ResponseEntity<?> mostrarPorPeso(@PathVariable int peso){
        return new ResponseEntity<>(personajeService.buscarPorPeso(peso), HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarPersonaje(@PathVariable Long id, @RequestBody PersonajeDto personajeDto){
        return new ResponseEntity<>(personajeService.replacePersonaje(id, personajeDto), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> guardarPersonaje(@RequestBody PersonajeDto personaje){
        Personaje nuevoPersonaje = personajeService.newPersonaje(personaje);
        return new ResponseEntity<>(nuevoPersonaje, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarPersonaje(@PathVariable Long id){
        personajeService.deletePersonaje(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
