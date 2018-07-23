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
import Ayudantia.Model.Character.Luchador;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class GUI_Ingreso extends JFrame implements ActionListener {
    
    private JLabel t_titulo;
    private JTextArea luchadores;
    private JButton btn_generar;
    private JButton btn_select;
    private Tab table;
    private Batalla battle;
    private JPanel j;
    Font titulo = new Font("Agency FB", Font.BOLD, 30);
    

    
    public GUI_Ingreso() {
        super();
        battle=new Batalla(false);
        initWindow();
        initComponents();
        this.add(t_titulo,BorderLayout.NORTH);
        this.add(table,BorderLayout.CENTER);
        j.add(btn_generar);
        j.add(btn_select);
        j.setOpaque(false);
        this.add(j,BorderLayout.SOUTH);
        btn_generar.addActionListener(this);
        btn_select.addActionListener(this);
    }
  
    
    public void initComponents() {
        table=new Tab(battle.getLuchadores());
        t_titulo = new JLabel("~ Generar Personajes ~ Seleccione un luchador");
        t_titulo.setOpaque(false);
        t_titulo.setForeground(Color.WHITE);
        t_titulo.setFont(titulo);
        j=new JPanel(new FlowLayout());
        btn_generar=new JButton("Generar luchador");
        btn_select=new JButton("Luchar");     
    }
    
    public void initWindow() {
        this.setTitle("Ingreso");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(950, 850);
        this.setContentPane(new JLabel(background()));
        this.setLayout(new BorderLayout());
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
        if(ae.getSource()==btn_generar){
            battle.getLuchadores().agregarLuchador();
            table.setModel(table.model());
            System.out.println("Agregado");
        }
        else if(ae.getSource()==btn_select){
            if(table.getSelectedRow()!=-1){
              Luchador aux=(Luchador) table.getValueAt(table.getSelectedRow(), 0);
              battle.getSeleccionados().add(aux);
              System.out.println("Seleccionado");
            }
        } 
    }
}
