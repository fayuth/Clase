package bank.cajero;


import bank.cuenta.Account;

public class Cajero {

    private String IdCajero;

    private final String Ubicacion;

    private int RetirosHoy;


    public  Cajero(String IdCajero, String Ubicacion){

        this.IdCajero = IdCajero;

        this.Ubicacion = Ubicacion;

        this.RetirosHoy = 0;
    }


    public boolean validarRetiro(double monto, Account cuenta) {

        if(monto < 20000 || monto > 400000) {

            return false;
        }

        if(cuenta.getAccountType().equalsIgnoreCase("Ahorros") && RetirosHoy >= 3) {
            return false;
        }

        if(monto > cuenta.getBalance()){
            return  false;
        }
        return true;
    }

    public void setRetirosHoy(int retirosHoy) {
        RetirosHoy = retirosHoy++;
    }

    public String getUbicacion() {
        return Ubicacion;
    }
}
