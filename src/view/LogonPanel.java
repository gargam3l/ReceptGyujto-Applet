package view;

import controller.Controller;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

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
    private JLabel regisztracio;
    private JLabel nevReg;
    private JTextField userNeveReg;
    private JLabel space4;
    private JLabel jelszoReg;
    private JTextField userJelszoReg;
    private JLabel space5;
    private JButton btnRegisztracio;
    private JLabel space6;
    private JButton btnKilepes;
    private JFrame pFrame;
    private JPanel guiPanel;
    private boolean initialized;
    private GUI parent;

    public LogonPanel(GUI gui) {
        parent=gui;
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
        regisztracio = new JLabel("Regisztráció");
        nevReg = new JLabel("Név:");
        this.userNeveReg = new JTextField(30);
        space4 = new JLabel("");
        jelszoReg = new JLabel("Jelszó:");
        this.userJelszoReg = new JTextField(30);
        space5 = new JLabel("");
        this.btnRegisztracio = new JButton("Regisztráció");
        space6 = new JLabel("");
        this.btnKilepes = new JButton("Kilépés");

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
                cardLayout.show(parent.getContentPane(), "card1");
            }
        }
        );
        btnKilepes.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                parent.exit();
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

        space1.setFont(new Font("Courier New", 1, 24));
        space1.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));

        jelszoBel.setFont(new Font("Courier New", 0, 14));

        userJelszoBel.setBackground(Color.decode("#62B4CF"));

        space2.setFont(new Font("Courier New", 1, 24));
        space2.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));

        btnBelepes.setFont(new Font("Courier New", 1, 14));

        space3.setFont(new Font("Courier New", 1, 24));
        space3.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));

        regisztracio.setFont(new Font("Courier New", 1, 24));
        regisztracio.setBorder(new EmptyBorder(new Insets(1, 50, 50, 1)));

        nevReg.setFont(new Font("Courier New", 0, 14));

        userNeveReg.setBackground(Color.decode("#62B4CF"));

        space4.setFont(new Font("Courier New", 1, 24));
        space4.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));

        jelszoReg.setFont(new Font("Courier New", 0, 14));

        userJelszoReg.setBackground(Color.decode("#62B4CF"));

        space5.setFont(new Font("Courier New", 1, 24));
        space5.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));

        btnRegisztracio.setFont(new Font("Courier New", 1, 14));

        space6.setFont(new Font("Courier New", 1, 24));
        space6.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));

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
        add(regisztracio);
        add(nevReg);
        add(userNeveReg);
        add(space4);
        add(jelszoReg);
        add(userJelszoReg);
        add(space5);
        add(btnRegisztracio);
        add(space6);
        add(btnKilepes);

    }

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
        regisztracio = new JLabel("Regisztráció");
        nevReg = new JLabel("Név:");
        this.userNeveReg = new JTextField(30);
        space4 = new JLabel("");
        jelszoReg = new JLabel("Jelszó:");
        this.userJelszoReg = new JTextField(30);
        space5 = new JLabel("");
        this.btnRegisztracio = new JButton("Regisztráció");
        space6 = new JLabel("");
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

        regisztracio.setFont(new Font("Courier New", 1, 24));
        regisztracio.setBorder(new EmptyBorder(new Insets(1, 50, 50, 1)));

        nevReg.setFont(new Font("Courier New", 0, 14));

        userNeveReg.setBackground(Color.decode("#62B4CF"));

        space4.setFont(new Font("Courier New", 1, 24));
        space4.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));

        jelszoReg.setFont(new Font("Courier New", 0, 14));

        userJelszoReg.setBackground(Color.decode("#62B4CF"));

        space5.setFont(new Font("Courier New", 1, 24));
        space5.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));

        btnRegisztracio.setFont(new Font("Courier New", 1, 14));

        space6.setFont(new Font("Courier New", 1, 24));
        space6.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));

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
        add(regisztracio);
        add(nevReg);
        add(userNeveReg);
        add(space4);
        add(jelszoReg);
        add(userJelszoReg);
        add(space5);
        add(btnRegisztracio);
        add(space6);
        add(btnKilepes);

    }

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

    public JButton getKilepes() {
        return btnKilepes;
    }

}
