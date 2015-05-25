/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.assis.dao;

import java.io.IOException;
import java.util.List;

import br.com.assis.model.Paciente;
//import br.com.assis.dao.IPacienteDao;
//import br.com.assis.dao.PacienteDaoImpl;
import br.com.assis.util.ClimedException;
import br.com.assis.util.Teclado;

/**
 *
 * @author jr
 */
public class TestePacienteDao {
    
    public static IPacienteDao dao = new PacienteDaoImpl();
    
    /**
     * Este metodo e reponsavel pela montagem do menu de opçoes do usuario: INSERIR | REMOVER | LISTAR | FINALIZAR
     */
    public static void montaMenu() {
        System.out.println("-------------------------");
        System.out.println("INSERIR NOVO PACIENTE        : 1");
        System.out.println("REMOVER PACIENTE  PAC_TELCEL : 2");
        System.out.println("LISTAR PACIENTE              : 3");
        System.out.println("BUSCAR PACIENTE   PAC_TELCEL : 4");
        System.out.println("BUSCAR PACIENTE   PAC_ID     : 5");
        System.out.println("FINALIZAR                    : 0");
        System.out.println("-------------------------");
        System.out.print("ESCOLHA A OPERACAO: ");
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
     * Este metodo e reponsavel por ler um cliente digitado pelo usuario, fazendo todas as "perguntas / interaçoes"
     * necessarias para obtençao dos dados digitados.
     * @return 
     */
    public static Paciente lePaciente() {
        // Leitura dos dados do Cliente do teclado
        Paciente paciente = null;
        try {
            System.out.print("Nome do paciente: ");
            // Leitura do nome
            String pac_nome = Teclado.le();
            System.out.print("end do paciente: ");
            // Leitura do telefone
            String pac_end = Teclado.le();
            System.out.print("pac_telcel do paciente : ");
            // Leitura do pac_telcel
            String pac_telcel = Teclado.le();
            int pac_id = 0;
            paciente = new Paciente(pac_id, pac_nome, pac_telcel, pac_end);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // retorna o Cliente lido
        return paciente;
    }
    
    /**
     * Este metodo e reponsavel por ler o ID de um cliente digitado pelo usuario, fazendo todas as "perguntas /
     * interaçoes" necessarias para obtençao dos dados
     * @return 
     */
    public static String lePacTelCelPaciente() {
        // Leitura do pac_telcel do Paciente a ser removido
        String pac_telcel = "";        
        try {
            // O pac_telcel deve obrigatoriamente ser uma String, por isto criamos um
            // while
            // enquanto o usuario nao digitar um inteiro
            while (pac_telcel.equals("")) {
                System.out.print("pac_telcel do Paciente : ");
                String strPacTelCel = Teclado.le();
                // Se o strPacTelCel e valido, interrompemos o while
                if (strPacTelCel != null && strPacTelCel.length() > 0) {
                    pac_telcel = strPacTelCel;
                } // end if
            } // end while
        } catch (Exception e) {
            e.printStackTrace();
        }
        // retorna o Paciente lido
        return pac_telcel;
    }
    

     public static void listarPaciente(List paciente) {
        if (paciente != null) {
            for (int i = 0; i < paciente.size(); i++) {
                System.out.println(((Paciente) paciente.get(i)));
            }
        }
    }
     
     /**
     * Este metodo executa uma tarefa de acordo com a operaçao passada como parametro.
     * @param operacao
     * @throws br.com.assis.util.ClimedException
     */
    public static void executarTarefa(int operacao) throws ClimedException {
    	String pactelcel = null;
    	Paciente paciente = null;
    	
        switch (operacao) {
        case 1:
            System.out.println("Inserindo paciente");
            paciente = lePaciente();
            dao.salvar(paciente);
            break;
        case 2:
            pactelcel = lePacTelCelPaciente();
            dao.excluir(pactelcel);
            break;
        case 3:
            System.out.println("Listando paciente");
            List pacientes = dao.getAllPaciente();
            listarPaciente(pacientes);
            break;
        case 4:
        	System.out.println("Buscando paciente por pac_telcel");
        	pactelcel = lePacTelCelPaciente();
        	paciente = dao.getPacienteByCel(pactelcel);
        	if (paciente != null)
        		System.out.println(paciente);
        	else
        		System.out.println("pac_telcel nao encontrado!");
        }
    }
    
    /**
     *
     * @param args
     * @throws ClimedException
     */
    public static void main(String[] args) throws ClimedException {
        int TERMINAR = 0;
        int operacao = 1;
        do {
            try {
                montaMenu();
                operacao = leOperacao();
                if (operacao == TERMINAR) {
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
