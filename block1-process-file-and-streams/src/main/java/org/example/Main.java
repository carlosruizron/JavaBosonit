package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.SocketOption;
import java.util.Optional;
import java.util.List;
import java.util.ArrayList;


public class Main {
    private static final String PeopleCSV = "./block1-process-file-and-streams/src/main/resources/people.csv";

    public static void main(String[] args) throws InvalidLineFormatException,  IOException {
        // Creamos el array para ir guardando los datos
        List<People> people = new ArrayList<>();
        // Creamos las variables
        String linea1;

        // Leemos el fichero indicado linea por linea.
        BufferedReader br = new BufferedReader (new FileReader(PeopleCSV));
        linea1 = br.readLine();

        try {
            // Cambiamos lo valores indicados por el ejercicio si los recibidos no estan especificados.
            while (linea1 != null) {
                String[] datos = linea1.split(":", -3);
                if(datos[1] == "") {
                    datos[1] = "Unknown";
                }
                else if(datos[2] == "") {
                    datos[2] = "0";
                }
                // Metemos los datos en el array creado anteriormente
                people.add(new People(datos[0], datos[1], Integer.parseInt(datos[2])));
                // Imprimimos en consola los datos recogidos
                System.out.println("Nombre: " + datos[0] + " " + "Ciudad: " + datos[1] + " " + "Edad: " + datos[2]);
                linea1 = br.readLine();
            }
            // Usamos la excepción para que nos avise cuando una linea no venga en el formato correcto
        } catch (Exception ex) {
            if (!checkPoints(linea1)) {
                ex.printStackTrace();
                System.out.println(ex.getMessage());
                throw new InvalidLineFormatException("Falta un simbolo separador:");
            }
            System.err.println(ex.getMessage());
        }

        Apartado1(people);
        Apartado2(people);
        Apartado3(people);
        Apartado4(people);
    }



    public static boolean checkPoints(String linea1) {
        int cont = 0;
        // Hacemos un bucle y vamos contando cuantos separadores tiene la linea
        for (int i = 0; i > linea1.length(); i++) {
            if (linea1.charAt(i)  == ':') {
                cont++;
            }
        }

        //	Si contamos 2  significa que estan todos
        if (cont == 2) {
            return true;
        } else {
            return false;
        }
    }

    // Personas menores de 25 años. No debe aparecer el 0
    public static void Apartado1(List<People> list) {
        System.out.println("\nMenores de 25");
        list.stream().filter(People -> People.getEdad() < 25 && People.getEdad() != 0).forEach(people -> {
            System.out.println("Nombre: " + people.getNombre() + " Ciudad: " + people.getCiudad() + " Edad: " + people.getEdad());
        });
    }

    // Nombre que NO empiecen con letra A
    public static void Apartado2(List<People> list) {
        System.out.println("\nNombres sin A al comienzo");
        list.stream().filter(People -> !People.getNombre().startsWith("A")).forEach(people -> {
            System.out.println("Nombre: " + people.getNombre() + " Ciudad: " + people.getCiudad() + " Edad: " + people.getEdad());
        });
    }

    //  Elemento que su ciudad sea Madrid.
    public static void Apartado3(List<People> list) {
        //Creamos el optional para usarlo de filtrado
        Optional<String> searchCiudad = Optional.ofNullable("Madrid");

        System.out.println("\nCiudad: Madrid");
        //  Usamos ese optional en el filtrado
        list.stream().filter(People -> People.getCiudad().contains(searchCiudad.get())).forEach( people -> {
            System.out.println("Nombre: " + people.getNombre() + " Ciudad: " + people.getCiudad() + " Edad: " + people.getEdad());
        });
    }

    //  Elemento que su ciudad sea Barcelona.
    public static void Apartado4(List<People> list) {

        Optional<String> searchCiudad = Optional.ofNullable("Barcelona");

        System.out.println("\nCiudad: Barcelona");
        list.stream().filter(People -> People.getCiudad().contains(searchCiudad.get())).forEach( people -> {
            System.out.println("Nombre: " + people.getNombre() + " Ciudad: " + people.getCiudad() + " Edad: " + people.getEdad());
        });
    }
}