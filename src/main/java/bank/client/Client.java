package bank.client;

import bank.cuenta.Account;
import bank.utils.Seguridad;

public class Client {

    private String Id;

    private String  Name;

    private String  DocumentNumber;

    private final Account Account;

    private Seguridad seguridad;






    public Client(String Id, String name, String DocumentNumber, Account Account, String ClaveInicial) {
        this.Id = Id;
        this.Name = name;
        this.DocumentNumber = DocumentNumber;
        this.Account = Account;
        this.seguridad = new Seguridad(ClaveInicial);
    }


    public boolean validadClave(String clave) {
        return seguridad.validadClave(clave);
    }

    public Account getAccount() {
        return Account;
    }

    public Seguridad getSeguridad() {
        return seguridad;
    }
}
