/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Util.ClimedException;


/**
 *
 * @author Jose
 */
public class ConnectionManager {
    
    /*
     * 1) Coloque o valor adequado nas constantes DATABASE, USER e PASSWORD 
     * 2) Teste esta classe para garantir que esteja funcionando
     */
    private static final String STR_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE = "nome do database";
    private static final String IP = "academias"; //"192.168.0.1" ;
    private static final String STR_CON = "jdbc:mysql://" + IP + ":3306/" + DATABASE;
    private static final String USER = "usuario banco";
    private static final String PASSWORD = "senha de acesso";
    
    public static Connection getConexao() throws ClimedException {
        Connection conn = null;
        try {
            Class.forName(STR_DRIVER);
            conn = DriverManager.getConnection(STR_CON, USER, PASSWORD);
            System.out.println("[ConnectionManager]: Obtendo conexao");
            return conn;
        } catch (ClassNotFoundException e) {
            String errorMsg = "Driver nao encontrado";
            throw new ClimedException(errorMsg, e);
        } catch (SQLException e) {
            String errorMsg = "Erro ao obter a conexao";
            throw new ClimedException(errorMsg, e);
        }
    }
    
    public static void closeAll(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void closeAll(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (conn != null || stmt != null) {
                closeAll(conn);
            }
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void closeAll(Connection conn, Statement stmt) {
        try {
            if (conn != null) {
                closeAll(conn);
            }
            if (stmt != null) {
                stmt.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
