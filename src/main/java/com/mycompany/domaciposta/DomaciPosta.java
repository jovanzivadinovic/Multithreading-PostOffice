/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.domaciposta;

/**
 *
 * @author zivad
 */
public class DomaciPosta {

    public static void main(String[] args) {
        try
        {
            PostanskoSanduce postarSanduce = new PostanskoSanduce("AdresaPostar",10);
            postarSanduce.dodajPosiljku(new Posiljka("Adresa1"));
            postarSanduce.dodajPosiljku(new Posiljka("Adresa1"));
            postarSanduce.dodajPosiljku(new Posiljka("Adresa2"));
            postarSanduce.dodajPosiljku(new Posiljka("Adresa1"));
            postarSanduce.dodajPosiljku(new Posiljka("Adresa3"));
            
            
            Postar postar = new Postar("Postar1",postarSanduce,1000,5000);
            
            PostanskoSanduce primalacSanduce = new PostanskoSanduce("Adresa1",2);
            postar.dodajSanduce(primalacSanduce);
            
            Primalac primalac = new Primalac("Primalac1",primalacSanduce,2000,4000);    
            
            
            
            System.out.println("\n"+postar+"\n");
            System.out.println("\n"+primalac+"\n");
            
            Thread.sleep(2000);
            
            postar.interrupt();
            primalac.interrupt();
            
            
        }
        catch(Exception e) {System.out.println(e.getMessage());}
    }
}
