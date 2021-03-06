/*
 * 
 */
package aas.hermes.db;

/**
 *
 * @author dgarcia25
 */
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.servlet.ServletContext; 
import javax.servlet.ServletContextEvent; 
import javax.servlet.ServletContextListener; 
import javax.sql.DataSource;

/**
 * Clase para establecer las conexiones con el pool de conexiones.
 * @author dgarcia25
 */
public class ApplicationListener implements 
ServletContextListener{

       Context context=null;

       

    /**
     * Crea la conexión con el pool.
     * @param servletContextEvent Solicitud de creación.
     */
           @Override
       public void contextInitialized(ServletContextEvent servletContextEvent) 
       { 
              ServletContext servletContext=servletContextEvent.getServletContext(); 
              String dataSourceJNDI=servletContext.getInitParameter("dataSourceJNDI");

              try 
              { 
                      context=new InitialContext(); 
                      DataSource dataSource=(DataSource)context.lookup(dataSourceJNDI); 
                      if(dataSource==null) 
                      { 
                             System.out.println("No hay DataSource para el proyecto: miBiblio"); 
                      } 
                      else 
                      { 
                              System.out.println("DataSource: ¡miBiblio cargado!"); 
                      } 
                      servletContext.setAttribute("dataSource", dataSource); 
               } 
               catch(NamingException e) 
               { 
                      throw new RuntimeException(); 
               } 
               finally 
               { 
                      try 
                      { 
                             //cerrar el contexto 
                             if(context!=null) 
                             { 
                                    context.close(); 
                             } 
                       } 
                       catch(Exception e) 
                       { 
                              System.out.println("¡Error en initCtx!"); 
                       } 
              } 
       }

       //función llamada durante la destrucción del iniciador 

    /**
     * Libera el pool de conexiones.
     * @param servletContextEvent
     */
           @Override
       public void contextDestroyed(ServletContextEvent servletContextEvent) 
       { 
              try 
              { 
                       //cerrar el contexto 
                       if(context!=null) 
                       { 
                              context.close(); 
                       } 
              } 
              catch(Exception e) 
              { 
                     System.out.println("¡Error en initCtx!"); 
              } 
       } 
}
