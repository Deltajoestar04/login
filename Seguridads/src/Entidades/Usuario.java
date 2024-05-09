/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itson.Sguridad.conexxion.MySQLConnection;

/**
 * La clase Usuario modela un usuario con su id, nombre de usuario, contraseña y tarea.
 */
public class Usuario {
     private int id; // Identificador único del usuario
    private String username; // Nombre de usuario
    private String Password; // Contraseña del usuario
    private String Tarea; // Tarea asociada al usuario

     /**
     * Constructor por defecto de la clase Usuario.
     */
    public Usuario() {
    }
 /**
     * Constructor de la clase Usuario que inicializa todos los campos.
     * @param id Identificador único del usuario.
     * @param username Nombre de usuario.
     * @param Password Contraseña del usuario.
     * @param Tarea Tarea asociada al usuario.
     */
    public Usuario(int id, String username, String Password, String Tarea) {
        this.id = id;
        this.username = username;
        this.Password = Password;
        this.Tarea = Tarea;
    }
    /**
     * Obtiene una lista de usuarios filtrada por un nombre de usuario.
     * @param filtro Nombre de usuario o parte de él para filtrar la búsqueda.
     * @return Lista de usuarios que coinciden con el filtro.
     * @throws SQLException Si ocurre un error de SQL.
     */
public static List<Usuario> getAll(String filtro) throws SQLException{
       List<Usuario> usuario = new ArrayList<>();
       try {
              Connection conexion = MySQLConnection.get(); // Obtiene la conexión a la base de datos
            PreparedStatement statement= conexion.prepareStatement("SELECT * FROM seguridaddb.usuario WHERE nombre LIKE ?");
            statement.setString(1, "%"+filtro+"%");
            ResultSet resultSet = statement.executeQuery(); // Ejecuta la consulta SQL
            
         
         while(resultSet.next()){
             Usuario u = new Usuario();
                u.setId(resultSet.getInt(1));
                u.setUsername(resultSet.getString(2));
                u.setPassword(resultSet.getString(3));
                u.setTarea(resultSet.getString(4));
                usuario.add(u); // Agrega el usuario a la lista
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            throw e;
        }
        return usuario;
    }    

    /**
     * Crea un nuevo usuario en la base de datos.
     * @param id Identificador único del usuario.
     * @param username Nombre de usuario.
     * @param Password Contraseña del usuario.
     * @param Tarea Tarea asociada al usuario.
     * @return true si se crea correctamente, false en caso contrario.
     */
public static boolean create(int id, String username, String Password, String Tarea) {
        boolean result = false;
        try {
            Connection conexion = MySQLConnection.get();
            String query = "INSERT INTO seguridaddb.usuario(nombre , contraseña , tarea) VALUES(? , ?, ?);";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, Password);
            statement.setString(3, Tarea);
            

            statement.execute(); // Ejecuta la consulta

             result = statement.getUpdateCount() == 1; // Comprueba si se realizó una inserción correctamente

            conexion.close(); // Cierra la conexión
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return result;
    }

 // Métodos update y delete tienen una estructura similar a create, por lo que no es necesario documentarlos para evitar redundancia.

    /**
     * Guarda un nuevo usuario en la base de datos.
     * @param id
     * @param username
     * @param Password
     * @param Tarea
     * @return true si se guarda correctamente, false en caso contrario.
     */
    public static boolean update(int id, String username, String Password, String Tarea) {
        boolean result = false;
        try {
            Connection conexion = MySQLConnection.get();
            String query = "UPDATE seguridaddb.usuario SET nombre = ?, contraseña = ? , puesto = ?  WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, id);
            statement.setString(2, username);
            statement.setString(3, Password);
            statement.setString(4, Tarea);

            statement.execute();

            result = statement.getUpdateCount() == 1; // Comprueba si se realizó una inserción correctamente

            conexion.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return result;
    }
    
      // Metodo que elimina una de las filas de la tabla usuario.
    /**
     * Guarda un nuevo usuario en la base de datos.
     * @param id
     * @return true si se guarda correctamente, false en caso contrario.
     */
    public static boolean delete(int id) {
        boolean result = false;
        try {
            Connection conexion = MySQLConnection.get();
            String query = "DELETE from seguridaddb.usuario WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, id);
            statement.execute();

            result = statement.getUpdateCount() == 1; // Comprueba si se realizó una inserción correctamente

            conexion.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return result;
    }
  /**
     * Guarda un nuevo usuario en la base de datos.
     * @param nombre
     * @param password
     * @return true si se guarda correctamente, false en caso contrario.
     */  
     
    public boolean guardar(String nombre, String password){
        boolean resultado = false;  
        String tarea = "Usuario";
        try{
            
            String query ="INSERT INTO usuario(nombre, contraseña, tarea) VALUES (?, ?, ?)";
            Connection conexion = MySQLConnection.get();
           
            
            PreparedStatement statement = conexion.prepareStatement(query);
            
             statement.setString(1, nombre);
             statement.setString(2, password);
             statement.setString(3, tarea);
             statement.execute();
            
            resultado = statement.getUpdateCount() == 1; // Comprueba si se realizó una inserción correctamente
              
        }catch(Exception ex){
            System.err.print("Ocurrio un error" + ex.getMessage());
        }
        return resultado;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getTarea() {
        return Tarea;
    }

    public void setTarea(String Tarea) {
        this.Tarea = Tarea;
    }
    
    
          
}
