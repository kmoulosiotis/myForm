/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.sumit.registration;

import java.sql.*;
/**
 *
 * @author Kostas
 */
public class ConnectionProvider {
    static Connection conn = null;
    
    public static Connection getCon(){
        /*try{
            Class.forName("com.mysql.jdbc.Driver");
           // Connection conn=DriverManager.getConnection(connUrl, username, password);
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_register_db", "root", "km698km123");
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }*/
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_register_db", "root", "km698km123");
        }catch(Exception e){
            System.out.println(e);
        }
        return conn;
    }
}
