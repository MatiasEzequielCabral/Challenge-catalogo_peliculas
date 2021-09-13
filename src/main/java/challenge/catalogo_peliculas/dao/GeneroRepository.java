package challenge.catalogo_peliculas.dao;

import challenge.catalogo_peliculas.data.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {

}
