/*
 * Created by me and myself.
 */
package aas.hermes.dao.model;
/**
 *
 * @author David
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import aas.hermes.db.GestionBaseDeDatos;
import aas.hermes.dao.javabeans.User;
import java.sql.SQLException;

public class ModelUserDAO extends ModelDAO {

    Connection conexion = null;
    ResultSet resultado = null;
    
    public User getUser(String idUser) {
        
        System.out.println("idUser que se quiere buscar en la tabla tb_user >> "+idUser);
        // Variables 
        PreparedStatement consulta = null;
        User user = null;
        String consultaString = null;

        try {
            // Apertura de una conexión 
            conexion = super.getConnection();
            // Creación de la consulta 
            consultaString = "SELECT * FROM tb_user WHERE user=?";
            // Se prepara la consulta
            consulta = conexion.prepareStatement(consultaString);
    
            consulta.setString(1, idUser);
    System.out.println(consulta);
            // Ejecución de la consulta 
            resultado = consulta.executeQuery();
            // Se almacena el resultado en el objeto usuario 
            if (resultado != null) {
                if (resultado.next()) {
                    // Se realiza el mapping de los atributos con los campos de la tabla SQL 
                    user = mapperUser(resultado);
                }
            }
        } catch (Exception e) {
            user = null;
            System.err.println("Error en la consulta en la clase ModelUserDAO función getUser");
            e.printStackTrace();
        } finally {
            try {
                // Cierre de la conexión 
                if (resultado != null) {

                    GestionBaseDeDatos.closeResulset(resultado);
                }
                if (consulta != null) {

                    GestionBaseDeDatos.closeRequest(consulta);
                }
                if (conexion != null) {

                    GestionBaseDeDatos.closeConnection(conexion);
                }
            } catch (Exception ex) {
                System.out.println("Error en el cierre de la conexión con la base de datos en la clase ModelUserDAO función getUser");
            }
        }
        // Devolver objeto usuario 
        return user;
    }

    // Realizar el mapping relacional hacia objeto 
    public User mapperUser(ResultSet resultado) {
        // Variables 
        User user = new User();
        try {
            if (resultado.getString("user") == null) {
                user.setUser("");
            } else {
                user.setUser(resultado.getString("user"));
            }

            if (resultado.getString("password") == null) {
                user.setPassword("");
            } else {
                user.setPassword(resultado.getString("password"));
            }

            if (resultado.getString("role") == null) {
                user.setRole("");
            } else {
                user.setRole(resultado.getString("role"));
            }

        }catch(SQLException e){
            //Si se produce un error durante el mapping de atributos 
            user = null;
            System.out.println("Error en el mapping de atributos de User de la clase ModelUserDAO, función mapperUser");
        }
        // Devolver objeto usuario 
        return user;
    }
}
