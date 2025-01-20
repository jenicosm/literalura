package com.roy.literatura.service;

import com.roy.literatura.dto.AutorDTO;
import com.roy.literatura.dto.LibroDTO;
import com.roy.literatura.model.Lenguaje;
import com.roy.literatura.model.Libro;
import com.roy.literatura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LibroService {

    @Autowired
    private LibroRepository repository;

    public List<LibroDTO> obtenerTodasLasSeries(){
        return convierteDatos(repository.findAll());
    }

    public List<LibroDTO> obtenerTop5(){
        return convierteDatos(repository.findAll());
    }

    public List<LibroDTO> obtenerLanzamientosMasRecientes(){
        return convierteDatos(repository.findAll());
    }

    public List<LibroDTO> convierteDatos(List<Libro> libro){
        return libro.stream()
                .map(l -> new LibroDTO(l.getId(), l.getTitulo(), l.getIdioma(), l.getTotalDescargas()))
                .collect(Collectors.toList());
    }

    public LibroDTO obtenerPorId(Long id) {
        Optional<Libro> serie = repository.findById(id);
        if (serie.isPresent()){
            Libro l = serie.get();
            return new LibroDTO(l.getId(),l.getTitulo(), l.getIdioma(), l.getTotalDescargas());
        }
        return null;
    }

    public List<AutorDTO> obtenerTodasLasTemporadas(Long id) {
        Optional<Libro> libro = repository.findById(id);
        if (libro.isPresent()){
            Libro l = libro.get();
            return l.getAutores().stream().map(a -> new AutorDTO(a.getNombre(), a.getFechaDeNacimiento(),
                    a.getFechaDeFallecimiento())).collect(Collectors.toList());
        }
        return null;
    }

//    public List<AutorDTO> obtenerTemporadaPorNumero(Long id, Long fechaDeFallecimiento) {
//        return repository.obtenerTemporadasPorNuero(id,fechaDeFallecimiento).stream()
//                .map(a -> new AutorDTO(a.getNombre(), a.getFechaDeNacimiento(),
//                        a.getFechaDeFallecimiento())).collect(Collectors.toList());
//    }

    public List<LibroDTO> obtenerSeriePorCategoria(String idioma) {
        Lenguaje lenguaje = Lenguaje.fromEspanol(idioma);
        return convierteDatos(repository.findByIdioma(lenguaje));
    }
}
