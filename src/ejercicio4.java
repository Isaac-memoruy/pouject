import java.util.Scanner;

public class ejercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad en dolares: ");
        double Paga = scanner.nextDouble();
        if (Paga > 3000) {
            System.out.println("Se prodocede con el abono de impuestos: ");
        }else{
            System.out.println("No se procede con el abono de impuestos: " );
        }
        scanner.close();
    }
}
