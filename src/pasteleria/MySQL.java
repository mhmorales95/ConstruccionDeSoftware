/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasteleria;

import java.sql.*;

public class MySQL {
   private static Connection con = null;
   private static final String driver = "com.mysql.jdbc.Driver";
   private static final String usuario = "sayonara";
   private static String pass = "12345678";
   private static final String url = "jdbc:mysql://localhost:3306/amadajm";
   public MySQL(){
       try{
           Class.forName(driver);           
 
           
           con = DriverManager.getConnection(url, usuario, pass);
           if(con != null){
               System.out.println("Conexion establecida");
           }
           
           
       } catch (ClassNotFoundException | SQLException e){
           System.out.println("error" + e);
       }
   }
   
   public Connection getConnection(){
       return con;
   }
   
   
   public void desconectar(){
       con = null;
       if (con == null){
           System.out.println("desconectado");
       }
   }
}