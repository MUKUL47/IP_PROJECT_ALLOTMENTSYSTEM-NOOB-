/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class arrangecgpa {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/STUDENTS";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "1234";
    public static void main(String[] args) {
        arrangecgpa a = new arrangecgpa();
        a.arrangeCGPA();
    }
    public void arrangeCGPA(){
        CGPAINTABLE yo= new CGPAINTABLE();
           Connection conn = null;
   Statement stmt = null;
   try{
  
      Class.forName("com.mysql.jdbc.Driver");

     
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

    
      stmt = conn.createStatement();

      String sql = "SELECT * FROM STUDENTINFO ORDER by STUDENT_CGPA DESC";
     ResultSet rs= stmt.executeQuery(sql);
    int c=0; while(rs.next()){
        String namee=rs.getString("NAME_OF_STUDENT");
         String pass =rs.getString("STUDENT_PASSWORD");
         String login=rs.getString("STUDENT_LOGINUSER");
            int cgpa=rs.getInt("STUDENT_CGPA");
            String cgpa1=Integer.toString(cgpa);
           // yo.list1(namee, login, pass,cgpa1 );
          
//       System.out.println("NAME :"+namee);
//         System.out.println("STUDENT PASSWORD : "+pass);
//         System.out.println("LOGIN USERNAME "+login);
//         System.out.println(" STUDENT CGPA "+cgpa);
     }
      
              
        
                  
        
    
   } catch (SQLException ex) {
         Logger.getLogger(LOGINPAGE_IP1.class.getName()).log(Level.SEVERE, null, ex);
     } catch (ClassNotFoundException ex) {
         Logger.getLogger(LOGINPAGE_IP1.class.getName()).log(Level.SEVERE, null, ex);
     }
   
}}
