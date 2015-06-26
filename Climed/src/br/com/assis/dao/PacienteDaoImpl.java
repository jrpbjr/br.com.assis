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
import java.util.Date;

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
    private final static String SALVAR_PACIENTE      = "INSERT INTO tblpaciente (pac_nome, pac_telcel, pac_telres, pac_telcom, pac_telrec, pac_end) VALUES (?,?,?,?,?,?)";
    private final static String UPDATE_PACIENTE      = "UPDATE tblpaciente SET pac_nome = ? WHERE pac_id = '";
    private final static String DELETE_PACIENTE      = "DELETE FROM tblpaciente WHERE pac_telcel = '";
   
    private final static String GET_ALL_PACIENTES    = "SELECT pac_id,"
            + "pac_nome,"
            + "concat('Cel: ',pac_telcel,' Res: ', pac_telres,' Com: ', pac_telcom,' Rec: ', pac_telrec) as pac_telefone,"
            + "pac_telcel, "
            + "pac_telres, "
            + "pac_telcom, "
            + "pac_telrec, "
            + "pac_end, "
            + "pac_bai, "
            + "pac_uf, "
            + "pac_cep, "
            + "pac_rg, "
            + "DATE_FORMAT(pac_nasc,'%d/%m/%Y') as pac_nasc, "
            + "pac_prof, "
            + "pac_estcivil, "
            + "pac_resp, "
            + "pac_email, "
            + "pac_conv, "
            + "pac_cart, "
            + "pac_obs, "
            + "pac_Indicacao, "
            + "DATE_FORMAT(pac_PriConsulta,'%d/%m/%dy') as pac_PriConsulta, "
            + "pac_ultatend "
            + "FROM tblpaciente limit 25";
    
    private final static String GET_PACIENTE_BY_CEL  = "SELECT pac_id, "
            + "pac_nome, "
            + "concat('Cel: ',pac_telcel,' Res: ', pac_telres,' Com: ', pac_telcom,' Rec: ', pac_telrec) as pac_telefone, "
            + "pac_telcel, "
            + "pac_telres, "
            + "pac_telcom, "
            + "pac_telrec, "
            + "pac_end, "
            + "pac_bai, "
            + "pac_uf, "
            + "pac_cep, "
            + "pac_rg, "
            + "DATE_FORMAT(pac_nasc,'%d/%m/%Y') as pac_nasc, "
            + "pac_prof, "
            + "pac_estcivil, "
            + "pac_resp, "
            + "pac_email, "
            + "pac_conv, "
            + "pac_cart, "
            + "pac_obs, "
            + "pac_Indicacao, "
            + "DATE_FORMAT(pac_PriConsulta,'%d/%m/%y') as pac_PriConsulta, "
            + "pac_ultatend "
            + "FROM tblpaciente WHERE pac_telcel = ?";
    
    private final static String GET_PACIENTE_TABLE   = "SELECT pac_id, "
            + "pac_nome, "
            + "concat('Cel: ',pac_telcel,' Res: ', pac_telres,' Com: ', pac_telcom,' Rec: ', pac_telrec) as pac_telefone,"
            + "pac_telcel, "
            + "pac_telres, "
            + "pac_telcom, "
            + "pac_telrec, "
            + "pac_end, "
            + "pac_bai, "
            + "pac_uf, "
            + "pac_cep, "
            + "pac_rg, "
            + "DATE_FORMAT(pac_nasc,'%d/%m/%Y') as pac_nasc, "
            + "pac_prof, "
            + "pac_estcivil, "
            + "pac_resp, "
            + "pac_email, "
            + "pac_conv, "
            + "pac_cart, "
            + "pac_obs, "
            + "pac_Indicacao, "
            + "DATE_FORMAT(pac_PriConsulta,'%d/%m/%y') as pac_PriConsulta, "
            + "pac_ultatend "
            + "FROM tblpaciente limit 25";
    
    private final static String GET_PACIENTE_BY_ID   = "SELECT pac_id, "
            + "pac_nome,"
            + " concat('Cel: ',pac_telcel,' Res: ', pac_telres,' Com: ', pac_telcom,' Rec: ', pac_telrec) as pac_telefone, "
            + "pac_telcel, "
            + "pac_telres, "
            + "pac_telcom, "
            + "pac_telrec, "
            + "pac_end, "
            + "pac_bai, "
            + "pac_uf, "
            + "pac_cep, "
            + "pac_rg, "
            + "DATE_FORMAT(pac_nasc,'%d/%m/%y') as pac_nasc, "
            + "pac_prof, "
            + "pac_estcivil, "
            + "pac_resp, "
            + "pac_email, "
            + "pac_conv, "
            + "pac_cart, "
            + "pac_obs, "
            + "pac_Indicacao, "
            + "DATE_FORMAT(pac_PriConsulta,'%d/%m/%y') as pac_PriConsulta, "
            + "pac_ultatend "
            + "FROM tblpaciente WHERE pac_id = ?";
    
    private final static String DELETE_PACIENTE_ID  = "DELETE FROM tblpaciente WHERE pac_id = '";
    
    public void createTable() throws ClimedException {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = ConnectionManager.getConexao();
			stmt = conn.createStatement();
			stmt.executeUpdate(CREATE_TABLE);
		} catch (SQLException e) {
			throw new ClimedException(
					"Erro ao criar a tabela de paciente : " + CREATE_TABLE, e);
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
    public void excluir_paciente_id(int pac_id) throws ClimedException {
		Connection conn = null;
		Statement stmt = null;
		try {
			// Abertura da conexao
			conn = ConnectionManager.getConexao();
			// Criacao do Statement
			stmt = conn.createStatement();
			// Execucao da query
			int numeroLinhas = stmt.executeUpdate(DELETE_PACIENTE_ID + pac_id + "'");
			// Impressao do numero de linhas alteradas
			System.out.println("Numero de pacientes excluidos: " + numeroLinhas);
		} catch (SQLException e) {
			throw new ClimedException("Erro ao excluir paciente: "
					+ DELETE_PACIENTE_ID, e);
		} finally {
			// Fechamento da Connection e Statement
			ConnectionManager.closeAll(conn, stmt);
		}
	}

     @Override
    public void atualizar_id(int pac_id,Paciente paciente) throws ClimedException {
                Connection conn = null;
		PreparedStatement stmt = null;
		try {
			// Abertura da conexao
			conn = ConnectionManager.getConexao();
			// Criacao da PreparedStatement
			stmt = conn.prepareStatement(UPDATE_PACIENTE + pac_id + "'");
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
					"Nao foi possivel salvar o paciente na base de dados.", e);
		} finally {
			// Fechamento da Connection e Statement
			ConnectionManager.closeAll(conn, stmt);
		}
       }
    
    @Override
    public int salvar_paciente(Paciente paciente) throws ClimedException {
        Connection conn = null;
		PreparedStatement stmt = null;
                int result = 0;
		try {
			// Abertura da conexao
                        //(primeiro) label pac_nome, pac_telcel, pactelres, pac_telcom, pac_telrec, pac_end
			conn = ConnectionManager.getConexao();
			// Criacao da PreparedStatement
			stmt = conn.prepareStatement(SALVAR_PACIENTE);
			// Atribuicao de uma String para a 1a. interrogacao (pac_nome)
			stmt.setString(1, paciente.getPac_nome());
			// Atribuicao de uma String para a 2a. interrogacao (getPac_telcel)
			stmt.setString(2, paciente.getPac_telcel());
			// Atribuicao de uma String para a 3a. interrogacao (pactelres)
                        stmt.setString(3, paciente.getPac_telres());
                        // Atribuicao de uma String para a 4a. interrogacao (pac_telcom)
                        stmt.setString(4, paciente.getPac_telcom());
                        // Atribuição de uma String para a 5a. interrogação (pac_telrec)
                        stmt.setString(5, paciente.getPac_telrec());
                        // Atribuicao de uma String para a 6a. interrogacao (Pac_end)
			stmt.setString(6, paciente.getPac_end());
                        
			// Executar a operacao de gravar os dados na base
			result = stmt.executeUpdate();
                        
		} catch (SQLException e) {
			throw new ClimedException(
					"Nao foi possivel salvar o paciente na base de dados.", e);
		} finally {
			// Fechamento da Connection e Statement
			ConnectionManager.closeAll(conn, stmt);
		}
        return result;
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
				int pac_id          = rs.getInt("pac_id");
				String pac_nome     = rs.getString("pac_nome");
                                String pac_Telefone = rs.getString("pac_Telefone");
				String pac_telcel   = rs.getString("pac_telcel");
                                String pac_telres   = rs.getString("pac_telres");
                                String pac_telcom   = rs.getString("pac_telcom");
                                String pac_telrec   = rs.getString("pac_telrec");
				String pac_end      = rs.getString("pac_end");
                                String pac_bai      = rs.getString("pac_bai");
                                String pac_uf       = rs.getString("pac_uf");
                                String pac_cep      = rs.getString("pac_cep");
                                String pac_rg       = rs.getString("pac_rg");
                                String pac_nasc     = rs.getString("pac_nasc");
                                String pac_prof     = rs.getString("pac_prof");
                                String pac_estcivil = rs.getString("pac_estcivil");
                                String pac_resp     = rs.getString("pac_resp");
                                String pac_email    = rs.getString("pac_email");
                                String pac_conv     = rs.getString("pac_conv");
                                String pac_cart     = rs.getString("pac_cart");
                                String pac_obs      = rs.getString("pac_obs");
                                String pac_Indicacao= rs.getString("pac_Indicacao");
                                String pac_PriConsulta = rs.getString("pac_PriConsulta");
                                String pac_ultatend = rs.getString("pac_ultatend");
                                
				// criacao do cliente
				Paciente p = new Paciente(pac_id,
                                                        pac_nome,
                                                    pac_Telefone,
                                                      pac_telcel,
                                                      pac_telres,
                                                      pac_telcom,
                                                      pac_telrec,
                                                         pac_end,
                                                          pac_uf,
                                                         pac_cep,
                                                          pac_rg,
                                                        pac_nasc,
                                                        pac_prof,
                                                    pac_estcivil,
                                                        pac_resp,
                                                       pac_email,
                                                        pac_conv,
                                                        pac_cart,
                                                         pac_obs,
                                                   pac_Indicacao,
                                                 pac_PriConsulta,
                                                         pac_bai,
                                                    pac_ultatend);
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
                            //pac_telres, pac_telcom, pac_telrec
				paciente = new Paciente(rs.getInt("pac_id"),
                                                        rs.getString("pac_nome"),
                                                        rs.getString("pac_Telefone"),
                                                        rs.getString("pac_telcel"),
                                                        rs.getString("pac_telres"),
                                                        rs.getString("pac_telcom"),
                                                        rs.getString("pac_telrec"),
                                                        rs.getString("pac_end"),
                                                        rs.getString("pac_uf"),
                                                        rs.getString("pac_cep"),
                                                        rs.getString("pac_rg"),
                                                        rs.getString("pac_nasc"),
                                                        rs.getString("pac_prof"),
                                                        rs.getString("pac_estcivil"),
                                                        rs.getString("pac_resp"),
                                                        rs.getString("pac_email"),
                                                        rs.getString("pac_conv"),
                                                        rs.getString("pac_cart"),
                                                        rs.getString("pac_obs"),
                                                        rs.getString("pac_Indicacao"),
                                                        rs.getString("pac_PriConsulta"),
                                                        rs.getString("pac_bai"),
                                                        rs.getString("pac_ultatend"));
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
    
     @Override
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
                                                        rs.getString("pac_Telefone"),
                                                        rs.getString("pac_telcel"),
                                                        rs.getString("pac_telres"),
                                                        rs.getString("pac_telcom"),
                                                        rs.getString("pac_telrec"),
                                                        rs.getString("pac_end"),
                                                        rs.getString("pac_uf"),
                                                        rs.getString("pac_cep"),
                                                        rs.getString("pac_rg"),
                                                        rs.getString("pac_nasc"),
                                                        rs.getString("pac_prof"),
                                                        rs.getString("pac_estcivil"),
                                                        rs.getString("pac_email"),
                                                        rs.getString("pac_resp"),
                                                        rs.getString("pac_conv"),
                                                        rs.getString("pac_cart"),
                                                        rs.getString("pac_obs"),
                                                        rs.getString("pac_Indicacao"),
                                                        rs.getString("pac_PriConsulta"),
                                                        rs.getString("pac_bai"),
                                                        rs.getString("pac_ultatend"));
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
    
