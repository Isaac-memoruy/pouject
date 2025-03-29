import java.util.Scanner;

public class matrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numeros = new int[5];
        System.out.println("Por favor, dame un total de 5 numeros:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }
        
        int suma = 0;
        for (int i = 0; i < 5; i++) {
            suma += numeros[i];
        }
        
        int promedio = suma / 5;
        
        System.out.println("El promedio de los numeros que fueron totalmente ingresados son: " + promedio);
        
        scanner.close();
    }
}