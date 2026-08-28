package bank.utils;

public class Seguridad {

    private String Clave;

    public Seguridad (String ClaveInicial){
        this.Clave = ClaveInicial;
    }

    public boolean validadClave(String ClaveInicial) {
        return this.Clave.equals(ClaveInicial);
    }

    public void cambiarClave(String clave) {
        Clave = clave;
    }
}
