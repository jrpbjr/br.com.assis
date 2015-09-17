/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.assis.dao;

import br.com.assis.factory.ConnectionManager;
import br.com.assis.model.Especialidade;
import br.com.assis.util.ClimedException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jr
 */
public class EspecialidadeDaoImpl implements IEspecialidadeDao{
    
    private final static String SALVAR_ESPECIALIDADE        = "INSERT INTO tblespecialidade(esp_nome) VALUES (UPPER(?))";
    private final static String UPDATE_ESPECIALIDADE_ID     = "UPDATE tblespecialidade SET esp_nome = ? WHERE esp_id = '";
    private final static String DELETE_ESPECIALIDADE_ID     = "DELETE FROM tblespecialidade WHERE esp_id = '";  
    private final static String GET_ALL_ESPECIALIDADES      = "SELECT esp_id, esp_nome FROM tblespecialidade LIMIT 25;";
    private final static String FIND_ESPECIALIDADE          = "SELECT esp_id, esp_nome FROM tblespecialidade WHERE UPPER(esp_nome) = UPPER(?)";
            
    
    
    
    @Override
    public List getAllEspecialidade() throws ClimedException {
        // Criação da lista para armazenar as especialidades
        ArrayList especialidade = new ArrayList();
        Connection      conn = null;
        Statement       stmt = null;
        ResultSet       rs   = null;
        
        try {
            // Abertura da conexao
            conn = ConnectionManager.getConexao();
            // Criação do statement
            stmt = conn.createStatement();
            // Execução da consulta
            rs = stmt.executeQuery(GET_ALL_ESPECIALIDADES);
            // Leitura do resultset
            while (rs.next()) {
                //Leitura dos dados retornados
                int     esp_id      = rs.getInt("esp_id");
                String  esp_nome    = rs.getString("esp_nome");
                // criação da especialidade
                Especialidade esp = new Especialidade(esp_id, esp_nome);
                // adição da especialidade na Lista
                especialidade.add(esp);
            }
            return especialidade;
        } catch (SQLException e){
            throw new ClimedException("Nao foi possivel recuperar as esoecialidade da base de dados.",e);
        } finally{
            //Fechamento da Connection, Statement e ResultSet
            ConnectionManager.closeAll(conn, stmt, rs);
        }        
        
    }

    @Override
    public int salvar_especialidade(Especialidade especialidade) throws ClimedException {
       Connection        conn = null;
       PreparedStatement stmt = null;
       int result = 0;
       
       try {
           // Abertura da conexão
           // primeiro label esp_nome
           conn = ConnectionManager.getConexao();
           // Criação da PreparedStatement
           stmt = conn.prepareStatement(SALVAR_ESPECIALIDADE);
           // Atribuição de uma String para a 1a. interrogação (esp_nome)
           stmt.setString(1, especialidade.getEsp_nome());
           // Executar a operação de gravar os dados na base
           result = stmt.executeUpdate();
       }catch(SQLException e){
           throw new ClimedException("Nao foi possivel salvar a especialidade na base de dados.", e);
       }finally{
           //Fechamento da Connection e Statement
           ConnectionManager.closeAll(conn, stmt);
       }
       
       return result;
    }

    @Override
    public void atualizar_especialidade_id(int esp_id, Especialidade especialidade) throws ClimedException {
        Connection          conn = null;
        PreparedStatement   stmt = null;
        
        try {
            //Abertura da conexão
            conn = ConnectionManager.getConexao();
            //Criação da PrepareStatement
            stmt = conn.prepareStatement(UPDATE_ESPECIALIDADE_ID + esp_id + "'");
            // Atribuição de uma String para 1a. interrogação (nome especialidade)
            stmt.setString(1, especialidade.getEsp_nome());
            // Executar a operação de gravar os dados na base
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ClimedException("Nao foi possivel salvar a especialidade na base de dados.", e);
        }finally{
            //fechamento da Connection e Statement
            ConnectionManager.closeAll(conn, stmt);
        }
    }

    @Override
    public void excluir_especialidade_id(int esp_id) throws ClimedException {
        Connection  conn     = null;
        Statement   stmt     = null;
        
        try{
            // Abertura da conexão
            conn    = ConnectionManager.getConexao();
            // Criação do Statement
            stmt    = conn.createStatement();
            // Execução da query
            int numeroLinhas    = stmt.executeUpdate(DELETE_ESPECIALIDADE_ID + esp_id + "'");
            // Impressão do numero de linhas alteradas
            System.out.println("Numero de especialidade excluidas: " + numeroLinhas);
        } catch (SQLException e) {
            throw new ClimedException ("Erro ao excluir especialidade: " 
                    + DELETE_ESPECIALIDADE_ID, e );
        }finally{
            // Fechamento da Connection e Statement
            ConnectionManager.closeAll(conn, stmt);
        }
        
    }       

     @Override
    public List findAllEspecialidade(String espNome) throws ClimedException {
        // Criação da lista para armazenar as especialidades
        ArrayList especialidade = new ArrayList();
        Connection              conn = null;
        PreparedStatement       stmt = null;
        ResultSet               rs   = null;
        
        try {
            // Abertura da conexao
	  conn = ConnectionManager.getConexao();
	    // Criacao do PreparedStatement
	   stmt = conn.prepareStatement(FIND_ESPECIALIDADE);
	    
           // Atribuicao de uma String para a 1a. interrogacao (pac_telcel)
	   stmt.setString(1, espNome);
	   // Execucao do PreparedStatement
	   rs = stmt.executeQuery();
           
            // Leitura do resultset
            while (rs.next()) {
            //Leitura dos dados retornados
            int     esp_id      = rs.getInt("esp_id");
            String  esp_nome    = rs.getString("esp_nome");
            // criação da especialidade
            Especialidade esp = new Especialidade(esp_id, esp_nome);
            // adição da especialidade na Lista
            especialidade.add(esp);
            }
           
        } catch (SQLException e){
            throw new ClimedException("Nao foi possivel recuperar as esoecialidade da base de dados.",e);
        } finally{
            //Fechamento da Connection, Statement e ResultSet
            ConnectionManager.closeAll(conn, stmt, rs);
        }        
         return especialidade;
    }
    
}
