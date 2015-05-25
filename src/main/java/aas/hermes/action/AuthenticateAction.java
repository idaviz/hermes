/*
 * 
 */
package aas.hermes.action;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import aas.hermes.dao.javabeans.User;
import aas.hermes.dao.model.ModelUserDAO;

/**
 * @author dgarcia25
 */
@SuppressWarnings("serial")
public class AuthenticateAction extends ActionSupport implements SessionAware {

    private String user;
    private String password;
    private String role;
    
    private Map<String, Object> sessionMap;

    /**
     * Devuelve el nombre de usuario de un usuario.
     * @return Nombre de usuario.
     */
    public String getUser() {
        return user;
    }

    /** 
     * Asigna un nombre de usuario a un usuario.
     * @param user Nombre de usuario.
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Devuelve la contraseña de un usuario.
     * @return Contraseña del usuario.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Asigna una contraseña a un usuario.
     * @param password Contraseña del usuario.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Devuelve el rol de un usuario.
     * @return Rol del usuario.
     */
    public String getRole() {
        return role;
    }

    /**
     * Asigna un role a un usuario.
     * @param role Rol del usuario.
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     *
     * @param map
     */
    @Override
    public void setSession(Map<String, Object> map) {
        this.sessionMap = map;
    }

    
    /**
     * Crea un sesión de usuario si el nombre de usuario y contraseña son
     * válidos.
     * @return SUCCESS si se establece la sesión de usuario.
     */
        public String connect() {
       if ((user.equals("")||(user.length()>12))) {
            addFieldError("user", "Please, type a valid user.");
        }
        if ((password.equals("")||(password.length()>20))) {
            addFieldError("password", "Please, type a valid password.");
        }
        ModelUserDAO objetoUser = new ModelUserDAO();
        User userFound = new User();
        // buscamos el usuario en la base de datos a partir del usuario introducido
        userFound = objetoUser.getUserByUser(this.user);
        // verificar si se ha introducido un identificador y una contraseña
        if ((user != null && password != null)&&(userFound!=null)) {
            //verificar si el usuari recuperado de la base de datos coincide con el usuario introducido
            if (user.equals(userFound.getUser()) && password.equals(userFound.getPassword())) {
                // autenticación correcta,guardar el valor en la sesión
                System.out.println("usuario y contraseña correctos!");
                this.sessionMap.put("authentication", true);
                 this.sessionMap.put("user", user);
                 this.sessionMap.put("role", userFound.getRole());
                return SUCCESS;
            }
        }
        
       addFieldError("password", "Please, check that user and password are correct.");
        return INPUT;
    }

    /**
     * Elimina la sesión de usuario.  
     * @return SUCCESS si la sesión se elimina con éxito.
    */
    public String disconnect() {
        // vaciar la sesión del usuario
        this.sessionMap.clear();
        return SUCCESS;
    }
}
