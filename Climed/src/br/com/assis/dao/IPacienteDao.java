/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.assis.dao;
import  br.com.assis.util.ClimedException;
import  br.com.assis.model.Paciente;
import  java.util.List;
/**
 *
 * @author jr
 */
public interface IPacienteDao {
    
    /**
     *
     * @param paciente
     * @return 
     * @throws ClimedException
     */
    public abstract int salvar_paciente(Paciente paciente) throws ClimedException;
    
    /**
     *
     * @param pac_id
     * @param paciente
     * @throws ClimedException
     */
    public abstract void atualizar_id(int pac_id,Paciente paciente) throws ClimedException;
    
    /**
     *
     * @param pac_telcel
     * @throws ClimedException
     */
    public abstract void excluir(String pac_telcel) throws ClimedException;
    
    /**
     *
     * @param pac_id
     * @throws ClimedException
     */
    public abstract void excluir_paciente_id(int pac_id) throws ClimedException;
    
    /**
     *
     * @return
     * @throws ClimedException
     */
    public abstract List getAllPaciente() throws ClimedException;
    
    /**
     *
     * @param pac_telcel
     * @return
     * @throws ClimedException
     */
    public abstract Paciente getPacienteByCel(String pac_telcel) throws ClimedException;
    
    /**
     *
     * @param pac_id
     * @return
     * @throws ClimedException
     */
    public abstract Paciente getPacienteById(int pac_id) throws ClimedException;
    
    
}
