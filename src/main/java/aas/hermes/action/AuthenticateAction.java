/*
 * 
 */
package aas.hermes.action;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import aas.hermes.dao.javabeans.User;
import aas.hermes.dao.model.ModelUserDAO;

@SuppressWarnings("serial")
/**
 *
 * @author dgarcia25
 */
public class AuthenticateAction extends ActionSupport implements SessionAware {

    private String user;
    private String password;
    private Map<String, Object> sessionMap;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @param map
     */
    @Override
    public void setSession(Map<String, Object> map) {
        this.sessionMap = map;
    }

    // descriptores de acceso
    public String connect() {
        System.out.println("this.user que se busca en la función connect >> "+this.user);
        ModelUserDAO objetoUser = new ModelUserDAO();
        User userFound = new User();
        // buscamos el usuario en la base de datos a partir del usuario introducido
        userFound = objetoUser.getUser(this.user);
        // verificar si se ha introducido un identificador y una contraseña
        if ((user != null && password != null)&&(userFound!=null)) {
            //verificar si el usuari recuperado de la base de datos coincide con el usuario introducido
            if (user.equals(userFound.getUser()) && password.equals(userFound.getPassword())) {
                // autenticación correcta,guardar el valor en la sesión
                System.out.println("usuario y contraseña correctos!");
                this.sessionMap.put("authentication", true);
                 this.sessionMap.put("user", user);
                return SUCCESS;
            }
        }
        return INPUT;
    }

    /**
    *
    */
    public String disconnect() {
        // vaciar la sesión del usuario
        this.sessionMap.clear();
        return SUCCESS;
    }
}
