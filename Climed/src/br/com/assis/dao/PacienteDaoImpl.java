/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.assis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.assis.model.Paciente;
import br.com.assis.util.ClimedException;
import br.com.assis.factory.ConnectionManager;

/**
 *
 * @author jr
 */
public class PacienteDaoImpl implements IPacienteDao {
    
     private final static String CREATE_TABLE = "CREATE TABLE  IF NOT EXISTS  tblpaciente (\n" +
                                                "  pac_id bigint(20) NOT NULL AUTO_INCREMENT,\n" +
                                                "  pac_nome varchar(60) DEFAULT NULL,\n" +
                                                "  pac_telcel varchar(15) DEFAULT NULL,\n" +
                                                "  pac_telres varchar(15) DEFAULT NULL,\n" +
                                                "  pac_telcom varchar(15) DEFAULT NULL,\n" +
                                                "  pac_telrec varchar(50) DEFAULT NULL,\n" +
                                                "  pac_end varchar(50) DEFAULT NULL,\n" +
                                                "  pac_bai varchar(40) DEFAULT NULL,\n" +
                                                "  pac_cid varchar(40) DEFAULT NULL,\n" +
                                                "  pac_uf char(2) DEFAULT NULL,\n" +
                                                "  pac_cep varchar(9) DEFAULT NULL,\n" +
                                                "  pac_rg varchar(20) DEFAULT NULL,\n" +
                                                "  pac_nasc date DEFAULT NULL,\n" +
                                                "  pac_prof varchar(50) DEFAULT NULL,\n" +
                                                "  pac_estcivil int(11) DEFAULT NULL,\n" +
                                                "  pac_resp varchar(50) DEFAULT NULL,\n" +
                                                "  pac_email varchar(60) DEFAULT NULL,\n" +
                                                "  pac_conv bigint(20) DEFAULT NULL,\n" +
                                                "  pac_cart varchar(30) DEFAULT NULL,\n" +
                                                "  pac_obs text,\n" +
                                                "  pac_ultatend datetime DEFAULT NULL,\n" +
                                                "  pac_Indicacao varchar(50) DEFAULT NULL,\n" +
                                                "  pac_PriConsulta date DEFAULT NULL,\n" +
                                                "  pac_ep varchar(200) DEFAULT NULL,\n" +
                                                "  pac_hd varchar(200) DEFAULT NULL,\n" +
                                                "  pac_cd varchar(200) DEFAULT NULL,\n" +
                                                "  pac_consulta float DEFAULT NULL,\n" +
                                                "  pac_HPMA varchar(200) DEFAULT NULL,\n" +
                                                "  pac_OBSmed text,\n" +
                                                "  pac_QD varchar(200) DEFAULT NULL,\n" +
                                                "  PRIMARY KEY (pac_id)\n" +
                                                ")";
    private final static String SALVAR_PACIENTE      = "INSERT INTO tblpaciente (pac_nome, pac_telcel, pac_end) VALUES (?,?,?);";
    private final static String UPDATE_PACIENTE      = "UPDATE tblpaciente SET pac_nome = ? WHERE pac_id =?;";
    private final static String DELETE_PACIENTE      = "DELETE FROM tblpaciente WHERE pac_telcel = '";
    private final static String GET_ALL_PACIENTES    = "SELECT pac_id, pac_nome, pac_telcel, pac_end FROM tblpaciente limit 25;";
    private final static String GET_PACIENTE_BY_CEL  = "SELECT pac_id, pac_nome, pac_telcel, pac_end FROM tblpaciente WHERE pac_telcel = ?";
    
    private final static String GET_PACIENTE_BY_ID  = "SELECT pac_id, pac_nome, pac_telcel, pac_end FROM tblpaciente WHERE pac_id = ?";

    public void createTable() throws ClimedException {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = ConnectionManager.getConexao();
			stmt = conn.createStatement();
			stmt.executeUpdate(CREATE_TABLE);
		} catch (SQLException e) {
			throw new ClimedException(
					"Erro ao criar a tabela de clientes : " + CREATE_TABLE, e);
		} finally {
			ConnectionManager.closeAll(conn, stmt);
		}
	}
    @Override
    public void excluir(String pac_telcel) throws ClimedException {
		Connection conn = null;
		Statement stmt = null;
		try {
			// Abertura da conexao
			conn = ConnectionManager.getConexao();
			// Criacao do Statement
			stmt = conn.createStatement();
			// Execucao da query
			int numeroLinhas = stmt.executeUpdate(DELETE_PACIENTE + pac_telcel + "'");
			// Impressao do numero de linhas alteradas
			System.out.println("Numero de pacientes excluidos: " + numeroLinhas);
		} catch (SQLException e) {
			throw new ClimedException("Erro ao excluir paciente: "
					+ DELETE_PACIENTE, e);
		} finally {
			// Fechamento da Connection e Statement
			ConnectionManager.closeAll(conn, stmt);
		}
	}

    
    @Override
    public void salvar(Paciente paciente) throws ClimedException {
        Connection conn = null;
		PreparedStatement stmt = null;
		try {
			// Abertura da conexao
			conn = ConnectionManager.getConexao();
			// Criacao da PreparedStatement
			stmt = conn.prepareStatement(SALVAR_PACIENTE);
			// Atribuicao de uma String para a 1a. interrogacao (nome)
			stmt.setString(1, paciente.getPac_nome());
			// Atribuicao de uma String para a 3a. interrogacao ()
			stmt.setString(2, paciente.getPac_telcel());
			// Atribuicao de uma String para a 2a. interrogacao ()
			stmt.setString(3, paciente.getPac_end());
			// Executar a operacao de gravar os dados na base
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new ClimedException(
					"Nao foi possivel salvar o cliente na base de dados.", e);
		} finally {
			// Fechamento da Connection e Statement
			ConnectionManager.closeAll(conn, stmt);
		}
        
    }
   

    @Override
    public List getAllPaciente() throws ClimedException {
        // Criacao da lista para armazenar os clientes
		ArrayList paciente = new ArrayList();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// Abertura da conexao
			conn = ConnectionManager.getConexao();
			// Criacao do statement
			stmt = conn.createStatement();
			// Execucao da consulta
			rs = stmt.executeQuery(GET_ALL_PACIENTES);
			// Leitura do ResultSet
			while (rs.next()) {
				// leitura dos dados retornados
				int pac_id = rs.getInt("pac_id");
				String pac_nome = rs.getString("pac_nome");
				String pac_telcel = rs.getString("pac_telcel");
				String pac_end = rs.getString("pac_end");
				// criacao do cliente
				Paciente p = new Paciente(pac_id, pac_nome, pac_telcel, pac_end);
				// adicao do cliente na lista
				paciente.add(p);
			}
			return paciente;
		} catch (SQLException e) {
			throw new ClimedException(
					"Nao foi possivel recuperar os clientes da base de dados.",
					e);
		} finally {
			// Fechamento da Connection, Statement e ResultSet
			ConnectionManager.closeAll(conn, stmt, rs);
		}
        
    }

    @Override
    public Paciente getPacienteByCel(String pac_telcel) throws ClimedException {
                Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Paciente paciente = null;
		try {
			// Abertura da conexao
			conn = ConnectionManager.getConexao();
			// Criacao do PreparedStatement
			stmt = conn.prepareStatement(GET_PACIENTE_BY_CEL);
			// Atribuicao de uma String para a 1a. interrogacao (pac_telcel)
			stmt.setString(1, pac_telcel);
			// Execucao do PreparedStatement
			rs = stmt.executeQuery();
			// Leitura do ResultSet com geracao de um objeto Cliente
			while (rs.next()) {
				paciente = new Paciente(rs.getInt("pac_id"),
                                                        rs.getString("pac_nome"),
                                                        rs.getString("pac_telcel"),
                                                        rs.getString("pac_end"));
			}
		} catch (SQLException e) {
			throw new ClimedException(
					"Nao foi possivel encontrar o cliente na base de dados.", e);
		} finally {
			// Fechamento da Connection, Statement e ResultSet
			ConnectionManager.closeAll(conn, stmt, rs);
		}
		// Retorna os valores para o metodo
		return paciente;
	}
    
       public Paciente getPacienteById(int pac_id) throws ClimedException {
                Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Paciente paciente = null;
                try {
			// Abertura da conexao
			conn = ConnectionManager.getConexao();
			// Criacao do PreparedStatement
			stmt = conn.prepareStatement(GET_PACIENTE_BY_ID);
			// Atribuicao de uma int para a 1a. interrogacao (pac_id)
			stmt.setInt(1, pac_id);
			// Execucao do PreparedStatement
			rs = stmt.executeQuery();
			// Leitura do ResultSet com geracao de um objeto Cliente
			while (rs.next()) {
				paciente = new Paciente(rs.getInt("pac_id"),
                                                        rs.getString("pac_nome"),
                                                        rs.getString("pac_telcel"),
                                                        rs.getString("pac_end"));
			}
		} catch (SQLException e) {
			throw new ClimedException(
					"Nao foi possivel encontrar o cliente na base de dados.", e);
		} finally {
			// Fechamento da Connection, Statement e ResultSet
			ConnectionManager.closeAll(conn, stmt, rs);
		}
                return paciente;
         }
    
    }
    
