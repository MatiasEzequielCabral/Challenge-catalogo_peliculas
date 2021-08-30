package challenge.catalogo_peliculas.dao;

import challenge.catalogo_peliculas.data.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {

    //@Query("select genero.peliculas from Genero genero")
    List<Genero> getAllPeliculasById(Long id);
}
