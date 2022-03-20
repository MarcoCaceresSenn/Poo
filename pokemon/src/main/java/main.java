import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.print("Entrenador 1, ingrese su nombre: ");
        String entrenador1 = leer.next();
        System.out.println("\nEntrenador 2, ingrese su nombre: ");
        String entrenador2 = leer.next();
        Entrenador e1 = new Entrenador(entrenador1);
        Entrenador e2 = new Entrenador(entrenador2);
        Combatir combate = new Combatir(e1,e2);
    }
}
