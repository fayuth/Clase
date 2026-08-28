package bank;


import bank.cajero.Cajero;
import bank.client.Client;
import bank.cuenta.Account;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Account cuenta = new Account("1234567", (int) 43000.0, "Ahorros");

        Client cliente = new Client("1", "Fayuth Rojas", "1067596127", , "1234");

        Cajero cajero = new Cajero("ASD", "Barraqulla");


        System.out.println("Bienvenido");

        System.out.print("Ingresa la contraseña:");
        String claveIngresada = scanner.nextLine();

        if(!cliente.validadClave(claveIngresada)) {
            System.out.print("Clave incorrecta");
            return;
        }

        System.out.print("Clave correcta");

        System.out.print("                  ");
        System.out.print("Menu");
        System.out.print("Consultar saldo");
        System.out.print("Depositar");
        System.out.print("Retirar");
        System.out.print("Selecione una opcion:");
        System.out.print("                  ");


        scanner.nextLine();

        System.out.print("                  ");


        System.out.print("");


    }

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Inicializar cuenta con el saldo fijo requerido ($435.000)
        Cuenta cuentaCliente = new Cuenta("123456789", 435000.0, "Ahorros");
        Cliente cliente = new Cliente("1", "Usuario UniBankSalud", "10101010", cuentaCliente, "1234");
        Cajero cajero = new Cajero("CJE-001", "Sede Principal - UniBankSalud");

        System.out.println("=== BIENVENIDO A CAJERO AUTOMÁTICO UNIBANKSALUD ===");
        System.out.print("Ingrese su clave de 4 dígitos: ");
        String claveIngresada = scanner.nextLine();

        if (!cliente.validarClave(claveIngresada)) {
            System.out.println("Clave incorrecta. Acceso denegado.");
            return;
        }

        int opcion = 0;
        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Cambiar clave");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    double saldoActual = cliente.getCuenta().consultarSaldo();
                    System.out.println("Su saldo actual es: $" + saldoActual);
                    break;
                case 2:
                    System.out.print("Ingrese el monto a retirar (Mín: $20.000, Máx: $400.000): ");
                    double monto = Double.parseDouble(scanner.nextLine());

                    if (cajero.validarRetiro(monto, cliente.getCuenta())) {
                        if (cliente.getCuenta().retirar(monto)) {
                            cajero.registrarOperacion();
                            Comprobante comp = new Comprobante("TX-" + System.currentTimeMillis(), "Retiro de Dinero", cajero.getUbicacion(), monto, cliente.getCuenta().consultarSaldo());
                            comp.mostrarDetalle();
                        } else {
                            System.out.println("No se pudo procesar el retiro.");
                        }
                    }
                    break;
                case 3:
                    System.out.print("Ingrese su nueva clave de 4 dígitos: ");
                    String nuevaClave = scanner.nextLine();
                    if (nuevaClave.length() == 4) {
                        cliente.getSeguridad().cambiarClave(nuevaClave);
                        System.out.println("¡Clave cambiada con éxito!");
                    } else {
                        System.out.println("La clave debe tener exactamente 4 dígitos.");
                    }
                    break;
                case 4:
                    System.out.println("Gracias por usar UniBankSalud. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}



}