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

}