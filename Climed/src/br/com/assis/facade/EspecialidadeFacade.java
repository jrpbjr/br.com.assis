/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.assis.facade;
import br.com.assis.dao.IEspecialidadeDao;
import br.com.assis.dao.EspecialidadeDaoImpl;
import br.com.assis.model.Especialidade;
import br.com.assis.util.ClimedException;
import java.util.List;

/**
 *
 * @author jr
 */
public class EspecialidadeFacade {
    private IEspecialidadeDao daoEsp;
    

    public EspecialidadeFacade() {
        this.daoEsp = new EspecialidadeDaoImpl();
    }

    
    public int salvar_especialidade(Especialidade especialidade) throws ClimedException{
        return daoEsp.salvar_especialidade(especialidade);
    }
    
    public List<Especialidade> getAllEspecialidade() throws ClimedException{
        return daoEsp.getAllEspecialidade();
    }

    public EspecialidadeFacade(IEspecialidadeDao daoEsp) {
        this.daoEsp = daoEsp;
    }    
 
    public List findAllEspecialidade(String espNome) throws ClimedException{
        return daoEsp.findAllEspecialidade(espNome);
    }
}
