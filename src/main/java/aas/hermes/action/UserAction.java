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
    private int id_tb_user;

    public int getId_tb_user() {
        return id_tb_user;
    }

    public void setId_tb_user(int id_tb_user) {
        this.id_tb_user = id_tb_user;
    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

     @Override
    public void prepare() throws Exception {
        ModelUserDAO modelUserDAO = new ModelUserDAO();
        // en creación, crear un nuevo objeto vacío 
        System.out.println("Valor del campo user que llega a UserAction: "+this.user);
        if (this.id_tb_user == 0) {
            usuario = new User(user,password,role);
            System.out.println("Creación de nuevo usuario");
        }else {
            usuario = modelUserDAO.getUser(this.id_tb_user);
            System.out.println("Modificación de usuario");
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
        ModelUserDAO.agregarUsuario(this.usuario);
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
            ModelUserDAO ModelUserDAO = new ModelUserDAO();
            ModelUserDAO.modificarUsuario(this.usuario);
            return SUCCESS;
        
    }

    // eliminar un usuario a partir del parámetro recibido llamado userId

    public String eliminar() {
        ModelUserDAO ModelUserDAO = new ModelUserDAO();
        ModelUserDAO.eliminarUsuario(this.user);
        addActionMessage(this.usuario.getUser() + ": DELETED!");
        return SUCCESS;
    }

}
