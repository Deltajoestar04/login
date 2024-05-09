/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.Sguridad.conexxion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author manub
 */
public class MySQLConnection {

    public static Connection get(){
        Connection conexion = null;
       try{
       conexion = DriverManager.getConnection("jdbc:mysql://localhost/seguridaddb?user=root&password=21agosto");
       
       }catch(Exception e){
           System.out.println("Error: "+ e.getMessage());
       }
       return conexion;
        
    }}
