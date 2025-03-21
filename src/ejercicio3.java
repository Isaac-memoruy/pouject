import java.util.Scanner;

public class ejercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un numero positivo de uno a dos digitos entre (1..99): ");
        int number = scanner.nextInt();

        if (number >=0 && number <=9) {
            System.out.println("el numero tiene un digitos ");
            
        }else if (number >=0 && number <=99) {
            
            System.out.println("el numero tiene dos digitos ");
        }else{
            System.out.println("El numero esta fuera de rango ");

        }
        
        {

        }

        scanner.close();
    }



}
