package cuentaBancaria;

public class Main {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria("Ahorros", "Ana Alvarado", "1001", 50000.0);
        CuentaBancaria cuenta2 = new CuentaBancaria("Corriente" , "Oscar Preciado", "1002", 100000.0);
        System.out.println(cuenta);

        cuenta.depositar(20000);
        cuenta.retirar(100000);
        cuenta.retirar(30000);
        cuenta.depositar(-500);

        System.out.println("Saldo final (getter): $" + cuenta.getSaldo());
        System.out.println(cuenta);

        System.out.println("Saldo final cuenta2: $" + cuenta2.getSaldo());
    }
}
