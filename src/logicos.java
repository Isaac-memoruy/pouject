import java.util.Scanner;

public class logicos {

    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.println("Ingrese tres numeros");
        int numero1 = input.nextInt();
        int numero2 = input.nextInt();
        int numero3 = input.nextInt();
        System.out.println("el numero es mayor que > el numero es menor que && el numero es menor que < el numero es mayor que : " + (numero1 > numero2 && numero2 < numero3));
        System.out.println("el numero es menor que < el numero es mayor que || el numero es mayor que > el numero es menor que : " + (numero1 < numero2 || numero2 > numero3));
        System.out.println("!(el numero es mayor que > el numero es menor que ): " + !(numero1 > numero2));
        
        
        input.close();
    }
}
