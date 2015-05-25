/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.assis.factory;

import br.com.assis.util.ClimedException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author jr
 */
public class TestConnectionManager {
     public static void main(String[] args) throws SQLException, ClimedException {
        try (Connection connection = ConnectionManager.getConexao()) {
            System.out.println("Conexão aberta!");
        }
    }
}
