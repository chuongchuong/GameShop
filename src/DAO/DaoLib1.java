/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Hoang Minh
 */
public class DaoLib1 {
    public static Connection connToMySQL(String user, String pass, int port, String databaseName)   {
        String db_url = "jdbc:mysql://localhost:" + port+"/" + databaseName +"?tinyInt1isBit=true";
        Connection conn = null;
        try {        
            conn = DriverManager.getConnection(db_url,user,pass);
        } catch (SQLException ex) { 
            return null;
        }
        return conn;
    }
    
    public static Connection connToSQL(String user, String pass, int port, String databaseName) {
        
        String db_url = "jdbc:sqlserver://localhost:" + port+"; databaseName = " + databaseName + 
                ";encrypt=true;trustServerCertificate=true;" ;
        System.out.println(db_url);
        Connection conn = null; 
        try {
            conn = DriverManager.getConnection(db_url,user,pass);
        } catch (SQLException ex) { 
            return null;
        }
        return conn;
    }
    
    
    public static ResultSet getResultSet(Connection conn, String sqlSentence)
    {
        ResultSet rs  = null;
        try {
            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery(sqlSentence);
        } catch (SQLException ex) {}
        return rs;
    }
    
    
    public static int doAction(Connection conn, String sqlSentence) 
    {   
        int k = 0 ;
        try {
            Statement st =conn.createStatement();      
            k = st.executeUpdate(sqlSentence);
        } catch (SQLException ex) {}
        return k;
    }
}

