/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class checkuserpass {
  
      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/STUDENTS";


   static final String USER = "root";
   static final String PASS = "1234";
   int c=0;
    int checkDUPLICATEUSERPASS(String user, String pass) throws ClassNotFoundException, SQLException{
         
        Connection conn = null;
   Statement stmt = null;
   
     
   
      Class.forName("com.mysql.jdbc.Driver");

     
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      
      
   
      stmt = conn.createStatement();

      String sql = "SELECT STUDENT_PASSWORD,STUDENT_LOGINUSER  FROM STUDENTINFO"
;      ResultSet rs = stmt.executeQuery(sql);
    
      while(rs.next()){
       
         String olduser = rs.getString("STUDENT_LOGINUSER");
         String oldpass = rs.getString("STUDENT_PASSWORD");
      if(user.equals(olduser)){
          System.out.println("USERNAME ALREADY EXISTS");
          c=1;
      }

      
       
      }
      rs.close();
      if(c==1){
          return 1;
      }
      return 0;
      
}}
