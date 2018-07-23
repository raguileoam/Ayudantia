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
import javafx.scene.control.CheckBox;
import javax.imageio.ImageIO;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class GUI_Ingreso extends JFrame implements ActionListener {

    private JLabel t_titulo;
    private JButton btn_generar;
    private JButton btn_select;
    private JButton btn_luchar;
    private Tab table;
    private Batalla battle;
    private JPanel botones;
    private final Font titulo = new Font("Agency FB", Font.BOLD, 30);

    public GUI_Ingreso() {
        super();
        battle = new Batalla();
        initWindow();
        initComponents();
        this.add(t_titulo, BorderLayout.NORTH);
        this.add(table, BorderLayout.CENTER);
        botones.add(btn_generar);
        botones.add(btn_select);
        botones.add(btn_luchar);
        botones.setOpaque(false);
        this.add(botones, BorderLayout.SOUTH);
        btn_generar.addActionListener(this);
        btn_select.addActionListener(this);
        btn_luchar.addActionListener(this);
    }

    public void initComponents() {
        table = new Tab(battle.getLuchadores());
        t_titulo = new JLabel("~ Generar Personajes ~ Seleccione un luchador");
        t_titulo.setOpaque(false);
        t_titulo.setForeground(Color.WHITE);
        t_titulo.setFont(titulo);
        botones = new JPanel(new FlowLayout());
        btn_generar = new JButton("Generar luchador");
        btn_select = new JButton("Seleccionar luchador");
        btn_luchar = new JButton("Luchar");
    }

    public void initWindow() {
        this.setTitle("Ingreso");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(950, 750);
        this.setContentPane(new JLabel(background()));
        this.setLayout(new BorderLayout());
        this.setResizable(false);
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
        if (ae.getSource() == btn_generar) {
            if(battle.getLuchadores().isComplete()){
            battle.getLuchadores().agregarLuchador();     
            table.setModel(table.agregar((DefaultTableModel) table.getModel()));
            System.out.println("Agregado");
            }
            else{
               JOptionPane.showMessageDialog(null, "Se ha sobrepaso el limite", "Se Informa:", JOptionPane.ERROR_MESSAGE);

            }
        } else if (ae.getSource() == btn_select) {
            int row = table.getSelectedRow();
            if (row != -1) {
                JCheckBox jcb = (JCheckBox) table.getValueAt(row, 1);
                if (!jcb.isSelected()) {
                    if(battle.getSeleccionados().isComplete()){
                    jcb.setSelected(true);
                    Luchador aux = (Luchador) table.getValueAt(row, 0);
                    battle.getSeleccionados().agregarLuchador(aux);
                    table.setValueAt(jcb, row, 1);
                    System.out.println("Seleccionado");
                    }
                    else {
                    JOptionPane.showMessageDialog(null, "Se ha sobrepasado el limite", "Se Informa:", JOptionPane.ERROR_MESSAGE);
                }
                    
                } else {
                    JOptionPane.showMessageDialog(null, "El luchador ya esta seleccionado", "Se Informa:", JOptionPane.ERROR_MESSAGE);
                }
            }

        } else if (ae.getSource() == btn_luchar) {
            GUI_Resultados resultado = new GUI_Resultados(battle);
            this.setVisible(false);
            resultado.setVisible(true); 
        }
    }
}
