/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.*;
import java.util.*;

/**
 *
 * @author Chlebovics Kornél
 */
public class ReceptKezelo {
    private ReceptTar tar;
    private Recept aktualisRecept;
    private Osszetevok aktualisOsszetevo;
    private String aktualisMennyisegTipus;
    private static Connection kapcsolat;
    private int aktualisOtevoSor;

    public ReceptKezelo() {
        ReceptKliens.inic();
        //kapcsolatTeszt();
        tar= new ReceptTar();
        aktualisRecept = new Recept();
        aktualisOsszetevo = new Osszetevok();
        aktualisMennyisegTipus = "";
    }
   
    
    public ReceptKezelo(ReceptTar tar) {
        this.tar = tar;
    }
    
    public void ujRecept(Recept recept)
    
    {
        tar.receptetHozzaad(recept);
        
    }
    
    
      
    
    
    public ArrayList<String> getNames()
    {
        ArrayList<String> names = new ArrayList<String>();
        for(int i=0; i<tar.getLength();i++)
        {
            names.add(tar.getTar().get(i).getMegnevezes());
        }
        
        return names;
        
    }

    public Recept getAktualisRecept() {
        if (aktualisRecept.getMegnevezes().equals("")) throw new RuntimeException("Nincs recept kiválasztva. Kérem válasszon ki egy receptet a megjelenítéshez!");
        return aktualisRecept;
    }

    
    
    public void setAktualisRecept(ArrayList<String> input) {
        this.aktualisRecept.setMegnevezes(input.get(0));  
        this.aktualisRecept.setLeiras(input.get(1));
    }

    public String getAktualisMennyisegTipus() {
        if (aktualisMennyisegTipus.equals("")) throw new RuntimeException("Összetevő mennyiség típus üres. Kérem adjon meg egy mennyiség típust az összetevőhöz!");
        return aktualisMennyisegTipus;
    }

    public void setAktualisMennyisegTipus(String aktualisMennyisegTipus) {
        this.aktualisMennyisegTipus = aktualisMennyisegTipus;
    }

    public Osszetevok getAktualisOsszetevo() {
        if (aktualisOsszetevo.getOsszetevo_fajta().equals("")) throw new RuntimeException("Nincs összetevő kijelölve. Válasszon ki összetevőt az eltávolításhoz!");
        return aktualisOsszetevo;
    }

    public void setAktualisOsszetevo(ArrayList<String> input) {
        this.aktualisOsszetevo.setMennyiseg_egyseg(input.get(0));
        this.aktualisOsszetevo.setMennyiseg_tipus(input.get(1));
        this.aktualisOsszetevo.setOsszetevo_fajta(input.get(2));
    }

    public int getAktualisOtevoSor() {
        if (aktualisOtevoSor== -1) throw new RuntimeException("Nincs összetevő kijelölve. Válasszon ki összetevőt az eltávolításhoz!");
        return aktualisOtevoSor;
    }

    public void setAktualisOtevoSor(int aktualisOtevoSor) {
        this.aktualisOtevoSor = aktualisOtevoSor;
    }
   
    

    @Override
    public String toString() {
        return "ReceptKezelo{" + "tar=" + tar + '}';
    }
    
}
