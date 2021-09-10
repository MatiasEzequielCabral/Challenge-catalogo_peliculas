package challenge.catalogo_peliculas.dao;

import challenge.catalogo_peliculas.data.Genero;
import challenge.catalogo_peliculas.data.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {
    List<Genero> findByPeliculas(Pelicula peliculas);

}
