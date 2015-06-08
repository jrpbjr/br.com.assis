/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.assis.table;

import javax.swing.table.AbstractTableModel;
import br.com.assis.model.Paciente;
import java.util.List;

/**
 *
 * @author jr
 */
public class PacienteTableModel extends AbstractTableModel{

    private static final int                      COL_ID = 0;
    private static final int                    COL_NOME = 1;
    private static final int                COL_TELEFONE = 2;
    private static final int COL_DATA_ULTIMO_ATENTIMENTO = 3;
    
    private List<Paciente> valores;

    public PacienteTableModel(List<Paciente> valores) {
        this.valores = valores;
    }

    @Override
    public String getColumnName(int column) {
         String coluna = "";
        switch (column) {
            case COL_ID:
                coluna = "Código";
                break;
            case COL_NOME:
                coluna = "Nome";
                break;
            case COL_TELEFONE:
                coluna = "Telefone";
                break;
            case COL_DATA_ULTIMO_ATENTIMENTO:
                coluna = "Último Atendimento";
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
        } else if (columnIndex == COL_TELEFONE) {
            return String.class;
        } else if (columnIndex == COL_DATA_ULTIMO_ATENTIMENTO) {
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
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Paciente paciente = valores.get(rowIndex);
         if(columnIndex == COL_ID){
            return paciente.getPac_id();
        } else if   (columnIndex == COL_NOME ){
            return paciente.getPac_nome();
        } else if   (columnIndex == COL_TELEFONE){ 
            return paciente.getPac_telcel();
        } else if (columnIndex == COL_DATA_ULTIMO_ATENTIMENTO) {
            return paciente.getPac_ultatend();
        }        
        
        return null;
    }
    
    /**
     *
     * @param row
     * @return
     */
    public Paciente get(int row){
        return valores.get(row);        
    }
}

