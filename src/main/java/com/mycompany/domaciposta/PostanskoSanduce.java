/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.domaciposta;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author zivad
 */
public class PostanskoSanduce {
    private String adresa;
    private int kapacitet;
    protected ArrayList<Posiljka> posiljke;

    public PostanskoSanduce(String adresa, int kapacitet) {
        this.adresa = adresa;
        this.kapacitet = kapacitet;
        posiljke = new ArrayList<>();
    }
    public String getAdresa()
    {
        return this.adresa;
    }
    
    public synchronized void dodajPosiljku(Posiljka p) throws InterruptedException
    {
        if(posiljke.size() >= kapacitet) wait(); 
        
            this.posiljke.add(p);
            System.out.println("Dodata posiljka " + p +" u sanduce " + adresa);
            notify();

    }
    
    
    public synchronized void izvadiPrvuPosiljku() throws InterruptedException
    {
        Posiljka prvaPosiljka = null;
        if(posiljke.size()==0) wait();
        
            prvaPosiljka = posiljke.remove(0);
            System.out.println("Primalac preuzeo posiljku " + prvaPosiljka);
            notify();
    
    }
    
    
    public synchronized ArrayList<Posiljka> izvadiPosiljku(String adresa) throws InterruptedException
    {
        
        
        if(posiljke.isEmpty()) wait();


        ArrayList<Posiljka> trazenaPosiljka = new ArrayList<>();
        Iterator<Posiljka> iterator = posiljke.iterator();
        while (iterator.hasNext()) {
            Posiljka posiljka = iterator.next();
            if (posiljka.getAdresa().equals(adresa)) {
                iterator.remove();
                System.out.println("Postar vadi posiljku " + posiljka);
                trazenaPosiljka.add(posiljka);
                
                notify();
            }
                
        }
        return trazenaPosiljka;
        
    }

    @Override
    public String toString() {
        StringBuilder opis = new StringBuilder();
        for (int i = 0; i < posiljke.size(); i++) {
            opis.append(posiljke.get(i).toString()).append("\n");
        }
        return opis.toString();
    }  
    
}
