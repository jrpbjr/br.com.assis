/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.assis.factory;

/**
 *
 * @author jr
 */
import java.sql.Connection; // conexão SQL para Java
import java.sql.DriverManager; // driver de conexão SQL para Java
import java.sql.SQLException; // classe para tratamento de exceções



public class ConnectionFactory {
     public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/climedsp","root","zeent5775");
        }
        catch(SQLException excecao) {
            throw new RuntimeException(excecao);
        }
    }
}
