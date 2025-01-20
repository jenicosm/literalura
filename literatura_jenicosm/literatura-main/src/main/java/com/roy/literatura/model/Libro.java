package com.roy.literatura.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "libro_autor",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private List<Autor> autores; // Relación many-to-many con Autor

    @Enumerated(EnumType.STRING)
    private Lenguaje idioma;
    private Integer totalDescargas;

    public Libro() {}

    public Libro(DatosLibro datosLibro) {
        this.titulo = datosLibro.titulo();
        if (datosLibro.idiomas() != null && !datosLibro.idiomas().isEmpty()) {
            this.idioma = Lenguaje.fromString(datosLibro.idiomas().get(0));
        } else {
            this.idioma = Lenguaje.ESPANOL; // O el valor predeterminado que definas
        }
        //this.idioma = Lenguaje.fromString(datosLibro.idiomas().getFirst());
        this.totalDescargas = datosLibro.totalDescargas();
    }

    @Override
    public String toString() {
        return "idioma=" + idioma +
                ", titulo='" + titulo + '\'' +
                ", total de descargas=" + totalDescargas +
                ", autores='" + autores + '\'';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public Lenguaje getIdioma() {
        return idioma;
    }

    public void setIdioma(Lenguaje idioma) {
        this.idioma = idioma;
    }

    public Integer getTotalDescargas() {
        return totalDescargas;
    }

    public void setTotalDescargas(Integer totalDescargas) {
        this.totalDescargas = totalDescargas;
    }
}
