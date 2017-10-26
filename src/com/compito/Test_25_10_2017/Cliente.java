/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compito.Test_25_10_2017;

/**
 *
 * @author Marco alias Fabul
 */
public class Cliente 
{
    private int numConto;
    private float saldo;
    private String data;
    private String movimento;
    
    public Cliente(int numConto)
    {
        this.numConto = numConto;
    }

    public int getNumConto() {
        return numConto;
    }
    public float getSaldo()
    {
        return saldo;
    }
    public void versa(float denaro)
    {
        saldo+=denaro;
    }
    public void preleva(float denaro)
    {
        saldo-=denaro;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
    
    public void setMovimento(String movimento) {
        this.movimento = movimento;
    }
    public String getMovimento()
    {
       return movimento; 
    }
    
}
