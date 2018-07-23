/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ayudantia.GUI;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raguileoam
 */
public class Tabla_Luchadores extends DefaultTableModel{
    
                @Override
                public Class
                        getColumnClass(int column) {
                    switch (column) {
                        case 0:
                            return Integer.class;

                        case 1:
                            return Integer.class;
                        default:
                            return String.class;
                    }
                }
                boolean[] canEdit = new boolean[]{
                    false, false
                };

                @Override
                public boolean isCellEditable(int i, int i1) {
                    return canEdit[i1]; //To change body of generated methods, choose Tools | Templates.
                }
    
}
