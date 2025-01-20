package com.roy.literatura.principal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.roy.literatura.model.DatosLibro;
import com.roy.literatura.model.Libro;
import com.roy.literatura.repository.LibroRepository;
import com.roy.literatura.service.ConsumoAPI;
import com.roy.literatura.service.ConvierteDatos;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books/?search=";
    private ConvierteDatos conversor = new ConvierteDatos();
    private List<DatosLibro> datosLibro = new ArrayList<>();
    private LibroRepository repositorio;
    private List<Libro> libros;
    Optional<Libro> LibroBuscado;

    public Principal(LibroRepository repository) {
        this.repositorio = repository;
    }

    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    [1] Buscar libro por titulo 
                    [2] Listar libros registrados
                    [3] Listar autores registrados
                    [4] Listar autores vivos en un determinado año
                    [5] Listar libros por idiomas          
                    [0] - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibro();
                    break;
                case 2:
                    //listarLibros();
                    break;

                case 3:
                    //listarAutores();
                    break;
                case 4:
                    //listarAutoresVivos();
                    break;
                case 5:
                    //listarLibrosPorIdioma();
                    break;

                case 0:
                    System.out.println(">>Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }

    }



    private DatosLibro getDatosLibro() {
        System.out.println("Ingresa el nombre del libro que deseas buscar");
        var nombreLibro = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + nombreLibro.replace(" ", "%20"));
        System.out.println(json);
        DatosLibro datos = conversor.obtenerDatos(json, DatosLibro.class);
        return datos;
    }
//    private void buscarEpisodioPorSerie() {
//        mostrarLibrosBuscados();
//        System.out.println("Escribe el nombre de la serie que deseas buscar para ver sus episodios");
//        var nombreSerie = teclado.nextLine();
//
//        Optional<Serie> serie = series.stream()
//                .filter(s -> s.getTitulo().toLowerCase().contains(nombreSerie.toLowerCase()))
//                .findFirst();
//
//        if (serie.isPresent()){
//            var serieEncontrada = serie.get();
//            List<DatosTemporadas> temporadas = new ArrayList<>();
//
//            for (int i = 1; i <= serieEncontrada.getTotalTemporadas(); i++) {
//                var json = consumoApi.obtenerDatos(URL_BASE + serieEncontrada.getTitulo().replace(" ", "+") + "&season=" + i + API_KEY);
//                DatosTemporadas datosTemporada = conversor.obtenerDatos(json, DatosTemporadas.class);
//                temporadas.add(datosTemporada);
//            }
//            temporadas.forEach(System.out::println);
//            List<Episodio> episodios = temporadas.stream()
//                    .flatMap(d -> d.episodios().stream()
//                            .map(e -> new Episodio(d.numero(), e)))
//                    .collect(Collectors.toList());
//
//            serieEncontrada.setEpisodios(episodios);
//            repositorio.save(serieEncontrada);
//        }
//
//
//    }
//
//
    private void buscarLibro() {
        DatosLibro datos = getDatosLibro();
        Libro libro = new Libro(datos);
        repositorio.save(libro);
        //datosSerie.add(datos);
        System.out.println(datos);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(datos.idiomas());
    }
//
//    private void listarLibros() {
//
//        libros = repositorio.findAll();
//
//        libros.stream()
//                .sorted(Comparator.comparing(Libro::getGenero))
//                .forEach(System.out::println);
//
//    }
//
//    private void listarAutores(){
//        System.out.println("Escribe el nombre del autor que deseas buscar");
//        var nombreAutor = teclado.nextLine();
//        autorBuscado = repositorio.findByAutorContainsIgnoreCase(nombreAutor);
//
//        if(autorBuscado.isPresent()){
//            System.out.println("El autor buscado es: " + autorBuscado.get());
//        }else {
//            System.out.println("No se ha encontrado el autor");
//        }
//    }
//
//
//    private void listarLibrosPorIdioma(){
//        System.out.println("Escriba el genero/categoría de la serie que desea buscar: ");
//        var genero = teclado.nextLine();
//        var categoria = Categoria.fromEspanol(genero);
//        List<Serie> seriesPorCategoria = repositorio.findByGenero(categoria);
//        System.out.println("Las series de la categoría " + genero + " son: ");
//        seriesPorCategoria.forEach(System.out::println);
//    }
//
//    private void listarAutoresVivos(){
//        System.out.println("Escriba el año para filtrar: ");
//        var tiempo = Integer.parseInt(teclado.nextLine());
//        List<Autor> autoresVivos = repositorio.seriePorTemporadaYEvaluacion(tiempo);
//        System.out.println("Los autores vivos en ese año son: ");
//        autoresVivos.forEach(s -> System.out.println(s.getTitulo() +" - " + s.getTotalTemporadas() + " - " + s.getEvaluacion()));
//    }
//
//    private void BuscarEpisodiosPorTitulos(){
//        System.out.println("Escriba el nombre del episodio que desea buscar: ");
//        var nombreEpisodio = teclado.nextLine();
//        List<Episodio> episodiosEncontrados= repositorio.episodiosPorNombre(nombreEpisodio);
//        episodiosEncontrados.forEach(e ->
//                System.out.printf("Serie: %s - Temporada: %s - Episodio: %s - Evaluación: %s \n",
//                        e.getSerie().getTitulo(), e.getTemporada(), e.getNumeroEpisodio(), e.getEvaluacion()));
//    }
}
