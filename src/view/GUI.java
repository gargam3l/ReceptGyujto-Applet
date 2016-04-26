/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;


import controller.Controller;
import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import model.ReceptKezelo;
import java.applet.*;
import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author 604772006
 */
public class GUI extends JApplet{
    //private CardLayout cardLayout = new CardLayout();
    //private JPanel cards= new JPanel(cardLayout);
    private JFrame frame = new JFrame();
    private MainPanel mPanel;
    private NewRecipePanel newRPanel;
    private SearchRecipePanel srchRPanel;
    private ShowRecipePanel shRPanel;
    private Controller guiControl;
    public final String[] RECEPT_OSZLOP_NEVEK = {"Mennyiség", "Egység", "Összetevő"};

    /*
    public GUI(Controller controller)
    {
        setGuiControl(controller);
        init();
        
        
    }
    */
    @Override
    public void init()
    {
    
        Runnable r = new Runnable() {
        public void run() {
            
            //add(new JLabel("Hello World!"));
            
            //setGuiControl(new Controller());
            final CardLayout cardLayout = new CardLayout();
            setLayout(cardLayout);
            
            mPanel = new MainPanel();
            //newRPanel = new NewRecipePanel(guiControl);
            //shRPanel = new ShowRecipePanel(guiControl);
            //srchRPanel = new SearchRecipePanel(guiControl);
            //mPanel.setGuiPanel(cards);
            //shRPanel.setGuiPanel(cards);
            //newRPanel.setGuiPanel(cards);
            //srchRPanel.setGuiPanel(cards);
            //mPanel.setpFrame(frame);
            //shRPanel.setpFrame(frame);
            //newRPanel.setpFrame(frame);
            //srchRPanel.setpFrame(frame);

            add(mPanel, "card1");
            //cards.add(newRPanel, "card2");
            //cards.add(shRPanel, "card3");
            //cards.add(srchRPanel, "card4");
            cardLayout.show(getContentPane(), "card1");


            //setLayout(new CardLayout());
            //add(cards);
                   
      }
    };
    try 
    {
      SwingUtilities.invokeAndWait(r);
    } catch(InterruptedException ie) 
    {
      ie.printStackTrace();
    } catch (InvocationTargetException ite) 
    {
      ite.printStackTrace();
    }


}
        
        
        
            

    public void displayGUI()
    {
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(this, BorderLayout.CENTER);
        //frame.getContentPane().add(this);
        //frame.setLayout(cardLayout);
        frame.setTitle("Chlebovics Kornél(VYSQGW) & Papp Zoltán(N3GM04)");
        frame.pack();   
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    
    public MainPanel getmPanel() {
        return mPanel;
    }

    public NewRecipePanel getNewRPanel() {
        return newRPanel;
    }

    public ShowRecipePanel getShRPanel() {
        return shRPanel;
    }

    /*
    public JPanel getCards() {
        return (JPanel)this;
    }
*/
    public SearchRecipePanel getSrchRPanel() {
        return srchRPanel;
    }
    
    
    /*
    public JPanel getCurrentCard()
{
    JPanel card = null;

    for (Component comp : cards.getComponents() ) {
        if (comp.isVisible() == true) {
            card = (JPanel)comp;
            System.out.println(card.getName() );
        }
    }
    //System.out.println();

    return card;
    
    
    
}
*/
    public Controller getGuiControl() {
        return guiControl;
    }

    public void setGuiControl(Controller guiControl) {
        this.guiControl = guiControl;
    }

    public JFrame getFrame() {
        return frame;
    }
    
    
    
}
