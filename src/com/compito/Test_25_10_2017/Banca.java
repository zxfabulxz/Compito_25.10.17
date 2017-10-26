package com.compito.Test_25_10_2017;

/**
 *
 * @author Marco
 */

import java.io.*;

public class Banca 
{
    public static void main(String argv[])
    {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);
        
        Integer conto=0,operazione;
        Float denaro;
        
        try 
        {
            do{
            System.out.print("Digita il num. del conto corrente: ");
            conto=Integer.valueOf(tastiera.readLine());
            }while(conto<0||conto>99999999); //il vincolo tbh fa schifo f.b.m. 
        } catch (IOException | NumberFormatException e) 
        {
            System.err.println("Conto errato.");
            System.exit(1);
        }
        
        Cliente cliente1 = new Cliente(conto);
        
        try 
        {
        do{
            do{
            System.out.println("Digita 1:Preleva 2:Deposita 3:Exit");
            operazione=Integer.valueOf(tastiera.readLine());
            }while(operazione!=1&&operazione!=2&&operazione!=3);
            if(operazione==1)
            {
               do{
                    System.out.println("Preleva: (MAX="+(cliente1.getSaldo())+")");
                    denaro=Float.valueOf(tastiera.readLine());
                    }while(denaro>cliente1.getSaldo());
                    cliente1.preleva(denaro);
                    if(denaro!=0.0&&denaro!=0)
                    {
                        System.out.print("Inserisci Data: ");
                        cliente1.setData(tastiera.readLine()); //vincoli da aggiornare 
                        cliente1.setMovimento("Prelievo: " + denaro + "€");
                        System.out.println("Prelievo eseguito con successo.");
                    }
                    
            }
            else
            {
                if(operazione==2)
                {
                    do{
                    System.out.println("Deposita: (MAX="+(9999.99-cliente1.getSaldo())+")");
                    denaro=Float.valueOf(tastiera.readLine());
                    }while(cliente1.getSaldo()+denaro>9999.99);
                    cliente1.versa(denaro);
                    if(denaro!=0.0&&denaro!=0)
                    {
                        System.out.print("Inserisci Data: ");
                        cliente1.setData(tastiera.readLine()); //vincoli da aggiornare 
                        cliente1.setMovimento("Deposito: " + denaro + "€");
                        System.out.println("Versamento eseguito con successo.");
                        
                    }
                    
                }
            }
        }while(operazione!=3);
        
        } catch (IOException | NumberFormatException e) 
        {}
        
        
        //CONTO BANCARIO N. 2
        
        
        try 
        {
            do{
            System.out.print("Digita il num. del conto corrente: ");
            conto=Integer.valueOf(tastiera.readLine());
            }while(conto<0||conto>99999999); //il vincolo tbh fa schifo f.b.m. 
        } catch (IOException | NumberFormatException e) 
        {
            System.err.println("Conto errato.");
            System.exit(1);
        }
        
        Cliente cliente2 = new Cliente(conto);
        
        try 
        {
        do{
            do{
            System.out.println("Digita 1:Preleva 2:Deposita 3:Exit");
            operazione=Integer.valueOf(tastiera.readLine());
            }while(operazione!=1&&operazione!=2&&operazione!=3);
            if(operazione==1)
            {
               do{
                    System.out.println("Preleva: (MAX="+(cliente2.getSaldo())+")");
                    denaro=Float.valueOf(tastiera.readLine());
                    }while(denaro>cliente2.getSaldo());
                    cliente2.preleva(denaro);
                    if(denaro!=0.0&&denaro!=0)
                    {
                        System.out.print("Inserisci Data: ");
                        cliente2.setData(tastiera.readLine()); //vincoli da aggiornare 
                        cliente2.setMovimento("Prelievo: " + denaro + "€");
                        System.out.println("Prelievo eseguito con successo.");
                    }
                    
            }
            else
            {
                if(operazione==2)
                {
                    do{
                    System.out.println("Deposita: (MAX="+(9999.99-cliente2.getSaldo())+")");
                    denaro=Float.valueOf(tastiera.readLine());
                    }while(cliente2.getSaldo()+denaro>9999.99);
                    cliente2.versa(denaro);
                    if(denaro!=0.0&&denaro!=0)
                    {
                        System.out.print("Inserisci Data: ");
                        cliente2.setData(tastiera.readLine()); //vincoli da aggiornare 
                        cliente2.setMovimento("Deposito: " + denaro + "€");
                        System.out.println("Versamento eseguito con successo.");
                        
                    }
                    
                }
            }
        }while(operazione!=3);
        
        } catch (IOException | NumberFormatException e) 
        {}
        
        
        
        //STAMPA ULTIMO MOVIMENTO I SALDI E CONFRONTARE I SALDI E VEDERE IL PIU' RICCO
        System.out.println("CONTO: " +cliente1.getNumConto());
        System.out.println("Ultimo movimento: " + cliente1.getMovimento()+" data: "+cliente1.getData());
        System.out.println("Saldo: "+cliente1.getSaldo());
        
        System.out.println("CONTO: " +cliente2.getNumConto());
        System.out.println("Ultimo movimento: " + cliente2.getMovimento()+" data: "+cliente2.getData());
        System.out.println("Saldo: "+cliente2.getSaldo());
        
        if(cliente1.getSaldo()>cliente2.getSaldo())
        {
            System.out.println("Il CONTO '"+cliente1.getNumConto()+"' ha il saldo più grande.");
        }
        else
        {
            System.out.println("Il CONTO '"+cliente2.getNumConto()+"' ha il saldo più grande.");
        }
    }
}
