/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import java.sql.* ; // for connection c
/**
 * @author mohit karwasra
 */


public class Conn {
    
    Connection c ; // creating connection - connection interface
    Statement s ; // statement interface to run mysql queries in database
    Conn(){
    try{
         Class.forName("com.mysql.cj.jdbc.Driver") ;
         c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem", "root" , "rootMohit") ; // connection string
         s = c.createStatement() ;
       }
    catch (Exception e){
        e.printStackTrace() ;
          }
   }
    
    public static void main(String[] args){
        new Conn() ;
}
}
