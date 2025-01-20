package com.roy.literatura.model;

public enum Lenguaje {
    ESPANOL("es", "Español"),
    INGLES("en", "Inglés"),
    FRANCES("fr", "Francés"),
    PORTUGUES("pt", "Portugués");


    private String lenguajeOMDB;
    private String lenguajeEspanol;

    Lenguaje(String lenguajeOMDB, String lenguajeEspanol){
        this.lenguajeOMDB = lenguajeOMDB;
        this.lenguajeEspanol = lenguajeEspanol;
    }

    public static Lenguaje fromString(String text){
        for (Lenguaje lenguaje: Lenguaje.values()){
            if (lenguaje.lenguajeOMDB.equalsIgnoreCase(text)){
                return lenguaje;
            }
        }

        throw  new IllegalArgumentException("Ningún idioma fue encontrado: " + text);
    }

    public static Lenguaje fromEspanol(String text){
        for (Lenguaje lenguaje: Lenguaje.values()){
            if (lenguaje.lenguajeEspanol.equalsIgnoreCase(text)){
                return lenguaje;
            }
        }

        throw  new IllegalArgumentException("Ningún idioma fue encontrado: " + text);
    }
}
