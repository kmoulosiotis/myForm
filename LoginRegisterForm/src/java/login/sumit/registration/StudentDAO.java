/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.sumit.registration;

/**
 *
 * @author Kostas
 */
public interface StudentDAO {
    
    public int addStudent(Student c);
    public Student getStudent(String username);
    public int delStudent(Student c);
}
