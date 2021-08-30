package challenge.catalogo_peliculas.service;

import challenge.catalogo_peliculas.data.Personaje;

import java.util.List;

public interface PersonajeService {

    List<Personaje> showAll();
    List<String> showNombresAndImagen();
    List<Personaje> mostrarPeliculasPorId(Long id);
    List<Personaje> buscarPorNombre(String nombre);
    List<Personaje> buscarPorEdad(int edad);
    List<Personaje> buscarPorPeso(int peso);
    Personaje newPersonaje(Personaje newPersonaje);
    Personaje replacePersonaje(Personaje newPersonaje, Long id);
    void deletePersonaje(Long id);
}
