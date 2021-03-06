package view;

import controller.Controller;
import java.awt.*;
import java.awt.event.*;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import model.ReceptKliens;

public class LogonPanel extends JPanel {

    private JLabel cim;
    private JLabel nevBel;
    private JTextField userNeveBel;
    private JLabel space1;
    private JLabel jelszoBel;
    private JTextField userJelszoBel;
    private JLabel space2;
    private JButton btnBelepes;
    private JLabel space3;
    private JButton btnRegisztracio;
    private JLabel space4;
    
    private JFrame pFrame;
    private JPanel guiPanel;
    private boolean initialized;
    private GUI parent;

    public LogonPanel(GUI gui) {
        parent=gui;
        initialized = false;
        JTextField testTxt= new JTextField(30);
        //testTxt.setText(ReceptKliens.kapcsolatTeszt());
        cim = new JLabel("Bejelentkezés");
        nevBel = new JLabel("Név:");
        this.userNeveBel = new JTextField(30);
        space1 = new JLabel("");
        jelszoBel = new JLabel("Jelszó:");
        this.userJelszoBel = new JTextField(30);
        space2 = new JLabel("");
        this.btnBelepes = new JButton("Belépés");
        space3 = new JLabel("");
        this.btnRegisztracio = new JButton("Regisztráció");
        space4 = new JLabel("");
        

        btnBelepes.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                CardLayout cardLayout = parent.getCardLayout();
                cardLayout.show(parent.getContentPane(), "card1");
            }
        }
        );
        btnRegisztracio.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                CardLayout cardLayout = parent.getCardLayout();
                cardLayout.show(parent.getContentPane(), "card6");
            }
        }
        );
        

        //adjust size and set layout
        setPreferredSize(new Dimension(400, 650));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.decode("#3AAACF"));
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));

        cim.setFont(new Font("Courier New", 1, 24));
        cim.setBorder(new EmptyBorder(new Insets(1, 50, 50, 1)));

        nevBel.setFont(new Font("Courier New", 0, 14));

        userNeveBel.setBackground(Color.decode("#62B4CF"));
        userNeveBel.setMaximumSize(new Dimension(800, 20));

        space1.setFont(new Font("Courier New", 1, 24));
        space1.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));

        jelszoBel.setFont(new Font("Courier New", 0, 14));

        userJelszoBel.setBackground(Color.decode("#62B4CF"));
        userJelszoBel.setMaximumSize(new Dimension(800, 20));

        space2.setFont(new Font("Courier New", 1, 24));
        space2.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));

        btnBelepes.setFont(new Font("Courier New", 1, 14));

        space3.setFont(new Font("Courier New", 1, 24));
        space3.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));

        btnRegisztracio.setFont(new Font("Courier New", 1, 14));

        space4.setFont(new Font("Courier New", 1, 24));
        space4.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));

        

        //add components
        add(cim);
        //tesztelésre
        //add(testTxt);
        add(nevBel);
        add(userNeveBel);
        add(space1);
        add(jelszoBel);
        add(userJelszoBel);
        add(space2);
        add(btnBelepes);
        add(space3);
        add(btnRegisztracio);
        add(space4);
        

    }
/*
    public LogonPanel(Controller controller) {
        initialized = false;
        cim = new JLabel("Bejelentkezés");
        nevBel = new JLabel("Név:");
        this.userNeveBel = new JTextField(30);
        space1 = new JLabel("");
        jelszoBel = new JLabel("Jelszó:");
        this.userJelszoBel = new JTextField(30);
        space2 = new JLabel("");
        this.btnBelepes = new JButton("Belépés");
        space3 = new JLabel("");
        this.btnRegisztracio = new JButton("Regisztráció");
        space4 = new JLabel("");
        this.btnKilepes = new JButton("Kilépés");

        btnBelepes.addActionListener(controller.getVisszaGombListener());
        btnRegisztracio.addActionListener(controller.getVisszaGombListener());
        btnKilepes.addActionListener(controller.getKilepes());

        //adjust size and set layout
        setPreferredSize(new Dimension(400, 650));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.decode("#3AAACF"));
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));

        cim.setFont(new Font("Courier New", 1, 24));
        cim.setBorder(new EmptyBorder(new Insets(1, 50, 50, 1)));

        nevBel.setFont(new Font("Courier New", 0, 14));

        userNeveBel.setBackground(Color.decode("#62B4CF"));

        space1.setFont(new Font("Courier New", 1, 24));
        space1.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));

        jelszoBel.setFont(new Font("Courier New", 0, 14));

        userJelszoBel.setBackground(Color.decode("#62B4CF"));

        space2.setFont(new Font("Courier New", 1, 24));
        space2.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));

        btnBelepes.setFont(new Font("Courier New", 1, 14));

        space3.setFont(new Font("Courier New", 1, 24));
        space3.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));

        btnRegisztracio.setFont(new Font("Courier New", 1, 14));

        space4.setFont(new Font("Courier New", 1, 24));
        space4.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));

        btnKilepes.setFont(new Font("Courier New", 1, 14));

        //add components
        add(cim);
        add(nevBel);
        add(userNeveBel);
        add(space1);
        add(jelszoBel);
        add(space2);
        add(btnBelepes);
        add(space3);
        add(btnRegisztracio);
        add(space4);
        add(btnKilepes);

    }
*/
    public void addController(ActionListener controller) {
        this.btnBelepes.addActionListener(controller);
        this.btnRegisztracio.addActionListener(controller);
    }

    void setGuiPanel(JPanel guiPanel) {
        this.guiPanel = guiPanel;
    }

    void setpFrame(JFrame pFrame) {
        this.pFrame = pFrame;
    }

    public GUI getParent() {
        return parent;
    }

    public void setParent(GUI parent) {
        this.parent = parent;
    }

    

    private String testDBServ() {
    try {
    // Construct a URL referring to the servlet
    //URL url = new URL(getCodeBase(), "/TestServlet");
    URL url = new URL("http://localhost:8084/ReceptGyujto-web/DBServ?action=test");
    
    Reader reader = new InputStreamReader(url.openStream(), "UTF-8");
    // Return the string representation of the Date
    String servRead="";
    int r;
        while ((r = reader.read()) != -1) {
            char ch = (char) r;
            servRead= new StringBuilder(servRead).append(ch).toString();
        }
//return reader.toString();
    return servRead;
  }
  catch (Exception e) {
    // If there was a problem, print to System.out
    // (typically the Java console) and return null
    e.printStackTrace();
    return e.toString()+" "+e.getMessage()+" "+ e.getLocalizedMessage();
  }
  }
}
