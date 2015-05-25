/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.assis.dao;

//import br.com.assis.factory.ConnectionFactory;
import br.com.assis.factory.ConnectionManager;

import br.com.assis.model.Usuario;
import br.com.assis.util.ClimedException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author jr
 */
public class UsuarioDao {
    private final Connection connection;
    
    Long id;
    String nome;
    String cpf;
    String email;
    String telefone;

    public UsuarioDao() throws ClimedException{
      // this.connection = new ConnectionFactory().getConnection();
       this.connection = ConnectionManager.getConexao();
       
    }

    public void adiciona(Usuario usuario){

        String sql;
        //sql = "INSERT INTO usuario(nmUsuario,nrCpf,nmEmail,nrTelefone) VALUES(?,?,?,?)";
       // sql = "INSERT INTO usuario(nmUsuario,nrCpf,nmEmail) VALUES(?,?,?)";
        sql = "INSERT INTO tblpaciente (pac_nome) VALUES (?)";
        
        try {

            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, usuario.getNome());
               // stmt.setString(2, usuario.getCpf());
              //  stmt.setString(3, usuario.getEmail());
              //  stmt.setString(4, usuario.getTelefone());
                stmt.execute();
            }

        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
}
