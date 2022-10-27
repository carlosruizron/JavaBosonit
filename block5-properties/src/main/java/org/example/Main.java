package org.example;

import java.io.*;
import java.util.Properties;
import java.io.BufferedReader;

public class Main {
    private static final String ApplicationProperties = "./block5-properties/src/main/resources/application.yml";

    public static void main(String[] args) {

        Properties propiedades = new Properties();

        try{
            BufferedReader br = new BufferedReader (new FileReader(ApplicationProperties));

            propiedades.load(br);

            System.out.println("El valor de greeting es: " + propiedades.getProperty("greeting"));
            System.out.println("El valor de my.number es: " + propiedades.getProperty("my.number"));
            System.out.println("El valor de new.property es: " + propiedades.getProperty("new.property"));


        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}