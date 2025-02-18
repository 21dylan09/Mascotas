package com.example.mascotas;


import java.util.List;

public class Categoria {
    private String nombre;
    private List<String> razas;

    public Categoria(String nombre, List<String> razas) {
        this.nombre = nombre;
        this.razas = razas;
    }

    public String getNombre() {
        return nombre;
    }

    public List<String> getRazas() {
        return razas;
    }
}
