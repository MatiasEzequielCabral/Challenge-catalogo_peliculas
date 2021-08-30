package challenge.catalogo_peliculas.Controller;

import challenge.catalogo_peliculas.dao.GeneroRepository;
import challenge.catalogo_peliculas.data.Genero;
import challenge.catalogo_peliculas.service.GeneroService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Service
public class GeneroController implements GeneroService {

    private final GeneroRepository repositorio;

    public GeneroController(GeneroRepository repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping("/generos")
    @Override
    public List<Genero> mostrarTodasGenero() {
        return repositorio.findAll();
    }

    @GetMapping("/peliculas/genero/{id}")
    @Override
    public List<Genero> mostrarTodasPeliculasPorId(@PathVariable Long id){
        return repositorio.getAllPeliculasById(id);
    }

    @PostMapping("/generos")
    @Override
    public Genero nuevaGenero(@RequestBody Genero nuevaGenero) {
        return repositorio.save(nuevaGenero);
    }

    @PutMapping("/generos/{id}")
    @Override
    public Genero reemplazarGenero(@RequestBody Genero nuevaGenero, @PathVariable Long id) {
        return repositorio.findById(id)
                .map(genero -> {
                    genero.setNombre(nuevaGenero.getNombre());
                    return repositorio.save(genero);
                }).orElseGet(() ->{
                    nuevaGenero.setId(id);
                    return repositorio.save(nuevaGenero);
                });
    }

    @DeleteMapping("/generos/{id}")
    @Override
    public void borrarGenero(@PathVariable Long id) {
        repositorio.deleteById(id);
    }
}
