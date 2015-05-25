/*
 * 
 */
package aas.hermes.dao.model;

/**
 *
 * @author dgarcia25
 */
import java.sql.Connection;

/**
 * @author dgarcia25
 */
public interface DAO {

    /**
     * Método para tomar una conexión del pool de conexiones.
     * @return
     */
    public Connection getConnection(); 
}