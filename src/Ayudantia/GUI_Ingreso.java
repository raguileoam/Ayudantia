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
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class GUI_Ingreso extends JFrame implements ActionListener {


    public GUI_Ingreso() {
        super();
        initWindow();
        initComponents();
    }
    public boolean initComponents(){
 
        return true;
    }
    public boolean initWindow(){
        this.setName("Ingreso");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(630, 350);
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }
}

