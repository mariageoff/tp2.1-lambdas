package main.java.lambdas3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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
//
//    public List<Persona> nombresCuyaCantidadDeLetrasEsPar(List<Persona> p) {
//        List<Persona> resultado = new ArrayList<>();
//        for (Persona persona : p) {
//            if (persona.nombre().length() % 2 == 0) {
//                resultado.add(persona);
//            }
//        }
//        return resultado;
//    }

/*
    para mo usar sream(), hice extract method del codigo repetido
    y pase por lambda la condicion que cambia para cada caso.
*/
    private static List<Persona> reccorerListaEvaluandoCondicion(List<Persona> p, Predicate<Persona> condicion) {
        List<Persona> resultado = new ArrayList<>();
        for (Persona persona : p) {
            if (condicion.test(persona)) {
                resultado.add(persona);
            }
        }
        return resultado;
    }

    public static List<Persona> nombresQueEmpiezanConE(List<Persona> listaPersonas) {
        return listaPersonas.stream()
                .filter(persona -> persona.nombre().toLowerCase().startsWith("e"))
                .toList();
    }

    public static List<Persona> nombresQueEmpiezanConESinStream(List<Persona> listaPersonas){
        return reccorerListaEvaluandoCondicion(listaPersonas, (persona) -> persona.nombre().startsWith("E"));
    }

    public static List<Persona> nombresCuyaCantidadDeLetrasEsPar(List<Persona> listaPersonas) {
        return listaPersonas.stream()
                .filter(persona -> persona.nombre().length()%2==0)
                .toList();
    }

    public static List<Persona> nombresCuyaCantidadDeLetrasEsParSinStream(List<Persona> listaPersonas){
        return reccorerListaEvaluandoCondicion(listaPersonas, (persona) -> persona.nombre().length()%2==0);
    }
}