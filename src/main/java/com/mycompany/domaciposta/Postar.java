/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.domaciposta;

import java.util.ArrayList;

/**
 *
 * @author zivad
 */
public class Postar extends AktivnaOsoba{
    private ArrayList<PostanskoSanduce> sanducici;
    
    
    public Postar(String ime, PostanskoSanduce postanskoSanduce, long najkraceVreme, long najduzeVreme) throws Exception {
        super(ime, postanskoSanduce, najkraceVreme, najduzeVreme);
        sanducici = new ArrayList<>();
        
    }
    
    public void dodajSanduce(PostanskoSanduce sanduce)
    {
        sanducici.add(sanduce);
    }
    
    


    @Override
    public void radi() {
       
        String adresaDostave = postanskoSanduce.posiljke.get(0).getAdresa();
        int brPosiljki = postanskoSanduce.posiljke.size();
        
        
       
        try{
            while(!interrupted()){
               for(PostanskoSanduce sanduce:sanducici){
            
                    if(sanduce.getAdresa().equals(adresaDostave)){
               
                        for(int i = 0; i < brPosiljki; i++){
                        
                            ArrayList<Posiljka> posiljka = postanskoSanduce.izvadiPosiljku(adresaDostave);
                            int count = posiljka.size();
                            for(int j=0; j<count; j++){
                                if(posiljka.get(j)!=null) sanduce.dodajPosiljku(posiljka.get(j));
                            }
                            Thread.sleep(vreme); 
                            
                        }
                    }
                }
            }
        }catch(InterruptedException e){};
           
    }  
}
