/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;


/**
 *
 * @author camilabarbosa
 */
public class DBManager {

    private DriverManager db;
    
    public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("org.h2.Driver");
            con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
        } catch(Exception e) {
            System.out.print("Error getting connection: " + e.getMessage());
        }
        return con;
    }
    
    public ResultSet query(String sql) {
        ResultSet rs = null;
        
        try{
            Connection con = getConnection();
            if(con != null ) {
                Statement st = (Statement) con.createStatement();
                rs = st.executeQuery(sql); 
                
            }
            
            } catch(Exception e){
                System.out.println("Error executeQueery: " + e );
        }
        return rs;
    }
    
     public  int update(String sql) {
        int result = -1;
        
        try{
            Connection con = getConnection();
            if(con != null ) {
                Statement st = (Statement) con.createStatement();
                result = st.executeUpdate(sql); 
                
            }
            
            } catch(Exception e){
                System.out.println("Error executeQueery: " + e );
        }
        return result;
    }
   
    
}
