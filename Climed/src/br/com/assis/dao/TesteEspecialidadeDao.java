/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.assis.dao;

import br.com.assis.model.Especialidade;
import br.com.assis.util.ClimedException;
import br.com.assis.util.Teclado;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author jr
 */
public class TesteEspecialidadeDao {
    
    /**
     * Este metodo e reponsavel pela montagem do menu de opçoes do usuario: INSERIR | REMOVER | LISTAR | FINALIZAR
     */
    
    public static IEspecialidadeDao daoEsp = new EspecialidadeDaoImpl();
    
    public static void montaMenu(){
    
        System.out.println("-------------------------");
        System.out.println("INSERIR NOVA ESPECIALIDADE       : 1 ");
        System.out.println("REMOVER ESPECIALIDADE   esp_id   : 2 ");
        System.out.println("LISTAR ESPECIALIDADE             : 3 ");
        System.out.println("BUSCAR ESPECIALIDADE    esp_nome : 4 ");
        System.out.println("BUSCAR ESPECIALIDADE      esp_id : 5 ");
        System.out.println("ATUALIZAR ESPECIALIDADE   esp_id : 6 ");
        System.out.println("FINALIZAR                        : 0 ");
        System.out.println("-------------------------");
        System.out.println("ESCOLHA A OPERAÇÃO: ");
    }    
    
    /**
     * Este metodo e responsavel por retornar a opçao de menu do usuario
     * @return 
     * @throws java.io.IOException
     */
    public static int leOperacao() throws IOException, NumberFormatException {
        // Utiliza o metodo estatico da classe Teclado para ler a opçao digitada
        // pelo usuario
        String op = Teclado.le();
        // Transforma a opçao, que e uma String em int
        int operacao = Integer.parseInt(op);
        return operacao;
    }
    
    /**
     * Este metodo e reponsavel por ler um Especialidade digitado pelo usuario, fazendo todas as "perguntas / interaçoes"
     * necessarias para obtençao dos dados digitados.
     * @return 
     */
    public static Especialidade leEspecialidade() {
        //Leitura dos dados da Especialidade pelo do Teclado
		Especialidade especialidade = null;
	
                try {
                    
                    System.out.println("Nome da Especialidade.: ");
                    //Leitura da especialidade
                    String esp_nome = Teclado.le();
                    int esp_id = 0;
                    especialidade = new Especialidade(esp_id
                                                 ,esp_nome);
                    
                } catch (Exception e) {
                e.printStackTrace();
                }
                //retorno a especialidade lida
                return especialidade;
	}
    
    /**
     * Este metodo e responsavel por ler o esp_nome de um especialidade digitado pelo usuario, fazendo todas as "perguntas /
     * interaçoes" necessarias para obtençao dos dados
     * @return 
     */
	 
    public static String leEspNomeEspecialidade() {
        // Leitura do esp_nome da especialidade a ser removido
        String espnomeesp = "";        
        try {
            // O espnomeesp deve obrigatoriamente ser uma String, por isto criamos um
            // while
            // enquanto o usuario nao digitar um inteiro
            while (espnomeesp.equals("")) {
                System.out.print("esp_nome da Especialidade : ");
                String strEspNomeEsp = Teclado.le();
                // Se o strEspNomeEsp e valido, interrompemos o while
                if (strEspNomeEsp != null && strEspNomeEsp.length() > 0) {
                    espnomeesp = strEspNomeEsp;
                } // end if
            } // end while
        } catch (Exception e) {
            e.printStackTrace();
        }
        // retorna a Especialidade lida
        return espnomeesp;
    }
    
    /**
     * Este metodo e reponsavel por ler o esp_id de um especialidade digitado pelo usuario, fazendo todas as "perguntas /
     * interaçoes" necessarias para obtençao dos dados
     * @return 
     */
    public static String leEspIdEspecialidade() {
        // Leitura do esp_id da Especialidade a ser removido
        String espid = "";        
        try {
            // O esp_id deve obrigatoriamente ser uma String, por isto criamos um
            // while
            // enquanto o usuario nao digitar um inteiro
            while (espid.equals("")) {
                System.out.print("esp_id da Especialidade : ");
                String strEspId = Teclado.le();
                // Se o strEspId e valido, interrompemos o while
                if (strEspId != null && strEspId.length() > 0) {
                    espid = strEspId;
                } // end if
            } // end while
        } catch (Exception e) {
            e.printStackTrace();
        }
        // retorna a especialidade lida
        return espid;
    }
    
          public static void listarEspeciaidade(List especialidade) {
        if (especialidade != null) {
            for (int i = 0; i < especialidade.size(); i++) {
                System.out.println(((Especialidade) especialidade.get(i)));
            }
        }
    }
          
     /**
     * Este metodo executa uma tarefa de acordo com a operaçao passada como parametro.
     * @param operacao
     * @throws br.com.assis.util.ClimedException
     */
    public static void executarTarefa(int operacao) throws ClimedException {
        String espnomeesp           = null;
        String espid                = null;
    	Especialidade especialidade = null;
        
        switch (operacao) {
        
            case 1:
                System.out.println("Inserindo Especialidade");
                especialidade   = leEspecialidade();
                daoEsp.salvar_especialidade(especialidade);
            break;
                
            case 2:
                System.out.println("Deletando Especialidade");
                espid           = leEspIdEspecialidade();               
                daoEsp.excluir_especialidade_id(Integer.parseInt(espid));
           break;      
           
            case 3:
                System.out.println("Listando Especialidade");
                List especialidades = daoEsp.getAllEspecialidade();
                listarEspeciaidade(especialidades);
            break;    
                
            case 4:
                System.out.println("Buscar Especialidade pelo nome");
                
            break;    
                
            case 6:
                System.out.println("Atualizar Especialidade");
                espid           = leEspIdEspecialidade();
                especialidade   = leEspecialidade();
                daoEsp.atualizar_especialidade_id(Integer.parseInt(espid), especialidade);
            break;    
        }
        
    }
    
    public static void main (String[] args) throws ClimedException {
        int TERMINAR   = 0;
        int operacao    = 1;
        do {
            try {
                montaMenu();
                operacao = leOperacao();
                if (operacao == TERMINAR){
                    break;
                } else {
                    executarTarefa(operacao);
                } 
              } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Operacao invalida");
            }
        } while (operacao != TERMINAR);
      
    }
}
