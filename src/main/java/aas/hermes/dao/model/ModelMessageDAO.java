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
import aas.hermes.dao.javabeans.Message;
import java.sql.SQLException;

public class ModelMessageDAO extends ModelDAO {

    Connection conexion = null;
    ResultSet resultado = null;

    /**
     * Devuelve un objeto de la clase Message.
     *
     * @param idMessage Identificador único del bean Message
     * @return Message
     */
    public Message getMessage(String idMessage) {
        // Variables 
        PreparedStatement consulta = null;
        Message message = null;
        String consultaString = null;

        try {
            // Apertura de una conexión 
            conexion = super.getConnection();
            // Creación de la consulta 
            consultaString = "SELECT * FROM tb_message WHERE Id=?";
            // Se prepara la consulta
            consulta = conexion.prepareStatement(consultaString);
            consulta.setString(1, idMessage);
            // Ejecución de la consulta 
            resultado = consulta.executeQuery();
            // Se almacena el resultado en el objeto Message 
            if (resultado != null) {
                if (resultado.next()) {
                    // Se realiza el mapping de los atributos con los campos de la tabla SQL 
                    message = mapperMessage(resultado);
                }
            }
        } catch (Exception e) {
            message = null;
            System.err.println("Error en la consulta en la clase ModelMessageDAO función getMessage");
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
                System.out.println("Error en el cierre de la conexión con la base de datos en la clase ModelMessageDAO función getMessage");
            }
        }
        // Devolver objeto usuario 
        return message;
    }

    // Realizar el mapping relacional hacia objeto 
    public Message mapperMessage(ResultSet resultado) {
        // Variables 
        Message message = new Message();
        try {
            if (resultado.getString("Id") == null) {
                message.setId(0);
            } else {
                message.setId(resultado.getInt("Id"));
            }

            if (resultado.getString("smi") == null) {
                message.setSmi("");
            } else {
                message.setSmi(resultado.getString("smi"));
            }
            
            if (resultado.getString("tex") == null) {
                message.setTex("");
            } else {
                message.setTex(resultado.getString("tex"));
            }
            
            if (resultado.getString("tex_flt") == null) {
                message.setTex_flt("");
            } else {
                message.setTex_flt(resultado.getString("tex_flt"));
            }
            
            if (resultado.getString("tex_date") == null) {
                message.setTex_date("");
            } else {
                message.setTex_date(resultado.getString("tex_date"));
            }
            
            if (resultado.getString("tex_reg") == null) {
                message.setTex_reg("");
            } else {
                message.setTex_reg(resultado.getString("tex_reg"));
            }

        } catch (SQLException e) {
            //Si se produce un error durante el mapping de atributos 
            message = null;
            System.out.println("Error en el mapping de atributos de Message de la clase ModelMessageDAO, función mapperMessage");
        }
        // Devolver objeto message 
        return message;
    }

}
