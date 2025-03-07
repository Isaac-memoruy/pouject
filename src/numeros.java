import java.util.Scanner;

public class numeros {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.println("Ingrese tres numeros");
        Float numero1 = input.nextFloat();
        Float numero2 = input.nextFloat();
        Float numero3 = input.nextFloat();
        Float media = (numero1 + numero2 + numero3) / 3f;
        System.out.println("El promedio es: " + media);
        input.close();

    }
}
