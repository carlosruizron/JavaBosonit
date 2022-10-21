package org.example;
// Creamos el constructor de People con sus Getters
public class People {
    private String nombre;
    private String ciudad;
    private int edad;

    People(String nombre, String ciudad, int edad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getEdad() {
        return edad;
    }
}
