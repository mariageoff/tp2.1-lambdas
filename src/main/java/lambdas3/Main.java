package main.java.lambdas3;


import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Persona> listaPersonas = Arrays.asList(
                new Persona("Enzo", "Perez"),
                new Persona("Edgar", "Gomez"),
                new Persona("Ana", "Duarte"),
                new Persona("Esteban", "Quito")
        );

        List<Persona> nombresConE = Personas.nombresQueEmpiezanConE(listaPersonas);
        List<Persona> nombresLetrasPar = Personas.nombresCuyaCantidadDeLetrasEsPar(listaPersonas);

        System.out.println("Empiezan con E: " + nombresConE);
        System.out.println("Letras par: " + nombresLetrasPar);
    }
}