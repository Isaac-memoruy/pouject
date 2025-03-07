public class se {
    public static void main(String[] args) {
        double saldoInicial = 1000.0;
        double retiroSemanal = 200.0;
        int semanasEnElMes = 4;
        double saldoFinal = saldoInicial - (retiroSemanal * semanasEnElMes);
        System.out.println("El saldo final en la cuenta es: $" + saldoFinal);
    }
    
}
