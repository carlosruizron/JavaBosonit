package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Main {

    // Creamos la ruta relativa para encontrar esos ficheros
    private static final String ApplicationProperties = "./block5-properties/src/main/resources/application.properties.csv";

    public static void main(String[] args) {

        // Creamos un objeto de tipo Properties
        Properties propiedades = new Properties();

        try {
            BufferedReader br = new BufferedReader(new FileReader(ApplicationProperties));

            propiedades.load(br);

            // Creamos la variable para guardar la propiedad de new.property
            String newProperty = propiedades.getProperty("new.property");
            if (newProperty == null) {
                newProperty = "new.property no tiene valor";
            }
            // Imprimimos los valores mediante la consola
            System.out.println("El valor de greeting es: " + propiedades.getProperty("greeting"));
            System.out.println("El valor de my.number es: " + propiedades.getProperty("my.number"));
            System.out.println("El valor de new.property es: " + newProperty);

            // Ponemos en el catch la excepción por si algo falla que nos avise
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}