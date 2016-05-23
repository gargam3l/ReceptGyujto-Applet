package view;

import controller.Controller;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainPanel extends JPanel {

    private JFrame pFrame;
    private JLabel cim;
    private JLabel space1;
    private JLabel space2;
    private JButton ujRecept;
    private JPanel guiPanel;
    private JButton receptKeres;
    private JButton vissza;
    private boolean initialized;
    private GUI parent;

    public MainPanel(GUI gui) {
        parent=gui;
        //construct components
        cim = new JLabel("Recept Kezelő");
        ujRecept = new JButton("Új recept hozzáadása");
        space1 = new JLabel("");
        receptKeres = new JButton("Recept Keresése");
        space2 = new JLabel("");
        vissza = new JButton("Kilépés");

        ujRecept.addActionListener(parent.getController().getUjReceptPanelListener());
        receptKeres.addActionListener(parent.getController().getReceptKeresPanelListener());
        vissza.addActionListener(parent.getController().getKilepes());
        /*
        ujRecept.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                CardLayout cardLayout = parent.getCardLayout();
                cardLayout.show(parent.getContentPane(), "card2");
            }
        }
        );
        receptKeres.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                CardLayout cardLayout = parent.getCardLayout();
                cardLayout.show(parent.getContentPane(), "card4");
            }
        }
        );
        vissza.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = parent.getCardLayout();
                cardLayout.show(parent.getContentPane(), "card5");
            }
        }
        );
*/
        //adjust size and set layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(400, 650));
        setBackground(Color.decode("#3AAACF"));
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));

        cim.setFont(new Font("Courier New", 1, 24));
        cim.setBorder(new EmptyBorder(new Insets(1, 50, 50, 1)));

        ujRecept.setFont(new Font("Courier New", 1, 14));

        space1.setFont(new Font("Courier New", 1, 24));
        space1.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));

        receptKeres.setFont(new Font("Courier New", 1, 14));

        space2.setFont(new Font("Courier New", 1, 24));
        space2.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));

        vissza.setFont(new Font("Courier New", 1, 14));

        //add components
        add(cim);
        add(ujRecept);
        add(space1);
        add(receptKeres);
        add(space2);
        add(vissza);

    }
/*
    public MainPanel(Controller controller) {

        //construct components
        cim = new JLabel("Recept Kezelő");
        ujRecept = new JButton("Új recept hozzáadása");
        space1 = new JLabel("");
        receptKeres = new JButton("Recept Keresése");
        space2 = new JLabel("");
        vissza = new JButton("Vissza");

        ujRecept.addActionListener(controller.getUjReceptPanelListener());
        receptKeres.addActionListener(controller.getReceptKeresPanelListener());
        vissza.addActionListener(controller.getVisszaGombListener());

        //adjust size and set layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(400, 650));
        setBackground(Color.decode("#3AAACF"));
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));

        cim.setFont(new Font("Courier New", 1, 24));
        cim.setBorder(new EmptyBorder(new Insets(1, 50, 50, 1)));

        ujRecept.setFont(new Font("Courier New", 1, 14));

        space1.setFont(new Font("Courier New", 1, 24));
        space1.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));

        receptKeres.setFont(new Font("Courier New", 1, 14));

        space2.setFont(new Font("Courier New", 1, 24));
        space2.setBorder(new EmptyBorder(new Insets(1, 1, 10, 1)));

        vissza.setFont(new Font("Courier New", 1, 14));

        //add components
        add(cim);
        add(ujRecept);
        add(space1);
        add(receptKeres);
        add(space2);
        add(vissza);

    }
*/
    public void addController(ActionListener controller) {
        //System.out.println("View      : adding controller");
        this.ujRecept.addActionListener(controller);
        this.receptKeres.addActionListener(controller);
    } //addController()

    public void setGuiPanel(JPanel guiPanel) {
        this.guiPanel = guiPanel;
    }

    public void setpFrame(JFrame pFrame) {
        this.pFrame = pFrame;
    }

    public JButton getUjRecept() {
        return ujRecept;
    }

    public JButton getReceptKeres() {
        return receptKeres;
    }

    public GUI getParent() {
        return parent;
    }

    public void setParent(GUI parent) {
        this.parent = parent;
    }

}
