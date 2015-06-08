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
public class ModeloTabela extends AbstractTableModel {
    
    private ArrayList   linhas  = null;
    private String[]    colunas = null;

    /**
     *
     * @param lin
     * @param col
     */
    public ModeloTabela (ArrayList lin, String[] col){
    
            this.setLinhas(lin);
            this.setColunas(col);
    }

    public ArrayList getLinhas() {
        return linhas;
    }

    public void setLinhas(ArrayList linhas) {
        this.linhas = linhas;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] colunas) {
        this.colunas = colunas;
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
    public String getColumnName(int column){
    return colunas[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object[] linha = (Object[])getLinhas().get(rowIndex);
        return linha[columnIndex];
        
        
    }
    
}
