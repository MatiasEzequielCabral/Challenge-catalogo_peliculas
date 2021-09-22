package challenge.catalogo_peliculas.repository;

import challenge.catalogo_peliculas.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {

}
