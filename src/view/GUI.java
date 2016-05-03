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
    private CardLayout cardLayout;
    //private JPanel cards= new JPanel(cardLayout);
    private JFrame frame = new JFrame();
    private MainPanel mPanel;
    private NewRecipePanel newRPanel;
    private SearchRecipePanel srchRPanel;
    private ShowRecipePanel shRPanel;
    private Controller guiControl;
    public final String[] RECEPT_OSZLOP_NEVEK = {"Mennyiség", "Egység", "Összetevő"};
    private Controller controller;

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

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
        controller = new Controller();
        controller.setGui(this);
    
        Runnable r = new Runnable() 
        {
        public void run() 
        {
            displayApplet();
            
                   
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
        
public void displayApplet()
{
    //add(new JLabel("Hello World!"));
            
            //setGuiControl(new Controller());
            cardLayout = new CardLayout();
            setLayout(cardLayout);
            
            LogonPanel lPanel = new LogonPanel(this);
            mPanel = new MainPanel(this);
            newRPanel = new NewRecipePanel(this);
            shRPanel = new ShowRecipePanel(this);
            srchRPanel = new SearchRecipePanel(this);
            //lPanel.setParent(this);
            //mPanel.setParent(this);
            //shRPanel.setParent(this);
            //newRPanel.setParent(this);
            //srchRPanel.setParent(this);
            //mPanel.setpFrame(frame);
            //shRPanel.setpFrame(frame);
            //newRPanel.setpFrame(frame);
            //srchRPanel.setpFrame(frame);

            add(mPanel, "card1");
            add(newRPanel, "card2");
            add(shRPanel, "card3");
            add(srchRPanel, "card4");
            add(lPanel, "card5");
            cardLayout.show(getContentPane(), "card5");


            //setLayout(new CardLayout());
            //add(cards);
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

    public CardLayout getCardLayout() {
        return cardLayout;
    }
    
    
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
    
    public void exit()
    {
       
    System.out.println("Application is exiting.");
    setVisible(false);
    ;
    System.exit(0);
  } 
    
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
