package main.java.lambdas1;

public class Main {
    public static void main(String[] args) {
        AprendiendoLambdas a = new AprendiendoLambdas();
        // A -> Usa B (recibe 1, devuelve void)
        a.unMetodo((b) -> { System.out.println("abcd" + b);});

        // B -> Usa A (recibe 0, devuelve void)
        a.unMetodo(() -> System.out.println("abcd"));

        // C -> Usa B (recibe 1, devuelve void)
        a.unMetodo((variable) -> {System.out.println("abcd");});

        // D -> Usa C (recibe 1, devuelve boolean)
        a.unMetodo((String variable) -> {
            System.out.println("abcd");
            return true;
        });

        // E -> Usa D (recibe Long, devuelve Long)
        a.unMetodo((Long variable) -> {
            System.out.println("abcd");
            return 10L;
        });
    }
}