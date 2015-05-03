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
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class UserAction extends ActionSupport implements Preparable, ModelDriven {

    private List<User> listaUsuarios;
    private User usuario;
    private String user;
    private String password;
    private String role;

     @Override
    public void prepare() throws Exception {
        ModelUserDAO modelUserDAO = new ModelUserDAO();
        // en creación, crear un nuevo objeto vacío 
        if (user == null) {
            System.out.println("prepare, user = null");
            usuario = new User();
        } // en modificación, devolver la información del objeto 
        else {
            System.out.println("prepare, user not null");
            usuario = modelUserDAO.getUser(user);
            System.out.println(usuario);
        }
    }
    
    public UserAction() {
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<User> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<User> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
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
     * @return
     */
    @Override
    public Object getModel() {
        return null;

    }

    // Añadir, borrar y editar Obras
    // agregar el obra al modelo
    public String agregar() {
        ModelUserDAO ModelUserDAO = new ModelUserDAO();
        ModelUserDAO.agregarUsuario(usuario);
        return SUCCESS;
    }

    // devolver la lista de clientes tras la recuperación 
    public String listado() {
        ModelUserDAO ModelUserDAO = new ModelUserDAO();
        listaUsuarios = (ArrayList<User>) ModelUserDAO.getListaUsuarios();
        return SUCCESS;
    }

    // mostrar el formulario en edición
    public String editar() {
        return SUCCESS;
    }

    // modificar una obra
    public String modificar() {
        if (this.usuario.getUser().equals("") || this.usuario.getUser().length() < 1 || this.usuario.getUser().length() > 12) {
            addFieldError("user", "USER length between 1 and 12 characters");
            return "input";
        } else if (this.usuario.getPassword().equals("") || this.usuario.getPassword().length() < 1 || this.usuario.getPassword().length() > 20) {
            addFieldError("password", "Password length between 1 and 20 characters");
            return "input";
        } else {
            ModelUserDAO ModelUserDAO = new ModelUserDAO();
            ModelUserDAO.modificarUsuario(usuario);
            addActionMessage(this.usuario.getUser() + ": Changes successfully saved.");
            return SUCCESS;
        }
    }

    // eliminar un usuario a partir del parámetro recibido llamado userId

    public String eliminar() {
        ModelUserDAO ModelUserDAO = new ModelUserDAO();
        ModelUserDAO.eliminarUsuario(this.user);
        addActionMessage(this.usuario.getUser() + ": DELETED!");
        return SUCCESS;
    }

}
