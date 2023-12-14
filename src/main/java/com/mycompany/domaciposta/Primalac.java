/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.domaciposta;

/**
 *
 * @author zivad
 */
public class Primalac extends AktivnaOsoba{
    public Primalac(String ime, PostanskoSanduce postanskoSanduce, long najkraceVreme, long najduzeVreme) throws Exception {
        super(ime, postanskoSanduce, najkraceVreme, najduzeVreme);
        
    }
    
    @Override
    public void radi() {
        Posiljka posiljka;
        try{
            while(!interrupted()){
                while(!postanskoSanduce.posiljke.isEmpty()){
                postanskoSanduce.izvadiPrvuPosiljku();
                Thread.sleep(this.vreme);
                } 
            }
            
        }catch(InterruptedException e){}
    } 
    
}
