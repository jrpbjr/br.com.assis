/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.assis.model;

import java.util.Objects;

/**
 *
 * @author jr
 */
public class Especialidade {
    private int     esp_id;
    private String  esp_nome;

        
    

    public Especialidade(int esp_id, String esp_nome) {
        this.esp_id = esp_id;
        this.esp_nome = esp_nome;
    }

   
    
    public int getEsp_id() {
        return esp_id;
    }

    public String getEsp_nome() {
        return esp_nome;
    }

    public void setEsp_id(int esp_id) {
        this.esp_id = esp_id;
    }

    public void setEsp_nome(String esp_nome) {
        this.esp_nome = esp_nome;
    }

    @Override
    public String toString() {
        return "Especialidade{" + "esp_id=" + esp_id + ", esp_nome=" + esp_nome + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.esp_nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Especialidade other = (Especialidade) obj;
        return Objects.equals(this.esp_nome, other.esp_nome);
    }
    
    
    
    
}
