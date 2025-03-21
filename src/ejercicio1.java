import java.util.Scanner;

public class ejercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el primer numero: ");
        double numberOne = scanner.nextDouble();

        System.out.println("Ingrese el segundo numero: ");
        double numberTwo = scanner.nextDouble();

        int numberOneEntero = (int) numberOne;
        int numberTwoEntero = (int) numberTwo;
        
        
        
        if (numberOne > numberTwo) {
            int sumados = numberOneEntero +  numberTwoEntero;
            int diferentes = numberOneEntero - numberTwoEntero;
            System.out.println("La suma de numeros es: "+ sumados);
            System.out.println("La diferencia entre los numeros son: "+ diferentes);

        }else{
            if (numberTwo !=0) {
                int producción = numberOneEntero * numberTwoEntero;
                double divisor = numberOne / numberTwo;
                System.out.println("El producto de " + numberOne + " y " + numberTwo + " es: " + producción);
                System.out.println("La división de " + numberOne + " y " + numberTwo + " es: " + divisor);
             
            }
               
       
        }
        scanner.close();
    }
}
