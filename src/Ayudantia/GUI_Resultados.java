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
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;

public class GUI_Resultados extends JFrame implements ActionListener {

    protected JButton buton;
    protected JTextArea luchador;
    protected JTextArea mostruo;
    protected JTextArea turno;
    protected JButton salir;
    protected JPanel j;
    private Batalla batalla;

    public GUI_Resultados() {
        super();
        buton = new JButton("Siguiente");
        batalla = new Batalla();
        luchador = new JTextArea(batalla.getLuchones().mostrarLuchadores());
        turno = new JTextArea(batalla.turno());
        mostruo = new JTextArea(batalla.getMonstro().toString());
        j = new JPanel();
        this.setLayout(new FlowLayout());
        this.add(luchador);
        this.add(turno);
        this.add(mostruo);
        this.add(buton);
        salir = new JButton("Salir");
        this.add(salir);
        salir.addActionListener(this);
        salir.setVisible(false);
        buton.addActionListener(this);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(650, 200);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == buton) {
            if (!batalla.isEnd()) {
                turno.setText(batalla.turno());
                luchador.setText(batalla.getLuchones().mostrarLuchadores());
                mostruo.setText(batalla.getMonstro().toString());
                System.out.println("Actualzuado");
            } else {
                turno.setText(batalla.resultado());
                salir.setVisible(true);
                System.out.println("FINAL");
            }
        } else if (ae.getSource() == salir) {
            this.dispose();
        }

    }

}
