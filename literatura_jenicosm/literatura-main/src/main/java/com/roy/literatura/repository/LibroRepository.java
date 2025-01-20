package com.roy.literatura.repository;

import com.roy.literatura.model.Autor;
import com.roy.literatura.model.Lenguaje;
import com.roy.literatura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    // 1. Buscar libro por título (ignora mayúsculas y minúsculas)
    Optional<Libro> findByTituloContainsIgnoreCase(String titulo);

    // 2. Listar todos los libros registrados
    List<Libro> findAll();

    // 3. Listar autores registrados
    @Query("SELECT a FROM Autor a")
    List<Autor> findAllAutores();

    // 4. Listar autores vivos en un determinado año
    @Query("SELECT a FROM Autor a WHERE a.fechaDeFallecimiento IS NULL OR a.fechaDeFallecimiento > :anioActual")
    List<Autor> findAutoresVivosEnAnio(@Param("anioActual") int anioActual);

    // 5. Listar libros por idioma
    List<Libro> findByIdioma(Lenguaje idioma);

    // 6. Consultas adicionales
    @Query("SELECT l FROM Libro l WHERE l.totalDescargas > :descargasMinimas ORDER BY l.totalDescargas DESC")
    List<Libro> findLibrosPorDescargas(@Param("descargasMinimas") int descargasMinimas);

    @Query("SELECT a FROM Autor a WHERE a.nombre LIKE %:nombre%")
    List<Autor> findAutoresPorNombre(@Param("nombre") String nombre);


    // 7. Otros métodos a implementar según sea necesario
    // @Query("SELECT l FROM Libro l ORDER BY l.fechaDeLanzamiento DESC")
    // List<Libro> lanzamientosMasRecientes();
}
