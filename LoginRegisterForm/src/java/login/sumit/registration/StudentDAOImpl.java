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
public class StudentDAOImpl implements StudentDAO{
    
    static Connection conn;
    static PreparedStatement p;
    
    @Override
    public int addStudent(Student s){
        int status = 0;
        
        try{
            conn = ConnectionProvider.getCon();
            //the mysql insert statement
            String query = "insert into students values(?,?,?,?,?)";
            p = conn.prepareStatement(query);
            p.setString(1, s.getUsername());
            p.setString(2, s.getFirstName());
            p.setString(3, s.getLastName());
            p.setString(4, s.getEmail());
            p.setString(5, s.getPassword());
            
            status = p.executeUpdate();
            conn.close();
        }catch(Exception e){
            System.out.println(e);
        }
        
        return status;
    }
    
    @Override
    public Student getStudent(String username){
        
        Student s = new Student();
        
        try{
             conn = ConnectionProvider.getCon();
             //the mysql select statement
             p = conn.prepareStatement("SELECT * FROM login_register_db.students where username=?");
             p.setString(1, username);
             
             
             ResultSet rs = p.executeQuery();
             while (rs.next()){
                 s.setUsername(rs.getString(1));
                 s.setFirstName(rs.getString(2));
                 s.setLastName(rs.getString(3));
                 s.setEmail(rs.getString(4));
                 s.setPassword(rs.getString(5));
             }
        }catch(Exception e){
            System.out.println(e);
        }
        return s;
    }
    
    @Override
    public int delStudent(Student s){
        int status = 0;
        
        try{
            conn = ConnectionProvider.getCon();
           
            //String query = "DELETE FROM student WHERE username=? AND password=?";
            p = conn.prepareStatement("DELETE FROM students WHERE username=? AND password=?");
            p.setString(1, s.getUsername());
            p.setString(2, s.getPassword());
            
            status = p.executeUpdate();
            conn.close();
        }catch(Exception e){
            System.out.println(e);
        }
        
        return status;
    }
    
}
