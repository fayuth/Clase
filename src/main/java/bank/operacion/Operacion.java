package bank.operacion;

public class Operacion {

    String TipoDeOperacion;

    int Amount;

    String Date;


    public Operacion(String TipoDeOperacion, int Amount, String Date) {

    }

    public void setTipoDeOperacion(String tipoDeOperacion) {
        TipoDeOperacion = tipoDeOperacion;
    }

    public void setDate(String date) {
        Date = date;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }
}
