/*
 * Created by me and myself.
 */
package aas.hermes.action;

/**
 *
 * @author David
 */
import aas.hermes.dao.javabeans.User;
import aas.hermes.dao.model.ModelUserDAO;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class UserAction extends ActionSupport implements Preparable, ModelDriven {

    private List<User> listaUsuarios;
    private User user;
    private String userId;
    private String password;
    private String role;

    public List<User> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<User> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public String getUserId() {
        return userId;
    }

    public void setUser(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
    
    /**
     *
     * @throws Exception
     */ 
    @Override
    public void prepare() throws Exception {
        ModelUserDAO modelUserDAO = new ModelUserDAO();
        // en creación, crear un nuevo objeto vacío 
        if (userId == null) {
            user = new User();
        } // en modificación, devolver la información del objeto 
        else {
            user = modelUserDAO.getUser(userId);
        }
    }

    /**
     *
     * @return
     */
    @Override
    public Object getModel() {
        return null;
        
    }
    
    // Añadir, borrar y editar Obras
    // agregar el obra al modelo
    public String agregar() {

        if (this.user.getUser().equals("") || this.user.getUser().length() < 1 || this.user.getUser().length() > 12) {
            addFieldError("user", "USER length must be higher than 1 and lower than 12.");
            return "input";
        } else if (this.user.getPassword().equals("") || this.user.getPassword().length() < 1 || this.user.getPassword().length() > 20) {
            addFieldError("password", "PASSWORD length must be higher than 1 and lower than 20.");
            return "input";
        } else {
            ModelUserDAO ModelUserDAO = new ModelUserDAO();
            ModelUserDAO.agregarUsuario(user);
            addActionMessage(this.user.getUser() + ": " + getText("actionmessage.insert"));
            return SUCCESS;
        }
    }
    
    // eliminar un usuario a partir del parámetro recibido llamado userId
    public String eliminar() {
        ModelUserDAO ModelUserDAO = new ModelUserDAO();
        ModelUserDAO.eliminarUsuario(this.userId);
        addActionMessage(this.user.getUser() + ": " + getText("actionmessage.delete"));
        return SUCCESS;
    }

}
