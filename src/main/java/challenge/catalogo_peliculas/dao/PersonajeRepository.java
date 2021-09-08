package challenge.catalogo_peliculas.dao;

import challenge.catalogo_peliculas.data.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, Long> {

    @Query("select personaje.nombre, personaje.imagen from Personaje personaje")
    List<String> getAllNombresAndImagen();

    List<Personaje> getAllPeliculasById(Long id);

    List<Personaje> findByNombre(String nombre);

    List<Personaje> findByEdad(int edad);

    List<Personaje> findByPeso(int edad);

}
