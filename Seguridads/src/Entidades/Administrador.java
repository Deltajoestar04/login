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
 *
 * @author Admin
 */
public class Administrador {
        private int id;
    private String username;
    private String Password;
    private String Puesto;

    public Administrador() {
    }

    public Administrador(int id, String username, String Password, String Puesto) {
        this.id = id;
        this.username = username;
        this.Password = Password;
        this.Puesto = Puesto;
    }
    /**
     * Obtiene una lista de Administradores filtrada por un nombre de usuario.
     * @param filtro Nombre de Administradores o parte de él para filtrar la búsqueda.
     * @return Lista de Administradores que coinciden con el filtro.
     */
public static List<Administrador> getAll(String filtro){
        List<Administrador> Admin = new ArrayList<>();
         try {
            Connection conexion = MySQLConnection.get();
            PreparedStatement statement = conexion.prepareStatement("select * from seguridaddb.administrador where id like ?");
            statement.setString(1, "%"+ filtro +"%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Administrador a = new Administrador();
                a.setId(1);
                a.setUsername(resultSet.getString(2));
                a.setPassword(resultSet.getString(3));
                a.setPuesto(resultSet.getString(4));
                Admin.add(a); // Agrega el Administrador a la lista

            }
        } catch (SQLException e) {
            System.err.print("Error:" + e.getMessage());
        }
        
        return Admin;
    }

/**
     * Crea un nuevo administrador en la base de datos.
     * @param id Identificador único del administrador.
     * @param username Nombre de administrador.
     * @param Password Contraseña del administrador.
     * @param Puesto puesto del administrador.
     * @return true si se crea correctamente, false en caso contrario.
     */
    public static boolean create(int id, String username, String Password, String Puesto) {
        boolean result = false;
        try {
            Connection conexion = MySQLConnection.get();
            String query = "INSERT INTO seguridaddb.administrador(nombre , contraseña , puesto) VALUES(? , ?, ?);";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, Password);
            statement.setString(3, Puesto);
            

            statement.execute();

            result = statement.getUpdateCount() == 1; // Comprueba si se realizó una inserción correctamente

            conexion.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return result;
    }

/**
     * Guarda un nuevo administrador en la base de datos.
     * @param id Identificador único del administrador.
     * @param username Nombre de administrador.
     * @param Password Contraseña del administrador.
     * @param Puesto puesto del administrador.
     * @return true si se crea correctamente, false en caso contrario.
     */   
    public static boolean update(int id, String username, String Password, String Puesto) {
        boolean result = false;
        try {
            Connection conexion = MySQLConnection.get();
            String query = "UPDATE seguridaddb.administrador SET nombre = ?, contraseña = ? , puesto = ?  WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, id);
            statement.setString(2, username);
            statement.setString(3, Password);
            statement.setString(4, Puesto);

            statement.execute();

            result = statement.getUpdateCount() == 1; // Comprueba si se realizó una inserción correctamente

            conexion.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return result;
    }
    
      // Metodo que elimina una de las filas de la tabla administrador.
    /**
     * borrar administrador en la base de datos.
     * @param id Identificador único del administrador.
     * @return true si se crea correctamente, false en caso contrario.
     */   
    public static boolean delete(int id) {
        boolean result = false;
        try {
            Connection conexion = MySQLConnection.get();
            String query = "DELETE from seguridaddb.administrador WHERE id = ?";
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
    public String getPuesto() {
        return Puesto;
    }

    public void setPuesto(String Puesto) {
        this.Puesto = Puesto;
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
    
    
}
