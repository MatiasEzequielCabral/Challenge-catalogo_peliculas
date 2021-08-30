package challenge.catalogo_peliculas.Controller;

import challenge.catalogo_peliculas.dao.PersonajeRepository;
import challenge.catalogo_peliculas.data.Personaje;
import challenge.catalogo_peliculas.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Service
public class PersonajeController implements PersonajeService {

    private final PersonajeRepository repository;

    PersonajeController(PersonajeRepository repository){
        this.repository = repository;
    }

    @GetMapping("/personajes")
    @Override
    public List<Personaje> showAll() {
        return repository.findAll();
    }

    @GetMapping("/characters")
    @Override
    public List<String> showNombresAndImagen(){
        return repository.getAllNombresAndImagen();
    }

    @GetMapping("/characters/peliculas/{id}")
    @Override
    public List<Personaje> mostrarPeliculasPorId(@PathVariable Long id){
        return repository.getAllPeliculasById(id);
    }

    @GetMapping("/characters/nombre/{nombre}")
    @Override
    public List<Personaje> buscarPorNombre(@PathVariable String nombre){
        return repository.findByNombre(nombre);
    }

    @GetMapping("/characters/edad/{edad}")
    @Override
    public List<Personaje> buscarPorEdad(@PathVariable int edad){
        return repository.findByEdad(edad);
    }

    @GetMapping("/characters/peso/{peso}")
    @Override
    public List<Personaje> buscarPorPeso(@PathVariable int peso){
        return repository.findByPeso(peso);
    }

    @PostMapping("/personajes")
    @Override
    public Personaje newPersonaje(@RequestBody Personaje newPersonaje) {
        return repository.save(newPersonaje);
    }

    @PutMapping("/personajes/{id}")
    @Override
    public Personaje replacePersonaje(@RequestBody Personaje newPersonaje, @PathVariable Long id) {

        return repository.findById(id)
                .map(personaje -> {
                    personaje.setNombre(newPersonaje.getNombre());
                    return repository.save(personaje);
                })
                .orElseGet(() -> {
                    newPersonaje.setId(id);
                    return repository.save(newPersonaje);
                });
    }

    @DeleteMapping("/personajes/{id}")
    @Override
    public void deletePersonaje(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
