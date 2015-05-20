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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ModelUserDAO extends ModelDAO {

    Connection conexion = null;
    ResultSet resultado = null;
    private static List<User> listaUsuarios;

    public List<User> getListaUsuarios() {
        // Variables 
        PreparedStatement consulta = null;
        User user = null;
        String consultaString = null;
        listaUsuarios = new ArrayList<>();

        try {
            // Apertura de una conexión 
            conexion = super.getConnection();

            // consulta de lista de obras 
            consultaString = "SELECT * FROM tb_user WHERE 1 ORDER BY user";

            consulta = conexion.prepareStatement(consultaString);

            // Ejecución de la consulta 
            resultado = consulta.executeQuery();

            // Se almacena el resultado en una lista 
            if (resultado != null) {
                while (resultado.next()) {
                    // Se efectúa el mapping de los atributos con los campos de la tabla SQL 
                    user = mapperUser(resultado);

                    // Se añade el objeto a la lista de obrass
                    listaUsuarios.add((User) user);
                }
            }
        } catch (Exception e) {
            System.out.println("Error en la consulta de la clase ModelUserDAO función getListaUsuarios");
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
                System.out.println("Error en el cierre de la conexion con la base de datos en la clase ModelUserDAO función getListaUsuarios");
            }
        }

        // Devolver la lista de obras 
        return listaUsuarios;
    }

    public static void setListaUsuarios(List<User> listaUsuarios) {
        ModelUserDAO.listaUsuarios = listaUsuarios;
    }
    
    
    
    public User getUser(int idUser) {
        // Variables 
        PreparedStatement consulta = null;
        User usuario = null;
        String consultaString = null;
        try {
            // Apertura de una conexión 
            conexion = super.getConnection();
            // Creación de la consulta 
            System.out.println("Voy a realizar un SELECT con el user="+idUser);
            consultaString = "SELECT * FROM tb_user WHERE id_tb_user=?";
            // Se prepara la consulta
            consulta = conexion.prepareStatement(consultaString);
            consulta.setInt(1, idUser);
            // Ejecución de la consulta 
            resultado = consulta.executeQuery();
            // Se almacena el resultado en el objeto usuario 
            if (resultado != null) {
                if (resultado.next()) {
                    // Se realiza el mapping de los atributos con los campos de la tabla SQL 
                    usuario = mapperUser(resultado);
                    System.out.println(usuario.getUser());
                    System.out.println(usuario.getPassword());
                    System.out.println(usuario.getRole());
                }
            }
        } catch (Exception e) {
            usuario = null;
            System.err.println("Error en la consulta en la clase ModelUserDAO función getUser");
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
        return usuario;
    }

    
    public User getUserByUser(String idUser) {
        // Variables 
        PreparedStatement consulta = null;
        User usuario = null;
        String consultaString = null;
        try {
            // Apertura de una conexión 
            conexion = super.getConnection();
            // Creación de la consulta 
           
            consultaString = "SELECT * FROM tb_user WHERE user=?";
            // Se prepara la consulta
            consulta = conexion.prepareStatement(consultaString);
            consulta.setString(1, idUser);
            // Ejecución de la consulta 
            resultado = consulta.executeQuery();
            // Se almacena el resultado en el objeto usuario 
            if (resultado != null) {
                if (resultado.next()) {
                    // Se realiza el mapping de los atributos con los campos de la tabla SQL 
                    usuario = mapperUser(resultado);
                    System.out.println(usuario.getUser());
                    System.out.println(usuario.getPassword());
                    System.out.println(usuario.getRole());
                }
            }
        } catch (Exception e) {
            usuario = null;
            System.err.println("Error en la consulta en la clase ModelUserDAO función getUser");
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
        return usuario;
    }
    
    
    // agregar un usuario a la base
    public int agregarUsuario(User user) {
        // Variables
        PreparedStatement consulta = null;
        String consultaString = null;
        int codigoError = 0;
        try {
            // Apertura de una conexión
            conexion = super.getConnection();
            // Creación de la consulta
            consultaString = "INSERT INTO tb_user (user, password, role) VALUES (?,?,?)";
            // Preparación de la consulta
            consulta=conexion.prepareStatement(consultaString);
            consulta.setString(1, user.getUser());
            consulta.setString(2, user.getPassword());
            consulta.setString(3, user.getRole());
            System.out.println(consulta);
            // Se vacía la obra por seguridad
            user = null;
            // Ejecución de la consulta
            codigoError = consulta.executeUpdate();
        } catch (Exception e) {
            codigoError = 0;
            System.out.println("Error en el INSERT de la clase ModelUserDAO función agregarUsuario()");
            System.out.println(consulta);
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
                System.out.println("Error en el cierre de la conexión con la base de datos en la clase ModelUserDAO función agregarUsuario()");
            }
        }
        // Devolver el código de error
        return codigoError;
    }
    
    // eliminar un cliente en la base
    public int eliminarUsuario(String userId) {
        // Variables
        PreparedStatement consulta = null;
        String consultaString = null;
        int codigoError = 0;
        try {
            // Apertura de una conexión
            conexion = super.getConnection();
            // Eliminar el obra
            consultaString = "DELETE FROM tb_user WHERE user=?";
            consulta = conexion.prepareStatement(consultaString);
            consulta.setString(1, userId);
            // Ejecución de la consulta
            codigoError = consulta.executeUpdate();
            System.out.println(consultaString);
            System.out.println(consulta);
        } catch (Exception e) {
            codigoError = 0;
            System.out.println("Error en la consulta de la clase ModeloUserDAO función eliminarUsuario");
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
                System.out.println("Error en el cierre de la conexión con la base de datos en la clase ModeloUsuarioDAO función eliminarUsuario");
            }
        }

        // Devolver el código de error
        return codigoError;
    }
    
    // modificar una obra en la base
    public int modificarUsuario(User user) {
        // Variables
        PreparedStatement consulta = null;
        String consultaString = null;
        int codigoError = 0;
        try {
            // Apertura de una conexión
            conexion = super.getConnection();
            // Creación de la consulta
            consultaString = "UPDATE tb_user SET user=?, password=?, role=? WHERE user=?";
            consulta = conexion.prepareStatement(consultaString);
            consulta.setString(1, user.getUser());
            consulta.setString(2, user.getPassword());
            consulta.setString(3, user.getRole());
            // Se vacía el cliente por seguridad
            user = null;
            // Ejecución de la consulta
            codigoError = consulta.executeUpdate();
        } catch (Exception e) {
            System.out.println(consulta);
            System.out.println("Error en la consulta de la clase ModelUserDAO función modificarUsuario");
              }
              finally
              {
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
                System.out.println("Error en el cierre de la conexión con la base de datos en la clase ModelUserDAO función modificarUsuario");
                     }
              }
              // Devolver el código de error
              return codigoError;
    }
    // Realizar el mapping relacional hacia objeto 
    public User mapperUser(ResultSet resultado) throws ParseException {
        // Variables 
        User user = new User();
        try {
            if (resultado.getString("id_tb_user")== null) {
                user.setId_tb_user(0);
            } else {
                user.setId_tb_user(resultado.getInt("id_tb_user"));
            }
            
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