/*
 * 
 */
package aas.hermes.dao.model;

/**
 *
 * @author dgarcia25
 */
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletContext;
import javax.sql.DataSource;
import org.apache.struts2.ServletActionContext;

// Clase de conexión 

/**
 * @author dgarcia25
 */
public class ModelDAO implements DAO {

    DataSource dataSource = null;

    // Recuperar una conexión 
    @Override
   /**
    * Establece una conexión con la fuente de datos.
    */
    public Connection getConnection() {
        ServletContext servletContext = ServletActionContext.getServletContext();
        if (this.dataSource == null) {

            dataSource = (DataSource) servletContext.getAttribute("dataSource");
        }
        Connection connection = null;
        if (dataSource != null) {
            try {
                connection = dataSource.getConnection();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        // devolver la conexión 
        return connection;
    }

    // Posicionar una dataSource 

    /**
     * @param dataSource
     */
        public void setConnection(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
