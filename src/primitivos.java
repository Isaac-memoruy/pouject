public class primitivos {

    public static void main(String[] args) {
        int numero = 10;

        cambiarValor(numero);

        System.out.println("Después del método: " + numero);
    }

    public static void cambiarValor(int valor) {
        valor = 50;
        System.out.println("Dentro del método: " + valor);
    }
}
