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

public class GUI_Resultados extends JFrame implements ActionListener {

    private JButton buton;
    private JTextField field;
    private Batalla batalla;

    public GUI_Resultados() {
        buton = new JButton("Siguiente");
        field = new JTextField();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
