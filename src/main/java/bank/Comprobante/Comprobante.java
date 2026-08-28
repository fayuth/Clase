package bank.Comprobante;

import java.time.LocalDateTime;

public class Comprobante {

    private String IdTx;

    private String TipoDeOperacion;

    private LocalDateTime Date;

    private String Sucursal;

    private double ValorRetiro;

    private double  Saldo;


    public Comprobante(String IdTx, String TipoDeOperacion, String Date, String Sucursal, double ValorRetiro, double Saldo) {
        this.IdTx = IdTx;
        this.TipoDeOperacion = TipoDeOperacion;
        this.Date = LocalDateTime.now();
        this.Sucursal = Sucursal;
        this.ValorRetiro = ValorRetiro;
        this.Saldo = Saldo;
    }

    public void monstrarDetalles(){
        System.out.print("---------------------");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("---------------------");
    }
}
