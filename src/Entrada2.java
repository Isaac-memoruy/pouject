import java.util.Scanner;

public class Entrada2 {
    public static void main(String[] args) {
    Scanner scanner = new Scanner (System.in);
    System.out.println("ingrese su nombre: ");
    String nombre = scanner.nextLine();
    System.out.println("igrese su edad: ");
    int edad = scanner.nextInt();
    System.out.println("ingrese su altura: ");
    int altura = scanner.nextInt();
    System.out.println("Hola, " + nombre + ". Tienes " + edad + " años " + " y mides " + altura);
    }
}
