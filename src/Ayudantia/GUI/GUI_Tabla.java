/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ayudantia.GUI;

import Ayudantia.Model.Inventory.InventarioLuchadores;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raguileoam
 */
public class GUI_Tabla extends JTable {

    private InventarioLuchadores luchones;
    Font texto = new Font("Agency FB", Font.BOLD, 18);

    public GUI_Tabla(InventarioLuchadores luchones) {
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
        setSelectionForeground(Color.CYAN);
        DefaultTableCellRenderer d = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {

                if (value instanceof JCheckBox) {
                    JCheckBox ch = (JCheckBox) value;
                    ch.setOpaque(false);
                    return ch;
                }

                return super.getTableCellRendererComponent(table, value, isSelected,
                        hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
            }
        };
        d.setOpaque(false);
        setDefaultRenderer(Object.class, d);
    }

    public DefaultTableModel model() {
        boolean[] canEdit;
        canEdit = new boolean[]{false, false};
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return JCheckBox.class;
                    default:
                        return Object.class;
                }
            }

            @Override
            public boolean isCellEditable(int i, int i1) {
                return canEdit[i1]; //To change body of generated methods, choose Tools | Templates.
            }

        };
        dtm.addColumn("Luchador");
        dtm.addColumn("Selecionado");

        Object[] obj = new Object[2];
        for (int i = 0; i < luchones.cantidadLuchadores(); i++) {
            obj[0] = luchones.getLuchadores().get(i);
            obj[1] = new JCheckBox();
            dtm.addRow(obj);
        }
        return dtm;
    }

    DefaultTableModel agregar(DefaultTableModel dtm) {
        Object[] obj = new Object[2];
        obj[0] = luchones.getLuchadores().get(luchones.cantidadLuchadores() - 1);
        obj[1] = new JCheckBox();
        dtm.addRow(obj);
        return dtm;
    }
}
