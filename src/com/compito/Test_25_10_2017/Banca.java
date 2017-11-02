package com.compito.Test_25_10_2017;
/**
 *
 * @author Marco
 */
import java.io.*;
import java.text.DecimalFormat;
public class Banca 
{
    public void main(String argv[])
    {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);
        DecimalFormat dfsaldo= new DecimalFormat("0000.00");
        
        String conto = null;
        String data;
        int operazione;
        double denaro=0;
        double fido;
        double max=0;
        boolean debito=false;
        try //Quà digitiamo il numero (string) del codice corrente
        {
            do{
            System.out.print("Digita il num. del conto corrente: ");
            conto=tastiera.readLine();
            }while(conto.length()<8);
        } catch (IOException | NumberFormatException e) 
        {
            System.err.println("Conto errato.");
            System.err.println(e);
            System.exit(1);
        }
        Cliente cliente1 = new Cliente(conto);
        try 
        {
        do{
            do{ // qua scegliamo che operazione fare
            System.out.println("Digita 1:Preleva 2:Deposita 3:setFido 4:Exit");
            operazione=Integer.valueOf(tastiera.readLine());
            }while(operazione!=1&&operazione!=2&&operazione!=3&&operazione!=4);
            if(operazione==1) //PRELIEVO
            {
               do{ 
                    
                    if(cliente1.getSaldo()<0 && cliente1.getSaldo()==-cliente1.getFido())   //devo fare il controllo // saldo==-fido , significa che se non è uguale 
                    {                                                                       //(esempio -100 == (-)100) il fido è cambiato e quindi posso prelevare la differenza di fido insomma
                        System.out.println("Il tuo conto è in debito di "+cliente1.getSaldo()+"");
                        System.out.println("Non è pssibile prelevare.");
                        debito=true;
                    }
                    else 
                    {
                        debito=false;
                        max=cliente1.getSaldo()+cliente1.getFido(); // utilizzo variabiel comodo max altrimenti il risultato non è corretto.
                        System.out.println("Preleva: (MAX="+dfsaldo.format(max)+")");
                        denaro=Double.valueOf(tastiera.readLine());
                    }
                }while(denaro>max && debito==false); // 1 or 0 = 1 // 1 and 0 = 0 // debito==false perchè se il debito==true esce dal while
                    if(denaro!=0.0&&denaro!=0&&debito==false) // 0.0/0 per uscire //getsaldo>0 perchè non vorrei mai settare la data se sto' prelevando 0 euro :F
                    {
                        System.out.print("Inserisci Data: ");
                        data=tastiera.readLine();
                        cliente1.preleva(data,denaro); //passo pure la data per settare la dataMovimento,il denaro per impostare il saldo e settare importoMovimento
                        System.out.println("Prelievo eseguito con successo.");
                    }
            }
            else
            {
                if(operazione==2)
                {
                    do{
                    System.out.println("Deposita: (MAX="+dfsaldo.format(9999.99-cliente1.getSaldo())+")"); //il saldo deve essere max 9999,99 quindi metto questo vincolo
                    denaro=Double.valueOf(tastiera.readLine());
                    }while(cliente1.getSaldo()+denaro>9999.99); // es 10000.00 - non lo deposita
                    if(denaro!=0.0&&denaro!=0)
                    {
                        System.out.print("Inserisci Data: ");
                        data=tastiera.readLine();
                        cliente1.versa(data,denaro);
                        System.out.println("Versamento eseguito con successo.");   
                    }
                }
                else
                {
                    if(operazione==3)
                    {
                        do{
                        System.out.println("Inserire soglia di fido");
                        fido=Double.valueOf(tastiera.readLine());
                        }while(fido<0);
                        cliente1.setFido(fido);
                    }
                }
            }
        }while(operazione!=4);
        
        } catch (IOException | NumberFormatException e) 
        {
            System.err.println("ERRORE: Qualcosa è andato storto.");
            System.err.println(e);
            System.exit(-1);
        }
        
        
        //CONTO BANCARIO N. 2
        
        
        try 
        {
            do{
            System.out.print("Digita il num. del conto corrente: ");
            conto=tastiera.readLine();
            }while(conto.length()<8); //il vincolo tbh fa schifo f.b.m. 
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
            System.out.println("Digita 1:Preleva 2:Deposita 3:setFido 4:Exit");
            operazione=Integer.valueOf(tastiera.readLine());
            }while(operazione!=1&&operazione!=2&&operazione!=3&&operazione!=4);
            if(operazione==1)
            {
               do{  
                    
                    if(cliente1.getSaldo()<0 && cliente1.getSaldo()==-cliente1.getFido())   //devo fare il controllo // saldo==-fido , significa che se non è uguale 
                    {                                                                       //(esempio -100 == (-)100) il fido è cambiato e quindi posso prelevare la differenza di fido insomma
                        System.out.println("Il tuo conto è in debito di "+cliente2.getSaldo()+"");
                        System.out.println("Non è pssibile prelevare.");
                        debito=true;
                    }
                    else
                    {
                        debito=false;
                        max=cliente2.getSaldo()+cliente2.getFido();
                        System.out.println("Preleva: (MAX="+dfsaldo.format(max)+")");
                        denaro=Double.valueOf(tastiera.readLine());
                    }
                }while(denaro>max && debito==false); // 1 or 0 = 1
                if(denaro!=0.0&&denaro!=0&&debito==false)
                {
                    System.out.print("Inserisci Data: ");
                    data=tastiera.readLine();
                    cliente2.preleva(data,denaro);
                    System.out.println("Prelievo eseguito con successo.");
                }
            }
            else
            {
                if(operazione==2)
                {
                    do{
                    System.out.println("Deposita: (MAX="+dfsaldo.format(9999.99-cliente2.getSaldo())+")");
                    denaro=Double.valueOf(tastiera.readLine());
                    }while(cliente2.getSaldo()+denaro>9999.99);
                    if(denaro!=0.0&&denaro!=0)
                    {
                        System.out.print("Inserisci Data: ");
                        data=tastiera.readLine();
                        cliente2.versa(data,denaro);
                        System.out.println("Versamento eseguito con successo.");   
                    }
                }
                else
                {
                    if(operazione==3)
                    {
                        do{
                        System.out.println("Inserire soglia di fido");
                        fido=Double.valueOf(tastiera.readLine());
                        }while(fido<0);
                        cliente2.setFido(fido);
                    }
                }
            }
        }while(operazione!=4);
        
        } catch (IOException | NumberFormatException e) 
        {
            System.err.println("ERRORE: Qualcosa è andato storto.");
            System.exit(-1);
        }
        
        cliente1.stampaSaldo();
        cliente1.stampaUltimoMovimento();
        cliente2.stampaSaldo();
        cliente2.stampaUltimoMovimento();
        
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
