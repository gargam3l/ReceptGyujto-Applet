/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import model.*;
import model.ReceptKezelo;
import view.*;

/**
 *
 * @author 604772006
 */
public class Controller {
    private ReceptKezelo rKezelo;
    private GUI gui;

    public GUI getGui() {
        return gui;
    }

    public void setGui(GUI gui) {
        this.gui = gui;
    }
    
    
    public Controller() {
        
        //gui = new GUI(this);
        rKezelo = new ReceptKezelo();
        
        
        
    }
    
    public Controller(GUI input) {
        
        gui = input;
        rKezelo = new ReceptKezelo();
        
        
        
    }
    
    public void Run()
    {
        
        
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                gui.displayGUI();
            }
        });
       
    }

    
    
    public ActionListener getVisszaGombListener()
    {
        return new ActionListener() {
             @Override public void actionPerformed (ActionEvent e) {
                 
                 CardLayout cardLayout = (CardLayout) gui.getCardLayout();
                cardLayout.show(gui.getContentPane(), "card1");
                 //rKezelo.setAktualisMennyisegTipus("");
                 //rKezelo.getAktualisRecept().setMegnevezes("");
             }
         };
    }
    
    public ActionListener getUjReceptPanelListener()
    {
        return new ActionListener() {
             @Override public void actionPerformed (ActionEvent e) {
                 gui.getNewRPanel().setInitialized(false);
                 CardLayout cardLayout = (CardLayout) gui.getCardLayout();
                cardLayout.show(gui.getContentPane(), "card2");
                gui.getNewRPanel().inicNewRecipePanelDefault();
                
                
                //összetevő mennyiség típusok betöltése
                gui.getNewRPanel().setOtevoList(ReceptKliens.otevoMennyTipusok());
                
                rKezelo.setAktualisMennyisegTipus("");
                rKezelo.setAktualisOtevoSor(-1);
                
                
             }
         };
    }
    
    public ActionListener getReceptKeresPanelListener()
    {
        return new ActionListener() {
             @Override public void actionPerformed (ActionEvent e) {
                 gui.getSrchRPanel().setInitialized(false);
                 CardLayout cardLayout = (CardLayout) gui.getCardLayout();
                cardLayout.show(gui.getContentPane(), "card4");
                 gui.getSrchRPanel().inicSearchRecipePanelDefault(); 
                 
             }
         };
    }
    
    public ActionListener getReceptMutatPanelListener()
    {
        return new ActionListener() {
             @Override public void actionPerformed (ActionEvent e) {
                 try{
                     String aktReceptNeve=rKezelo.getAktualisRecept().getMegnevezes();
                 gui.getShRPanel().setInitialized(false);
                 CardLayout cardLayout = (CardLayout) gui.getCardLayout();
                cardLayout.show(gui.getContentPane(), "card3");
                    gui.getShRPanel().inicShowRecipePanelDefault();
                    //összetevő mennyiség típusok betöltése
                    gui.getShRPanel().setOtevokList(ReceptKliens.otevoMennyTipusok());
                    
                    //Kiválasztott recepthez összetevők betöltésa
                    rKezelo.getAktualisRecept().setOsszetevok(ReceptKliens.keresOsszetevoRecepthez(rKezelo.getAktualisRecept().getMegnevezes()));
                    //Recept név betöltése guiba
                    gui.getShRPanel().setReceptNeve(aktReceptNeve);
                    //Összetevők töltése guiba
                    gui.getShRPanel().setOsszetevokTable(rKezelo.getAktualisRecept().getOsszetevokTablaban());
                    //Recept leírás betöltése guiba
                    gui.getShRPanel().setLeiras(rKezelo.getAktualisRecept().getLeiras());
                    gui.getShRPanel().otevoOszlopotBeallit(gui.getShRPanel().getOsszetevokTable(), ReceptKliens.otevoMennyTipusok());
                    
                    rKezelo.setAktualisOtevoSor(-1);
                    } catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(gui, ex.getMessage(), "Hiba", JOptionPane.ERROR_MESSAGE);

                }
                    
             }
         };
    }
    
    public ActionListener getMentesGombListener()
    {
        return new ActionListener() {
             @Override public void actionPerformed (ActionEvent e) {
    
                
                //Recept létrehozása a gui-ból vett adatokkal - megnevezés leírás
                 
                try
                {
                    
                    
                    gui.getNewRPanel().getReceptNeve();
                    
                Recept ujRecept = new Recept(gui.getNewRPanel().getReceptNeve(), gui.getNewRPanel().getReceptLeiras());
                //System.out.println(gui.getNewRPanel().getReceptNeve()+" "+ gui.getNewRPanel().getReceptLeiras());
                //Összetevők hozzáadása recepthez - ciklusba kell tenni, miután gui-ban az összetevők tábla implementálva lesz
                for (int i=0;i<gui.getNewRPanel().getOtevoTablaSorokSzama();i++)
                    {
                        Osszetevok otevo=new Osszetevok();
                        otevo.setMennyiseg_egyseg(gui.getNewRPanel().getOtevoTablaAdatCella(i, 0));
                        //System.out.println(gui.getNewRPanel().getOtevoTablaAdatCella(i, 0));                           ;
                        otevo.setMennyiseg_tipus(gui.getNewRPanel().getOtevoTablaAdatCella(i, 1));
             
                        otevo.setOsszetevo_fajta(gui.getNewRPanel().getOtevoTablaAdatCella(i, 2));

                        ujRecept.osszetevotHozzaad(otevo);
                    }
                
                //Recept mentése az adatbázisba
                
                ReceptKliens.receptetMent(ujRecept);
                 
                            
                } catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(gui, ex.getMessage(), "Hiba", JOptionPane.ERROR_MESSAGE);

                }
                 
                }
         };
    }
    
    public ActionListener getReceptTorlesListener()
    {
        return new ActionListener() {
             @Override public void actionPerformed (ActionEvent e) {
                 
                 try{
                 Recept receptGui = new Recept(gui.getShRPanel().getReceptNeve(), gui.getShRPanel().getLeiras());
                 for (int i=0; i<gui.getShRPanel().getOtevoTablaSorokSzama(); i++)
                 {
                     Osszetevok otevo=new Osszetevok();
                     otevo.setMennyiseg_egyseg(gui.getShRPanel().getOtevoTablaAdatCella(i, 0));
                     otevo.setMennyiseg_tipus(gui.getShRPanel().getOtevoTablaAdatCella(i, 1));
                     otevo.setOsszetevo_fajta(gui.getShRPanel().getOtevoTablaAdatCella(i, 2));
                     receptGui.osszetevotHozzaad(otevo);
                 }
                 if (receptGui.equals(rKezelo.getAktualisRecept()))  ReceptKliens.receptetTorol(rKezelo.getAktualisRecept().getMegnevezes());
                 gui.getSrchRPanel().setInitialized(false);
                 //CardLayout cardLayout = (CardLayout) gui.getCards().getLayout();
                 //   cardLayout.show(gui.getCards(), "card4");
                 gui.getSrchRPanel().inicSearchRecipePanelDefault(); 
                 }
                  catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(gui, ex.getMessage(), "Hiba", JOptionPane.ERROR_MESSAGE);

                }
            }
                 
         };
    }
    
    public ActionListener getReceptSzerkesztListener()
    {
        return new ActionListener() {
             @Override public void actionPerformed (ActionEvent e) {
                 
                 try{
                 gui.getShRPanel().getOsszetevokTable().doLayout();
                 Recept ujRecept = new Recept();
                 ujRecept.setMegnevezes(gui.getShRPanel().getReceptNeve());
                 ujRecept.setLeiras(gui.getShRPanel().getLeiras());
                 
                 for (int i=0; i<gui.getShRPanel().getOtevoTablaSorokSzama(); i++)
                 {
                     Osszetevok otevo=new Osszetevok();
                     otevo.setMennyiseg_egyseg(gui.getShRPanel().getOtevoTablaAdatCella(i, 0));
                     otevo.setMennyiseg_tipus(gui.getShRPanel().getOtevoTablaAdatCella(i, 1));
                     otevo.setOsszetevo_fajta(gui.getShRPanel().getOtevoTablaAdatCella(i, 2));
                     ujRecept.osszetevotHozzaad(otevo);
                 }
                 
                    ReceptKliens.receptetSzerkeszt(rKezelo.getAktualisRecept().getMegnevezes(), ujRecept);
                    
                    } catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(gui, ex.getMessage(), "Hiba", JOptionPane.ERROR_MESSAGE);

                }
             }
         };
    }
    
    public ActionListener getUjReceptOsszetevotHozzaadListener()
    {
        return new ActionListener() {
             @Override public void actionPerformed (ActionEvent e) {
                 try {
                 gui.getNewRPanel().addRowToOtevoTabla(new Object[]{gui.getNewRPanel().getOtevoMennyiseg(),rKezelo.getAktualisMennyisegTipus(),gui.getNewRPanel().getOtevoMegnevezes()});
                 if (gui.getNewRPanel().getOtevoTablaAdat().getRowCount()==1) gui.getNewRPanel().otevoOszlopotBeallit(gui.getNewRPanel().getOtevoTabla(), ReceptKliens.otevoMennyTipusok());
                 } catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(gui, ex.getMessage(), "Hiba", JOptionPane.ERROR_MESSAGE);

                }
             }
         };
    }
    
    public ActionListener getReceptMutatOsszetevotHozzaadListener()
    {
        return new ActionListener() {
             @Override public void actionPerformed (ActionEvent e) {
                 try{
                 gui.getShRPanel().addRowToOtevoTabla(new Object[]{gui.getShRPanel().getOtevoMenny(),rKezelo.getAktualisMennyisegTipus(),gui.getShRPanel().getOtevoLeiras()});
                    } catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(gui, ex.getMessage(), "Hiba", JOptionPane.ERROR_MESSAGE);

                }
             }
         };
    }
    
    public ActionListener getReceptKeresListener()
    {
        return new ActionListener() {
             @Override public void actionPerformed (ActionEvent e) {
                 try{
                 
                 String kulcs=gui.getSrchRPanel().getReceptNeve();
            ReceptTar tar=ReceptKliens.keresMegnevezesre(kulcs);
            
            gui.getSrchRPanel().setTalalatTabla(tar.getReceptTablaFoAdatok());
             }
              catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(gui, ex.getMessage(), "Hiba", JOptionPane.ERROR_MESSAGE);

                }
             }
         };
    }
    
    public ListSelectionListener getReceptMutatTablaSorListener()
    {
        return new ListSelectionListener() {
             

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting() && gui.getShRPanel().isInitialized()) {
                    
                    rKezelo.setAktualisOtevoSor(gui.getShRPanel().getOtevoTableAktualisSor());
                    //rKezelo.setAktualisOsszetevo(gui.getShRPanel().getOtevoTableAktualisSor());
                }
            }
         };
    }
    
    public ListSelectionListener getUjReceptTablaSorListener()
    {
        return new ListSelectionListener() {
             

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting() && gui.getNewRPanel().isInitialized()) {
                    
                    rKezelo.setAktualisOtevoSor(gui.getNewRPanel().getOtevoTableAktualisSor());
                }
            }
         };
    }
    
    public ListSelectionListener getReceptTablaSorListener()
    {
        return new ListSelectionListener() {
             

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting() && gui.getSrchRPanel().isInitialized()) {
                    
                
                rKezelo.setAktualisRecept(gui.getSrchRPanel().getTalalatTableAktualisSor());
                
                }
            }
         };
    }
    
    
    public ListSelectionListener getUjReceptListaElemListener()
    {
        return new ListSelectionListener() {
             

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()&& gui.getNewRPanel().isInitialized()) {
                    
                    rKezelo.setAktualisMennyisegTipus(gui.getNewRPanel().getOtevoListCurrentSelection());
                
                }
            }
         };
    }
    
    public ListSelectionListener getReceptMutatListaElemListener()
    {
        return new ListSelectionListener() {
             

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()&& gui.getShRPanel().isInitialized()) {
                    
                    rKezelo.setAktualisMennyisegTipus(gui.getShRPanel().getOtevoListCurrentSelection());
                
                }
            }
         };
    }

    public ActionListener getKilepes() {
        return new ActionListener() {
             @Override public void actionPerformed (ActionEvent e) {
                 gui.getFrame().dispose();
             }
        };  
    }

    public ActionListener getReceptMutatOsszetevotEltavolitListener() {
        return new ActionListener() {
             @Override public void actionPerformed (ActionEvent e) {
                 //gui.getFrame().dispose();
                 try{
                     
                 
                 gui.getShRPanel().removeRowToOtevoTabla(rKezelo.getAktualisOtevoSor());
                 }
                 catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(gui, ex.getMessage(), "Hiba", JOptionPane.ERROR_MESSAGE);

                }
             }
        };        

    }

    public ActionListener getUjReceptOsszetevotEltavolitListener() {
        return new ActionListener() {
             @Override public void actionPerformed (ActionEvent e) {
                 try{
                 gui.getNewRPanel().removeRowToOtevoTabla(rKezelo.getAktualisOtevoSor());
                 }
                 catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(gui, ex.getMessage(), "Hiba", JOptionPane.ERROR_MESSAGE);

                }
             }
        }; 

    }

    public ActionListener getRogzitesGombListener() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ActionListener getKijelentkezesGombListener() {
        return new ActionListener() {
             @Override public void actionPerformed (ActionEvent e) {
                 
                 CardLayout cardLayout = (CardLayout) gui.getCardLayout();
                cardLayout.show(gui.getContentPane(), "card5");
                 //rKezelo.setAktualisMennyisegTipus("");
                 //rKezelo.getAktualisRecept().setMegnevezes("");
             }
         };
    }
    
    
}
