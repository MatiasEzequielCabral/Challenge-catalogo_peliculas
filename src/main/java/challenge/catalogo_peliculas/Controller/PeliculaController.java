package challenge.catalogo_peliculas.Controller;

import challenge.catalogo_peliculas.dao.PeliculaRepository;
import challenge.catalogo_peliculas.data.Pelicula;
import challenge.catalogo_peliculas.service.PeliculaService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Service
public class PeliculaController  implements PeliculaService {

    private final PeliculaRepository repositorio;

    public PeliculaController(PeliculaRepository repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping("/peliculas")
    @Override
    public List<Pelicula> mostrarTodasPeliculas() {
        return repositorio.findAll();
    }

    @GetMapping("/peliculas/titulo/{titulo}")
    @Override
    public Pelicula buscarPorTitulo(@PathVariable String titulo){
        return repositorio.findByTitulo(titulo);
    }

    @GetMapping("/peliculas/orden/ASC")
    @Override
    public List<Pelicula> buscarPorCreacionAscendente() {
        return repositorio.findAllByOrderByFechaCreacionAsc();
    }

    @GetMapping("/peliculas/orden/DESC")
    @Override
    public List<Pelicula> buscarPorCreacionDescendente() {
        return repositorio.findAllByOrderByFechaCreacionDesc();
    }

    @PostMapping("/peliculas")
    @Override
    public Pelicula nuevaPelicula(@RequestBody Pelicula nuevaPelicula) {
        return repositorio.save(nuevaPelicula);
    }

    @PutMapping("/peliculas/{id}")
    @Override
    public Pelicula reemplazarPelicula(@RequestBody Pelicula nuevaPelicula, @PathVariable Long id) {
        return repositorio.findById(id)
                .map(pelicula -> {
                    pelicula.setTitulo(nuevaPelicula.getTitulo());
                    return repositorio.save(pelicula);
                })
                .orElseGet(() -> {
                    nuevaPelicula.setId(id);
                    return repositorio.save(nuevaPelicula);
                });
    }

    @DeleteMapping("/peliculas/{id}")
    @Override
    public void borrarPelicula(@PathVariable Long id) {
        repositorio.deleteById(id);
    }
}
