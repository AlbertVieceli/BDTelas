/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conector;

import java.sql.*;

/**
 *
 * @author albert
 */
public class BDConect {
     public static Connection conector(){       
        java.sql.Connection conex = null;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/school";	
	String login = "root";
	String senha = "";
         //.............................
         try {
             Class.forName(driver);
             conex = DriverManager.getConnection(url, login, senha);
             return conex;
         } catch (Exception e) {
             System.out.println(e);
             return null;
         }
         
         
     }
}
    

