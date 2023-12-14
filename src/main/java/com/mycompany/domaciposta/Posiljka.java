/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.domaciposta;

/**
 *
 * @author zivad
 */
public class Posiljka implements Cloneable{
    private static int ID = 0;
    private int id;
    protected String adresa;

    public Posiljka(String adresa) 
    {
        id = ++ID;
        this.adresa = adresa;
    }

    public String getAdresa() {
        return adresa;
    }

    @Override
    protected Posiljka clone() throws CloneNotSupportedException {
        Posiljka p = (Posiljka)super.clone();
        p.id = ++ID;
        return p;
    }

    @Override
    public String toString() {
        return id + "[" + adresa + "]";
    }
    
}
