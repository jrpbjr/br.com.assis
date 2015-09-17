/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.assis.dao;
import br.com.assis.model.Especialidade;
import br.com.assis.util.ClimedException;
import java.util.List;

/**
 *
 * @author jr
 */
public interface IEspecialidadeDao {
    
   /**
     *
     * @param especialidade
     * @return 
     * @throws ClimedException
     */
    public abstract int salvar_especialidade(Especialidade especialidade) throws ClimedException; 
    
    /**
     *
     * @return
     * @throws ClimedException
     */
    public abstract List getAllEspecialidade() throws ClimedException;
    
    /**
     *
     * @param esp_id
     * @param especialidade
     * @throws ClimedException
     */
	
     public abstract void atualizar_especialidade_id(int esp_id,Especialidade especialidade) throws ClimedException;
     
     /**
     *
     * @param esp_id
     * @throws ClimedException
     */
    public abstract void excluir_especialidade_id(int esp_id) throws ClimedException;
    
    /**
     *
     * @param espNome
     * @return
     * @throws ClimedException
     */
    public List findAllEspecialidade(String espNome) throws ClimedException;
}
