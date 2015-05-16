/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Util.ClimedException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author jr
 */
public class TestConnection {
    
    public static void main(String[] args) throws SQLException, ClimedException {
        try (Connection connection = ConnectionManager.getConexao()) {
            System.out.println("Conexão aberta!");
        }
    }
    
}
