package challenge.catalogo_peliculas.service;

import challenge.catalogo_peliculas.model.Personaje;
import challenge.catalogo_peliculas.dto.PersonajeCrearDto;
import challenge.catalogo_peliculas.dto.PersonajeEditarDto;

import java.util.List;

public interface PersonajeService {

    List<Personaje> showAll();
    List<String> showNombresAndImagen();
    List<Personaje> mostrarPeliculasPorId(Long id);
    List<Personaje> buscarPorNombre(String nombre);
    List<Personaje> buscarPorEdad(int edad);
    List<Personaje> buscarPorPeso(int peso);
    Personaje newPersonaje(PersonajeCrearDto newPersonaje);
    Personaje replacePersonaje(Long id, PersonajeEditarDto newPersonaje);
    void deletePersonaje(Long id);
}
