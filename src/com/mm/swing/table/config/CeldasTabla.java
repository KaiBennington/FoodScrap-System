package com.mm.swing.table.config;
 
import javax.swing.table.DefaultTableModel;
 
/**
 * Modelo de tabla propio.
 * @author mfmartinez
 */
public class CeldasTabla extends DefaultTableModel {
     
    /**
     * Define la posibilidad de editar de una columna.
     */
    private final boolean [] tableColums = {false, false, false, false, false, false,
        false, false, false, false, false, false, false, false};
     
    @Override
    public final boolean isCellEditable(int row, int column) {
        
        try {
            return this.tableColums[column];
        } catch (Exception e) {
//            System.out.println(e);
        }
        return false;
    }
    
}

