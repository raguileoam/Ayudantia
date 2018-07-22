/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ayudantia;

/**
 *
 * @author raguileoam
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javafx.scene.layout.Border;
import javax.imageio.ImageIO;
import javax.swing.plaf.PanelUI;

public class GUI_Resultados extends JFrame implements ActionListener {

    protected JButton btn_next;
    protected JTextArea luchador;
    protected JTextArea monster;
    protected JTextArea turn;
    protected JButton btn_exit;
    protected JPanel j;
    private Batalla battle;

    public GUI_Resultados() {
        super();
        initWindow();
        initComponents();
 
        add(luchador);
        add(turn);
        add(monster);
        add(btn_next);
        add(btn_exit);
        btn_next.addActionListener(this);
        btn_exit.addActionListener(this);
       
    }

    public boolean initComponents() {
        btn_next = new JButton("Siguiente");
        battle = new Batalla();
        luchador = new JTextArea(battle.getLuchones().mostrarLuchadores());
        turn = new JTextArea(battle.turno());
        monster = new JTextArea(battle.getMonstro().toString());
        btn_exit = new JButton("Salir");
        j = new JPanel(new FlowLayout());
        luchador.setOpaque(false);
        turn.setOpaque(false);
        monster.setOpaque(false);
        btn_exit.setVisible(false);
         luchador.setForeground(Color.WHITE);
         turn.setForeground(Color.WHITE);
         monster.setForeground(Color.WHITE);
        return true;
    }

    public boolean initWindow() {
        this.setName("Resultados");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(630, 350);
        setLayout(new BorderLayout());
        setContentPane(new JLabel(background()));
        setLayout(new FlowLayout());
        return true;
    }

    public ImageIcon background() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("bg.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(this.getWidth(), this.getHeight(),
                Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        return imageIcon;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btn_next) {
            if (!battle.isEnd()) {
                turn.setText(battle.turno());
                luchador.setText(battle.getLuchones().mostrarLuchadores());
                monster.setText(battle.getMonstro().toString());
                System.out.println("Actualizado");
            } else {
                turn.setText(battle.resultado());
                btn_exit.setVisible(true);
                System.out.println("FINAL");
            }
        } else if (ae.getSource() == btn_exit) {
            this.dispose();
        }
    }
}
