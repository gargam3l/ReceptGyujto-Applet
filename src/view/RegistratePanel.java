/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class RegistratePanel extends JPanel {

    private JLabel cim;
    private JLabel nevReg;
    private JTextField userNeveReg;
    private JLabel space1;
    private JLabel jelszoReg;
    private JTextField userJelszoReg;
    private JLabel space2;
    private JButton btnRegisztracio;
    private JLabel space3;
    private JButton btnVissza;
    private JFrame pFrame;
    private JPanel guiPanel;
    private boolean initialized;
    private GUI parent;

    public RegistratePanel(GUI gui) {
        parent=gui;
        initialized = false;
        cim = new JLabel("Regisztráció");
        nevReg = new JLabel("Név:");
        this.userNeveReg = new JTextField(30);
        space1 = new JLabel("");
        jelszoReg = new JLabel("Jelszó:");
        this.userJelszoReg = new JTextField(30);
        space2 = new JLabel("");
        this.btnRegisztracio = new JButton("Regisztráció");
        space3 = new JLabel("");
        this.btnVissza = new JButton("Vissza");

        btnRegisztracio.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                CardLayout cardLayout = parent.getCardLayout();
                cardLayout.show(parent.getContentPane(), "card1");
            }
        }
        );
        btnVissza.addActionListener(parent.getController().getKijelentkezesGombListener());

        //adjust size and set layout
        setPreferredSize(new Dimension(400, 650));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.decode("#3AAACF"));
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));

        cim.setFont(new Font("Courier New", 1, 24));
        cim.setBorder(new EmptyBorder(new Insets(1, 50, 50, 1)));

        nevReg.setFont(new Font("Courier New", 0, 14));

        userNeveReg.setBackground(Color.decode("#62B4CF"));

        space1.setFont(new Font("Courier New", 1, 24));
        space1.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));

        jelszoReg.setFont(new Font("Courier New", 0, 14));

        userJelszoReg.setBackground(Color.decode("#62B4CF"));

        space2.setFont(new Font("Courier New", 1, 24));
        space2.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));

        btnRegisztracio.setFont(new Font("Courier New", 1, 14));

        space3.setFont(new Font("Courier New", 1, 24));
        space3.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));

        btnVissza.setFont(new Font("Courier New", 1, 14));

        //add components
        add(cim);
        add(nevReg);
        add(userNeveReg);
        add(space1);
        add(jelszoReg);
        add(userJelszoReg);
        add(space2);
        add(btnRegisztracio);
        add(space3);
        add(btnVissza);

    }

    public RegistratePanel(Controller controller) {
        initialized = false;
        cim = new JLabel("Regisztráció");
        nevReg = new JLabel("Név:");
        this.userNeveReg = new JTextField(30);
        space1 = new JLabel("");
        jelszoReg = new JLabel("Jelszó:");
        this.userJelszoReg = new JTextField(30);
        space2 = new JLabel("");
        this.btnRegisztracio = new JButton("Regisztráció");
        space3 = new JLabel("");
        this.btnVissza = new JButton("Vissza");

        btnRegisztracio.addActionListener(parent.getController().getRogzitesGombListener());
        btnVissza.addActionListener(parent.getController().getVisszaGombListener());

        //adjust size and set layout
        setPreferredSize(new Dimension(400, 650));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.decode("#3AAACF"));
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));

        cim.setFont(new Font("Courier New", 1, 24));
        cim.setBorder(new EmptyBorder(new Insets(1, 50, 50, 1)));

        nevReg.setFont(new Font("Courier New", 0, 14));

        userNeveReg.setBackground(Color.decode("#62B4CF"));

        space1.setFont(new Font("Courier New", 1, 24));
        space1.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));

        jelszoReg.setFont(new Font("Courier New", 0, 14));

        userJelszoReg.setBackground(Color.decode("#62B4CF"));

        space2.setFont(new Font("Courier New", 1, 24));
        space2.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));

        btnRegisztracio.setFont(new Font("Courier New", 1, 14));

        space3.setFont(new Font("Courier New", 1, 24));
        space3.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));

        btnVissza.setFont(new Font("Courier New", 1, 14));

        //add components
        add(cim);
        add(nevReg);
        add(userNeveReg);
        add(space1);
        add(jelszoReg);
        add(userJelszoReg);
        add(space2);
        add(btnRegisztracio);
        add(space3);
        add(btnVissza);

    }

    public void addController(ActionListener controller) {
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

}
