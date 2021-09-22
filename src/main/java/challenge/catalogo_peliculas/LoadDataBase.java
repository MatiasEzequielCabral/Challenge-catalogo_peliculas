package challenge.catalogo_peliculas;

import challenge.catalogo_peliculas.repository.GeneroRepository;
import challenge.catalogo_peliculas.repository.PeliculaRepository;
import challenge.catalogo_peliculas.repository.PersonajeRepository;
import challenge.catalogo_peliculas.model.Genero;
import challenge.catalogo_peliculas.model.Pelicula;
import challenge.catalogo_peliculas.model.Personaje;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
public class LoadDataBase {

    private static final Logger log = LoggerFactory.getLogger(LoadDataBase.class);

    @Bean
    CommandLineRunner initDatabase(PersonajeRepository personajeRepository, PeliculaRepository peliculaRepository, GeneroRepository generoRepository) {
        return args -> {

            List<Personaje> lp1 = new ArrayList<>();
            List<Personaje> lp2 = new ArrayList<>();
            List<Personaje> lp3 = new ArrayList<>();
            List<Personaje> lp4 = new ArrayList<>();

            List<Pelicula> lpeli1 = new ArrayList<>();
            List<Pelicula> lpeli2 = new ArrayList<>();
            List<Pelicula> lpeli3 = new ArrayList<>();
            List<Pelicula> lpeli4 = new ArrayList<>();

            List<Pelicula> lPeliGenero1 = new ArrayList<>();
            List<Pelicula> lPeliGenero2 = new ArrayList<>();
            List<Pelicula> lPeliGenero3 = new ArrayList<>();

            Personaje p1 = new Personaje("soy urll", "Sara", 15, 70, "hola bb",null);
            Personaje p2 = new Personaje("urlita", "Felipe", 15, 73, "al final",null);
            Personaje p3 = new Personaje("soy pepito.rul", "Pepe", 11, 72, "hola",null);
            Personaje p4 = new Personaje("url del fin del mundo", "Antonio", 53, 90, "hellou",null);

            Pelicula peli1 = new Pelicula("soy una imagen", "tomb rider", new Date(), 2, null);
            Pelicula peli2 = new Pelicula("soy una imagen", "madagascar", new Date(), 5, null);
            Pelicula peli3 = new Pelicula("soy una imagen", "hitman", new Date(), 3, null);
            Pelicula peli4 = new Pelicula("soy una imagen", "la bruja", new Date(), 4, null);

            Genero gro1 = new Genero("accion", "soy una imagen", null);
            Genero gro2 = new Genero("terror", "soy una imagen", null);
            Genero gro3 = new Genero("animacion", "soy una imagen", null);

            lp1.add(p1); lp1.add(p2);
            lp2.add(p3); lp2.add(p4);
            lp3.add(p1); lp3.add(p3);
            lp4.add(p1); lp4.add(p4);

            lpeli1.add(peli1); lpeli1.add(peli3); lpeli1.add(peli4);
            lpeli2.add(peli1);
            lpeli3.add(peli2); lpeli3.add(peli3);
            lpeli4.add(peli2); lpeli4.add(peli4);

            lPeliGenero1.add(peli1); lPeliGenero1.add(peli3);
            lPeliGenero2.add(peli4);
            lPeliGenero3.add(peli2);

            p1.setPeliculas(lpeli1);
            p2.setPeliculas(lpeli2);
            p3.setPeliculas(lpeli3);
            p4.setPeliculas(lpeli4);

            peli1.setPersonajes(lp1);
            peli2.setPersonajes(lp2);
            peli3.setPersonajes(lp3);
            peli4.setPersonajes(lp4);

            gro1.setPeliculas(lPeliGenero1);
            gro2.setPeliculas(lPeliGenero2);
            gro3.setPeliculas(lPeliGenero3);
            /*
            peliculaRepository.save(peli1);
            peliculaRepository.save(peli2);
            peliculaRepository.save(peli3);
            peliculaRepository.save(peli4);
            peliculaRepository.findAll().forEach(pelicula -> log.info("Preloaded " + pelicula));

            generoRepository.save(gro1);
            generoRepository.save(gro2);
            generoRepository.save(gro3);
            generoRepository.findAll().forEach(genero -> log.info("Preloaded " + genero));

            personajeRepository.save(p1);
            personajeRepository.save(p2);
            personajeRepository.save(p3);
            personajeRepository.save(p4);
            personajeRepository.findAll().forEach(personaje -> log.info("Preloaded " + personaje));
            */
        };
    }
}
