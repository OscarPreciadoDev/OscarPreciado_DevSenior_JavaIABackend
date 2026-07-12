package cuentaBancariaUpper;

public class CuentaBancaria {

    // Declaracion de atributos de la clase
    private String titular;
    private String numeroCuenta;
    private double saldo;
    private String tipoCuenta;

    // Constructor vacio
    public CuentaBancaria() {
        this.titular = "Sin asignar";
        this.numeroCuenta = "0000";
        this.saldo = 0.0;
        this.tipoCuenta = "Sin asignar";
    }

    // Constructor con parametros
    public CuentaBancaria(String titular, String numeroCuenta, double saldoInicial) {
        this.titular = titular;
        this.numeroCuenta = numeroCuenta;
        if (saldoInicial >= 0) {
            this.saldo = saldoInicial;
        } else {
            this.saldo = 0.0;
        }
    }

    // Getters de los atributos para acceder de manera controlada


    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    // Metodo controlado para el uso depósito de dinero

    public void depositar(double monto) {
        if (monto <= 0) {
            System.out.println("Error: el monto a depositar debe ser mayor a 0.");
        } else {
            saldo += monto;
            System.out.println("Deposito exitoso. Nuevo saldo: $" + saldo);
        }
    }

    // Metodo controlado para el uso retiro de dinero

    public void retirar(double monto) {
        if (monto <= 0) {
            System.out.println("Error: el monto a retirar debe ser mayor a 0.");
            return;
        }
        if (monto > saldo) {
            System.out.println("Error: fondos insuficientes. Saldo actual: $" + saldo);
            return;
        } else {
            saldo -= monto;
            System.out.println("Retiro exitoso. Nuevo saldo: $" + saldo);
        }

    }

    // Metodo toString() para mostrar correctamente el objeto

    public String toString() {
        return ("Cuenta " + numeroCuenta + " | Titular: " + titular + " | Saldo: " + saldo);
    }

    // Metodo que reutilize retirar en una cuenta de origen y depositar en la de destino.

    public void transferir(CuentaBancaria destino, double monto) {
        if (destino == this) {
            System.out.println("Error: No puede transferir a la misma cuenta. Saldo actual: $" + saldo);
            return;
        } else if (monto <= 0){
            System.out.println("Error: El monto debe ser mayor a 0. ");
            return;
            } else if (monto > saldo) {
            System.out.println("Error: fondos insuficientes. Saldo actual: $" + saldo);
            return;
        }   else {
            saldo -= monto;
            destino.depositar(monto);
        }
    }
}
