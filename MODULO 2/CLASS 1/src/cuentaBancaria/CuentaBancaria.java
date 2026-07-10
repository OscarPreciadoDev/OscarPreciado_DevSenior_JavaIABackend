package cuentaBancaria;

public class CuentaBancaria {
    private String titular;
    private String numeroCuenta;
    private String tipoCuenta; // (ahorros / corriente)
    private double saldo;

    public CuentaBancaria(String s) {
        this.tipoCuenta = "Sin asignar";
        this.titular = "Sin asignar";
        this.numeroCuenta = "0000";
        this.saldo = 0.0;
    }

    public CuentaBancaria(String tipoCuenta, String titular, String numeroCuenta, double saldoInicial) {
        this.tipoCuenta = tipoCuenta;
        this.titular = titular;
        this.numeroCuenta = numeroCuenta;
        if (saldoInicial >= 0) {
            this.saldo = saldoInicial;
        } else {
            this.saldo = 0.0;
        }
    }

    public String getTitular() {
        return titular;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto) {
        if (monto <= 0) {
            System.out.println("Error: el monto a depositar debe ser mayor a cero.");
            return;
        }
        saldo += monto;
        System.out.println("Deposito exitoso. Nuevo saldo: $" + saldo);
    }

    public void retirar(double monto) {
        if (monto <= 0) {
            System.out.println("Error: el monto a retirar debe ser mayor a cero.");
            return;
        }
        if (monto > saldo) {
            System.out.println("Error: fondos insuficientes. Saldo actual: $" + saldo);
            return;
        }
        saldo -= monto;
        System.out.println("Retiro exitoso. Nuevo saldo: $" + saldo);
    }

    public String toString() {
        return "Tipo de cuenta: "+ tipoCuenta + "|Cuenta " + numeroCuenta + " | Titular: " + titular + " | Saldo: $" + saldo;
    }

    // Agregar un metodo transferir que reutilice 'retirar' en l acuenta origen y depositar en la cuenta destino

    public void transferir(CuentaBancaria destino, double monto){
        retirar(monto);
    }

}