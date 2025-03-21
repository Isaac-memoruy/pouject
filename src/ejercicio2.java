import java.util.Scanner;

public class ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la primera nota del alumno ");
        double PrimeraNota = scanner.nextDouble();
        System.out.println("Ingrese la segunda nota del estudiante: ");
        double SegundaNota = scanner.nextDouble();
        System.out.println("Ingrese la tercera nota del estudinate: ");
        double TerceraNota = scanner.nextDouble();

        double notapromedio = (PrimeraNota + SegundaNota + TerceraNota) / 3;

        if (notapromedio >=7) {
            System.out.println("El estudiante es promocionado");
            
        }else{
            System.out.println("El estudiante no es promcionado");
        }
        scanner.close();
    }
}
