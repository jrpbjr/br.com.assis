/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.assis.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jr
 */
public class TableModelPaciente extends AbstractTableModel {
 
    private ArrayList<Paciente> listaDePaciente;
    private String [] colunas = {"pac_id", "pac_nome", "pac_telcel", "pac_telres", "pac_telcom", "pac_telrec", "pac_end"};
    
    public TableModelPaciente(){
    this.listaDePaciente = new ArrayList<>();
    }
    
    public void addPaciente(Paciente pPaciente){
    this.listaDePaciente.add(pPaciente);
    this.fireTableDataChanged();    
    }
    
    public void removerPaciente(int rowIndex){
    this.listaDePaciente.remove(rowIndex);
    this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
       return this.listaDePaciente.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //"pac_id", "pac_nome", "pac_telcel", "pac_telres", "pac_telcom", "pac_telrec", "pac_end"
        switch(columnIndex){
        
            case 0:
                return this.listaDePaciente.get(rowIndex).getPac_id();
            case 1:
                return this.listaDePaciente.get(rowIndex).getPac_nome();
            case 2:
                return this.listaDePaciente.get(rowIndex).getPac_telcel();
            case 3:
                return this.listaDePaciente.get(rowIndex).getPac_telres();
            case 4:
                return this.listaDePaciente.get(rowIndex).getPac_telres();
            case 5:
                return this.listaDePaciente.get(rowIndex).getPac_telcom();
            case 6:
                return this.listaDePaciente.get(rowIndex).getPac_telrec();
            case 7:
                return this.listaDePaciente.get(rowIndex).getPac_end();
                
            default:
                return this.listaDePaciente.get(rowIndex);
            
        }
    }
   @Override
    public String getColumnName(int columnIndex){
        return this.colunas[columnIndex];
    } 

    public void addPaciente(Object[] paci) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
