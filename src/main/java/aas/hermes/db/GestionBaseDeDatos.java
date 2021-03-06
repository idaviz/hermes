/*
 * 
 */
package aas.hermes.db;

/**
 * Paquete con métodos para el acceso a la base de datos del proyecto.
 * @author dgarcia25
 */
import java.sql.Connection; 
import java.sql.ResultSet; 
import java.sql.Statement;

/**
 * Clase con los métodos necesarios para establecer el acceso a los datos de la base de datos
 * @author David
 */
public class GestionBaseDeDatos 
{ 
       // Permite cerrar un resultset 
 
    /**
     * Método para cerrar un objeto ResultSet
     * @param resultado ResultSet en estado cerrado.
     */
           public static void closeResulset(ResultSet resultado) 
       { 
              if(resultado!=null) 
              { 
                     try 
                     { 
                            resultado.close(); 
                     }

                     catch(Exception e) 
                     { 
                            System.out.println("Error en el cierre de la conexión de un resultset"); 
                     } 
              } 
       }

       // Cierre de una consulta 
 
    /**
     * Método que permite cerrar un objeto de tipo Statement.
     * @param consulta Objeto tipo Statement.
     */
           public static void closeRequest(Statement consulta) 
       { 
              if(consulta!=null) 
              { 
                      try 
                      { 
                            consulta.close(); 
                      } 
                      catch(Exception e) 
                      { 
                            System.out.println("Error en el cierre de una consulta"); 
                      } 
               } 
       }

       // Cierre de una conexión 
 
    /**
     * Método para cerrar una conexión a la base de datos.
     * @param connection Objeto del tipo Connection.
     */
           public static void closeConnection(Connection connection) 
       { 
               if(connection!=null) 
               { 
                      try 
                      { 
                             connection.close(); 
                      }

                     catch(Exception e) 
                     { 
                             System.out.println("Error en el cierre de una conexión"); 
                      } 
                } 
        } 
}