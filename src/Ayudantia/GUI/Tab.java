/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ayudantia.GUI;

import Ayudantia.Model.Inventory.InventarioLuchadores;
import java.awt.AWTKeyStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.KeyboardFocusManager;
import java.util.Collections;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raguileoam
 */
public class Tab extends JTable {

    private InventarioLuchadores luchones;
    Font texto = new Font("Agency FB", Font.BOLD, 18);
    public Tab(InventarioLuchadores luchones) {
        super();
        this.luchones = luchones;
        initComponents();
    }

    public void initComponents() {
        setModel(model());
        setFont(texto);
        setOpaque(false);
        setForeground(Color.WHITE);
        setRowHeight(24);
        DefaultTableCellRenderer d=new DefaultTableCellRenderer();
        d.setOpaque(false);
        setDefaultRenderer(Object.class, d);
        
        
        
    }

    public DefaultTableModel model() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Luchador");
        Object[] obj = new Object[1];
        for (int i = 0; i < luchones.cantidadLuchadores(); i++) {
            obj[0] = luchones.getLuchadores().get(i);
            dtm.addRow(obj);
        }   
        return dtm;
    }
}
