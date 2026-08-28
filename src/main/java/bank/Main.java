package bank;


import bank.Comprobante.Comprobante;
import bank.cajero.Cajero;
import bank.client.Client;
import bank.cuenta.Account;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Account cuenta = new Account("1234567", (int) 430000.0, "Ahorros");

        Client cliente = new Client("1", "Fayuth Rojas", "1067596127",  cuenta, "1234");

        Cajero cajero = new Cajero("ASD", "Barraqulla");


        System.out.println("Bienvenido");

        System.out.print("Ingresa la contraseña:");
        String claveIngresada = scanner.nextLine();

        if(!cliente.validadClave(claveIngresada)) {
            System.out.print("Clave incorrecta");
            return;
        }


        int opcion = 0;
        do {
            System.out.println("\n                ");

            System.out.println("\n Menu");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Cambiar clave");
            System.out.println("5. Salir");
            System.out.println("\n                ");
            System.out.println("0. Pon 0 para cancelar");
            System.out.println("\n                ");
            System.out.print("Seleccione una opción: ");
            System.out.println("\n                ");
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
                continue;
            }

            switch (opcion) {
                case 0:
                    System.exit(1);

                case 1:
                    double saldoActual = cliente.getAccount().getBalance();
                    System.out.println("Su saldo actual es: $" + saldoActual);
                    break;


                case 2:
                    System.out.print("Ingrese el monto a depositar (Mín: $20.000, Máx: $400.000): ");
                    double montodeposit = Double.parseDouble(scanner.nextLine());

                    Comprobante comp2 = new Comprobante("TX-" + System.currentTimeMillis(), "Deposito de Dinero", cajero.getUbicacion(), montodeposit, cliente.getAccount().getBalance());
                    comp2.monstrarDetalles();

                    cliente.getAccount().deposit(montodeposit);

                    break;
                case 3:
                    System.out.print("Ingrese el monto a retirar (Mín: $20.000, Máx: $400.000): ");
                    double monto = Double.parseDouble(scanner.nextLine());

                    if (cajero.validarRetiro(monto, cliente.getAccount())) {
                        if (cliente.getAccount().retira(monto)) {
                            cajero.setRetirosHoy(1);
                            Comprobante comp = new Comprobante("TX-" + System.currentTimeMillis(), "Retiro de Dinero", cajero.getUbicacion(), monto, cliente.getAccount().getBalance());
                            comp.monstrarDetalles();
                        } else {
                            System.out.println("No se pudo procesar el retiro.");
                        }
                    }
                    break;
                case 4:
                    System.out.print("Ingrese su nueva clave de 4 dígitos: ");
                    String nuevaClave = scanner.nextLine();
                    if (nuevaClave.length() == 4) {
                        cliente.getSeguridad().cambiarClave(nuevaClave);
                        System.out.println("¡Clave cambiada con éxito!");
                    } else {
                        System.out.println("La clave debe tener exactamente 4 dígitos.");
                    }
                    break;
                case 5:
                    System.out.println("bye");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);

        scanner.close();
    }



}