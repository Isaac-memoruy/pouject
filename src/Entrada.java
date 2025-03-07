import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.println("ingrese su nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("igrese su edad: ");
        int edad = scanner.nextInt();

        
        System.out.println("Hola, " + nombre + ". Tienes " + edad + " años.");
    }
}