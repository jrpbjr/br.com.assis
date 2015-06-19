/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.assis.facade;
import br.com.assis.dao.IPacienteDao;
import br.com.assis.dao.PacienteDaoImpl;
import br.com.assis.model.Paciente;
import br.com.assis.util.ClimedException;
import java.util.List;

/**
 *
 * @author jr
 */
public class PacienteFacade {
    private IPacienteDao dao;
    
    /**
     *
     */
    public PacienteFacade(){
        this.dao = new PacienteDaoImpl(); 
    }
    
    public int salvar_paciente(Paciente paciente) throws ClimedException{
        return dao.salvar_paciente(paciente);
     }
    
    public List<Paciente> getAllPaciente() throws ClimedException{
        return dao.getAllPaciente();
    }
    
    public Paciente getPacienteById(int pac_id) throws ClimedException{
         return dao.getPacienteById(pac_id);
    }
     
}
