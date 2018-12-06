/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class updatechoicesinDB {
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/STUDENTS";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "1234";

    void storeit(String name, String select1, String select2, String select3) {
       Connection conn = null;
   Statement stmt = null;
          
            
   try{
     Boolean keepnull=null;
      Class.forName("com.mysql.jdbc.Driver");

      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      
      stmt = conn.createStatement();
      String sql = "INSERT INTO studentchoices (studentname,firstchoice,secondchoice,thirdchoice) "
              + "values ('"+name+"','"+select1+"','"+select2+"','"+select3+"')";
              
     
    
         stmt.executeUpdate(sql);
      
     JOptionPane.showMessageDialog(null, "UPDATED");
   }catch(SQLException se){
     
      se.printStackTrace();
   }catch(Exception ee){
     
      ee.printStackTrace();
   }finally{
      
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }}
        
    } 
    }

   

