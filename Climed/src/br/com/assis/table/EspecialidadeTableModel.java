/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.assis.table;

import br.com.assis.model.Especialidade;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jr
 */
public class EspecialidadeTableModel extends AbstractTableModel{

    private static final int                    COL_ID      = 0;
    private static final int                    COL_NOME    = 1;
    private List<Especialidade> valores;

    
    
    public EspecialidadeTableModel(List<Especialidade> valores) {
        this.valores = valores;
    }
    
    @Override
    public String getColumnName(int column){
        String coluna = "";
        switch (column) {
            case COL_ID:
                coluna = "Código";
                break;
            case COL_NOME:
                coluna = "Especialidade";
                break;           
            default:
                throw new IllegalArgumentException("Coluna inválida!");
        }
         return coluna; 
    }
    
     @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == COL_ID) {
            return Long.class;
        } else if (columnIndex == COL_NOME) {
            return String.class;
        }
        return null;
    }
    
    @Override
    public int getRowCount() {
       return valores.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         Especialidade especialidade = valores.get(rowIndex);
         if(columnIndex == COL_ID){
            return especialidade.getEsp_id();
        } else if   (columnIndex == COL_NOME ){
            return especialidade.getEsp_nome();
        }    
        
        return null;
    }
    
    /**
     *
     * @param row
     * @return
     */
    public Especialidade get(int row){
        return valores.get(row);        
    }
    
}
