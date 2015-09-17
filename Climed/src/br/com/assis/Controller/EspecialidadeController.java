/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.assis.Controller;
import br.com.assis.facade.EspecialidadeFacade;
import br.com.assis.model.Especialidade;
import br.com.assis.util.ClimedException;
import java.util.List;

/**
 *
 * @author jr
 */
public class EspecialidadeController {
    private EspecialidadeFacade facadeEsp;

    public EspecialidadeController(EspecialidadeFacade facadeEsp) {
        this.facadeEsp = facadeEsp;
    }

    public EspecialidadeController() {
        this.facadeEsp = new EspecialidadeFacade();
    }

          
    public int salvar_especialidade(Especialidade especialidade) throws ClimedException{
        return facadeEsp.salvar_especialidade(especialidade);
    }
    
    public List<Especialidade> getAllEspecialidade() throws ClimedException{
        return facadeEsp.getAllEspecialidade();
    }
  
    public List findAllEspecialidade(String espNome) throws ClimedException{
        return facadeEsp.findAllEspecialidade(espNome);
    }
    
}
