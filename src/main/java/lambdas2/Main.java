package main.java.lambdas2;

public class Main {
    public static void main(String[] args) {

        AprendiendoLambdas objeto = new AprendiendoLambdas();

        //a. utilizando un lambda dado que imprima:
        // true si el largo del string es par,
        // false en caso contrario.
        objeto.unMetodo((c) -> {return c.length() % 2 == 0;});

        //b. utilizando un lambda dado que imprima
        //true si el String empieza con “a” minúscula,
        //false en caso contrario.
        objeto.unMetodo((c) -> {return c.startsWith("a");});
    }
}