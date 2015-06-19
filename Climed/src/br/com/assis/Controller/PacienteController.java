/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.assis.Controller;
import br.com.assis.model.Paciente;
import br.com.assis.facade.PacienteFacade;
import br.com.assis.util.ClimedException;
import java.util.List;

/**
 *
 * @author jr
 */
public class PacienteController {
    private PacienteFacade facade;
    
    public PacienteController(){
        this.facade = new PacienteFacade();
    }
    
    public int salvar_paciente(Paciente paciente) throws ClimedException{
        return facade.salvar_paciente(paciente);
     }
    
    public List<Paciente> getAllPaciente() throws ClimedException{
        return facade.getAllPaciente();
    }
    
    public Paciente getPacienteById(int pac_id) throws ClimedException{
        return facade.getPacienteById(pac_id);
    }
    
}
