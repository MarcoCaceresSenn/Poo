import java.util.ArrayList;
import java.util.Scanner;

public class Palindromo {

    private static ArrayList<Integer> lista = new ArrayList();

    /*
ir guardando los numeros en un arreglo
    */

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Bienvenido, a partir de ahora puedes ingresar dos números de tres cifras");
        System.out.println("Ingresa un numero");

        int numero1 = teclado.nextInt();

        System.out.println("Ingresa otro numero");

        int numero2 = teclado.nextInt();

        multiplicar(numero1,numero2);

    }

    public static void multiplicar(int num1, int num2){

        if(comprobarTresDigitos(num1) && comprobarTresDigitos(num2)){
            int resultado = (num1 * num2);
            if(comprobarPalindromo(String.valueOf(resultado))){
                System.out.println(resultado);
                lista.add(resultado);
            } else {
                System.out.println("no es");
            }
        }

    }

    public static boolean comprobarTresDigitos(int num){
        return num >= 100 || num <= 999;
    }

    public static boolean comprobarPalindromo(String resultado){
        int tamano = resultado.length();
        String reversa="";
        for(int i = tamano - 1; i >= 0; i--){
            reversa = reversa + resultado.charAt(i);
        }
        return resultado.equals(reversa);
    }

}
