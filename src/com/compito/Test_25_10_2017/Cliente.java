package com.compito.Test_25_10_2017;
/**
 *
 * @author Marco alias Fabul
 */
import java.text.DecimalFormat;
public class Cliente 
{
    private String numConto;
    private double saldo;
    private String dataMovimento;
    private double importoMovimento;
    private double fido;
    
    DecimalFormat dfsaldo= new DecimalFormat("0000.00");
    
    public Cliente(String numConto)
    {
        this.numConto = numConto;
    }
    public void versa(String dataMovimento,double importoMovimento)
    {
        this.importoMovimento=importoMovimento;
        this.dataMovimento=dataMovimento;
        saldo+=importoMovimento;
    }
    public void preleva(String dataMovimento,double importoMovimento)
    {
        this.importoMovimento=-1*importoMovimento;
        this.dataMovimento=dataMovimento;
        saldo-=importoMovimento;
    }
    public void stampaUltimoMovimento()
    {
        System.out.println("CONTO: " + numConto);
        System.out.println("Ultimo movimento: "+importoMovimento+"€" + " data: "+ dataMovimento);
    }
    public void stampaSaldo()
    {
        System.out.println("Saldo: "+dfsaldo.format(saldo)+"€");
    }
    public double getSaldo()
    {
        return saldo;
    }
    public double getFido()
    {
        return fido;
    }
    public void setFido(double fido)
    {
        this.fido=fido;
    }
    public String getNumConto()
    {
        return numConto;
    }
}
