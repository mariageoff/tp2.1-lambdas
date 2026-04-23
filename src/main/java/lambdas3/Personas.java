package main.java.lambdas3;

import java.util.List;

public class Personas {

//    public List<Persona> nombresQueEmpiezanConE(List<Persona> p) {
//        List<Persona> resultado = new ArrayList<>();
//        for (Persona persona : p) {
//            if (persona.nombre().startsWith("E")) {
//                resultado.add(persona);
//            }
//        }
//        return resultado;
//    }

    public static List<Persona> nombresQueEmpiezanConE(List<Persona> listaPersonas) {
        return listaPersonas.stream()
                .filter(persona -> persona.nombre().toLowerCase().startsWith("e"))
                .toList();
    }

//    public List<Persona> nombresCuyaCantidadDeLetrasEsPar(List<Persona> p) {
//        List<Persona> resultado = new ArrayList<>();
//        for (Persona persona : p) {
//            if (persona.nombre().length() % 2 == 0) {
//                resultado.add(persona);
//            }
//        }
//        return resultado;
//    }

    public static List<Persona> nombresCuyaCantidadDeLetrasEsPar(List<Persona> listaPersonas) {
        return listaPersonas.stream()
                .filter(persona -> persona.nombre().length()%2==0)
                .toList();
    }
}