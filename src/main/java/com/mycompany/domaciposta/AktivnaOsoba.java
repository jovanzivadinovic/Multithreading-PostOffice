/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.domaciposta;

/**
 *
 * @author zivad
 */
public abstract class AktivnaOsoba extends Thread{
    protected String ime;
    protected PostanskoSanduce postanskoSanduce;
    protected long vreme;
    protected long najkraceVreme;
    protected long najduzeVreme;
    
    @Override
    public String toString() {
        return ime + "\n" + postanskoSanduce.getAdresa();
    }

    public AktivnaOsoba(String ime, PostanskoSanduce postanskoSanduce, long najkraceVreme, long najduzeVreme) throws Exception {
        if(najkraceVreme>=najduzeVreme)
        {
            throw new Exception("Najkrace vreme je vece od najduzeg vremena");
        }
        this.ime = ime;
        this.postanskoSanduce = postanskoSanduce;
        this.najkraceVreme = najkraceVreme;
        this.najduzeVreme = najduzeVreme;
        this.vreme = (long) (najkraceVreme + Math.random()*(najduzeVreme - najkraceVreme));
        start();
        
    }
    
    @Override
    public void run(){
        try {
            while(!interrupted()){
                radi();
                sleep(vreme);
            }
        } catch (InterruptedException e) {}
    }
    public abstract void radi() throws InterruptedException;
    
}
