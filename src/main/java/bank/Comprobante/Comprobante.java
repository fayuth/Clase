package bank.Comprobante;

import java.time.LocalDateTime;

public class Comprobante {

    private String IdTx;

    private String TipoDeOperacion;

    private LocalDateTime Date;

    private double ValorRetiro;

    private double  Saldo;


    public Comprobante(String IdTx, String TipoDeOperacion, String Date, double ValorRetiro, double Saldo) {
        this.IdTx = IdTx;
        this.TipoDeOperacion = TipoDeOperacion;
        this.Date = LocalDateTime.now();
        this.ValorRetiro = ValorRetiro;
        this.Saldo = Saldo;
    }

    public void monstrarDetalles(){
        System.out.print("---------------------");
        System.out.print("id" + this.IdTx);
        System.out.print("Tipo de Operacion" + this.TipoDeOperacion);
        System.out.print("Date" + this.Date);
        System.out.print("ValorRetiro" + this.ValorRetiro);
        System.out.print("Saldo" + this.Saldo);
        System.out.print("---------------------");
    }
}
