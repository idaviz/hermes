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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ModelMessageDAO extends ModelDAO {

    Connection conexion = null;
    ResultSet resultado = null;
    private static List<String> flightList;
    private static List<Message> listaResultados;

    /**
     * Devuelve un objeto de la clase Message.
     *
     * @param idMessage Identificador único del bean Message
     * @return Message
     */
    public Message getMessage(int idMessage) {
        // Variables 
        PreparedStatement consulta = null;
        Message message = null;
        String consultaString = null;

        try {
            // Apertura de una conexión 
            conexion = super.getConnection();
            // Creación de la consulta 
            consultaString = "SELECT * FROM tb_messages WHERE Id=?";
            // Se prepara la consulta
            consulta = conexion.prepareStatement(consultaString);
            consulta.setInt(1, idMessage);
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

    public List<String> getFlightList() {
        // Variables 
        PreparedStatement consulta = null;
        Message message = null;
        String consultaString = null;
        flightList = new ArrayList<String>();

        try {
            // Apertura de una conexión 
            conexion = super.getConnection();

            // consulta de lista de vuelos 
            //consultaString = "SELECT DISTINCT tex_flt FROM tb_messages WHERE tex_date=CURDATE() ORDER BY tex_flt";
            consultaString = "SELECT * FROM tb_messages GROUP BY tex_flt";
            consulta = conexion.prepareStatement(consultaString);
            System.out.println(consulta);
            // Ejecución de la consulta 
            resultado = consulta.executeQuery();
System.out.println("Resultado de la consulta >>"+resultado);
            // Se almacena el resultado en una lista 
            if (resultado != null) {
                while (resultado.next()) {
                    // Se efectúa el mapping de los atributos con los campos de la tabla SQL 
                    message = mapperMessage(resultado);
                    // Se añade el objeto a la lista de obrass
                    flightList.add((String) message.getTex_flt());
                }
            }
        } catch (Exception e) {
            System.out.println("Error en la consulta de la clase ModelMessageDAO función getFlightList");
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
                System.out.println("Error en el cierre de la conexion con la base de datos en la clase ModelMessageDAO función getFlightList");
            }
        }

        // Devolver la lista de obras
        System.out.println(flightList);
        return flightList;
    }
    
    
    // devolver la lista de obras 
    public List<Message> getListaResultados(String clave) {
        // Variables 
        PreparedStatement consulta = null;
        Message message = null;
        String consultaString = null;
        listaResultados = new ArrayList<Message>();

        try {
            // Apertura de una conexión 
            conexion = super.getConnection();

            // consulta de lista de obras 
            consultaString = "SELECT * FROM tb_messages WHERE tex_flt LIKE '%" + clave + "%'";

            consulta = conexion.prepareStatement(consultaString);

            // Ejecución de la consulta 
            resultado = consulta.executeQuery();

            // Se almacena el resultado en una lista 
            if (resultado != null) {
                while (resultado.next()) {
                    // Se efectúa el mapping de los atributos con los campos de la tabla SQL 
                    message = mapperMessage(resultado);

                    // Se añade el objeto a la lista de obrass
                    listaResultados.add((Message) message);
                }
            }
        } catch (Exception e) {
            System.out.println("Error en la consulta de la clase ModelMessageDAO función getListaResultados");
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
                System.out.println("Error en el cierre de la conexion con la base de datos en la clase ModelMessageDAO función getListaResultados");
            }
        }

        // Devolver la lista de obras 
        return listaResultados;
    }
    

    // Realizar el mapping relacional hacia objeto 
    public Message mapperMessage(ResultSet resultado) throws ParseException {
        // Variables 
        Message message = new Message();
        try {
            
            if (resultado.getString("smi") == null) {
                message.setSmi("");
            } else {
                message.setSmi(resultado.getString("smi"));
            }

            if (resultado.getString("tex") == null) {
                message.setTex("");
            } else {
                //message.setTex(resultado.getString("tex").replaceAll(" ", "<br/>"));
                message.setTex(resultado.getString("tex").replace("\n\n","<br>"));
            }

            if (resultado.getString("tex_flt") == null) {
                message.setTex_flt("");
            } else {
                message.setTex_flt(resultado.getString("tex_flt"));
            }

            if (resultado.getString("tex_date") == null) {
                message.setTex_date(null);
            } else {
                String fechaOriginal = resultado.getString("tex_date");
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date date = format.parse(fechaOriginal);
                message.setTex_date(date);
            }

            if (resultado.getString("tex_reg") == null) {
                message.setTex_reg("");
            } else {
                message.setTex_reg(resultado.getString("tex_reg"));
            }
            if (resultado.getString("Id") == null) {
                message.setId(0);
            } else {
                message.setId(resultado.getInt("Id"));
            }

        } catch (SQLException e) {
            //Si se produce un error durante el mapping de atributos 
            message = null;
            System.out.println("Error en el mapping de atributos de Message de la clase ModelMessageDAO, función mapperMessage");
            e.printStackTrace();
        }
        // Devolver objeto message 
        return message;
    }

}
