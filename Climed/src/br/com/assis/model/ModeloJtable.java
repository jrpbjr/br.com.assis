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
 * @author jr DefaultTableModel AbstractTableModel
 */
public class ModeloJtable extends AbstractTableModel{
   
    private ArrayList   linhas  = null;
    private String[]    colunas = null;
    
    public ModeloJtable(ArrayList lin, String[] col){
        setLinhas(lin);
        setColunas(col);     
    
    }

    public ModeloJtable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList getLinhas(){    
        return linhas;
    }
    
    /**
     *
     * @param dados
     */
    public void setLinhas(ArrayList dados){
    
     linhas = dados;
    }
    
    public String[] getColunas(){
    
    return colunas;
    }
    
    public void setColunas(String[] nomes){
        colunas = nomes;
    }
    
    
    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length; 
    }

    @Override
    //int rowIndex(numeros de linhas), int columnIndex(numeros colunas)
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object[] linhas = (Object[])getLinhas().get(rowIndex);
        return linhas[columnIndex];
    }
    
    @Override
    public String getColumnName(int numCol) {
    
        return colunas[numCol];
    }
    
}
