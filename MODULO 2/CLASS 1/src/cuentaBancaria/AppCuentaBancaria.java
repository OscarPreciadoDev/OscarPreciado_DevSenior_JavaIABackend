package cuentaBancaria;

public class AppCuentaBancaria {
    public static void main(String[] args) {
        CuentaBancaria cuenta1 = new CuentaBancaria("Oscar Preciado" , "0001" , 50000.0);
        CuentaBancaria cuenta2 = new CuentaBancaria( "Nicoll Rubiano" ,  "0002" , 0.0);

        System.out.println("\n"+cuenta1+"\n"+cuenta2+"\n");

        cuenta1.depositar(20000);
        cuenta1.retirar(100000);
        cuenta1.retirar(30000);
        cuenta1.depositar(-500);

        // Usando el getter correspondiente
        System.out.println("Saldo final: $" + cuenta1.getSaldo());

        System.out.println("\n"+cuenta1+"\n"+cuenta2+"\n");


        // Prueba de transferir
        cuenta1.transferir(cuenta1 , 30000 ); // Error transferir misma cuenta
        cuenta1.transferir(cuenta2 , 60000);  // Error fondos
        cuenta1.transferir(cuenta2 , -500);   // Error negativo
        cuenta1.transferir(cuenta2 , 30000);  // Transaccion exitosa
        System.out.println("\nResumen de cuentas: ");
        System.out.println(cuenta1);
        System.out.println(cuenta2);


    }

}
