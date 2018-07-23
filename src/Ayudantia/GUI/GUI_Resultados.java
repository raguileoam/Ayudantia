/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ayudantia.GUI;

/**
 *
 * @author raguileoam
 */
import Ayudantia.Model.Battle.Batalla;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GUI_Resultados extends JFrame implements ActionListener {

    protected JButton btn_next;
    protected JTextArea luchador;
    protected JTextArea monster;
    protected JTextArea turn;
    protected JButton btn_exit;
    private Batalla battle;
    Font font = new Font("Agency FB", Font.BOLD, 22);

    public GUI_Resultados(Batalla battle) {
        super();
         this.battle=battle;
        initWindow();
        initComponents();
       
        add(luchador);
        add(turn);
        add(monster);
        add(btn_next);
        add(btn_exit);
        this.setResizable(false);
        btn_next.addActionListener(this);
        btn_exit.addActionListener(this);

    }

    public boolean initComponents() {
        btn_next = new JButton("Siguiente");
        luchador = new JTextArea(battle.getSeleccionados().mostrarLuchadores());
        turn = new JTextArea(battle.turno());
        monster = new JTextArea(battle.getMonstro().toString());
        btn_exit = new JButton("Salir");
        luchador.setOpaque(false);
        turn.setOpaque(false);
        monster.setOpaque(false);
        btn_exit.setVisible(false);
        luchador.setForeground(Color.WHITE);
        turn.setForeground(Color.WHITE);
        monster.setForeground(Color.WHITE);
        luchador.setFont(font);
        turn.setFont(font);
        monster.setFont(font);
        return true;
    }

    public boolean initWindow() {
        this.setTitle("Resultados");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(750, 650);
        this.setContentPane(new JLabel(background()));
        this.setLayout(new FlowLayout());
        return true;
    }

    public ImageIcon background() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("bg.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(this.getWidth() + 20, this.getHeight() + 20,
                Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        return imageIcon;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btn_next) {
            if (!battle.isEnd()) {
                turn.setText(battle.turno());
                luchador.setText(battle.getSeleccionados().mostrarLuchadores());
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
