/*
 * 
 */
package aas.hermes;

/**
 * Paquete con métodos para la gestión de la conexión a la base de datos.
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
 * Inicializa la conexión con la base de datos
 * @author David
 */
public class ApplicationListener implements 
ServletContextListener{

       Context context=null;

       //función llamada durante la creación del iniciador 

    /**
     * Accede al contexto de la conexión a la base de datos.
     * @param servletContextEvent
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
                             System.out.println("No hay DataSource para el proyecto: hermes"); 
                      } 
                      else 
                      { 
                              System.out.println("DataSource: ¡hermes cargado!"); 
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
     * Cierra el contexto de acceso a la base de datos.
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
