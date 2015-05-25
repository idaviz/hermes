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

/**
 * Clase de acción para la gestión de usuarios.
 * @author dgarcia25
 */
@SuppressWarnings("serial")
public class UserAction extends ActionSupport implements Preparable, ModelDriven {

    private List<User> listaUsuarios;
    private User usuario;
    private String user;
    private String password;
    private String role;
    private int id_tb_user;

    /**
     * Recupera el ID del usuario.
     * @return ID del usuario.
     */
    public int getId_tb_user() {
        return id_tb_user;
    }

    /**
     * Asigna un ID al usuario.
     * @param id_tb_user
     */
    public void setId_tb_user(int id_tb_user) {
        this.id_tb_user = id_tb_user;
    }

    /**
     * Recupera el nombre de un usuario.
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
     * Método para la carga de un objeto tipo User de la base de datos.
     * @throws Exception
     */
    @Override
    public void prepare() throws Exception {
        ModelUserDAO modelUserDAO = new ModelUserDAO();
        // en creación, crear un nuevo objeto vacío 
        System.out.println("Valor del campo user que llega a UserAction: " + this.user);
        if (this.id_tb_user == 0) {
            usuario = new User(user, password, role);
            System.out.println("Creación de nuevo usuario");
        } else {
            usuario = modelUserDAO.getUser(this.id_tb_user);
            System.out.println("Modificación de usuario");
        }
    }

    /**
     * Constructor de la clase UserAction.
     */
    public UserAction() {
    }

    /**
     * Recupera un objeto del tipo Usuario.
     * @return Objeto Usuario.
     */
    public User getUsuario() {
        return usuario;
    }

    /**
     * Asgina un valor al objeto Usuario.
     * @param usuario Objeto Usuario.
     */
    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    /**
     * Recupera una lista de usuarios.
     * @return Lista de usuarios.
     */
    public List<User> getListaUsuarios() {
        return listaUsuarios;
    }

    /**
     * Asigna valor a una lista de usuarios.
     * @param listaUsuarios Lista de usuarios.
     */
    public void setListaUsuarios(List<User> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    /**
     * Recupera la contraseña de un usuario.
     * @return Contraseña de usuario.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Asigna valor a una contraseña de usuario.
     * @param password Contraseña de usuario.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Recupera el rol de un usuario.
     * @return Rol de usuario.
     */
    public String getRole() {
        return role;
    }

    /**
     * Asigna un rol a un usuario.
     * @param role Rol de usuario.
     */
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

    /**
     * Crea un usuario con los datos introducidos en el formulario de creación.
     * @return SUCCESS si todos los datos son correctos.
     */
    public String agregar() {
        if ((this.user.equals("") || (this.user.length() > 12))) {
            addFieldError("user", "Please, type a valid user.");
        } else if ((this.password.equals("") || (this.password.length() > 20))) {
            addFieldError("password", "Please, type a valid password.");
        } else if (this.role == null) {
            addFieldError("role", "Please, choose a role.");
        }else{
        ModelUserDAO ModelUserDAO = new ModelUserDAO();
        ModelUserDAO.agregarUsuario(this.usuario);
        addActionMessage(this.usuario.getUser() + ": User added to database!");
        }
        return SUCCESS;
    }

    
    /**
     * Recupera una lista con todos los usuarios.
     * @return Lista de usuarios.
     */
        public String listado() {
        ModelUserDAO ModelUserDAO = new ModelUserDAO();
        listaUsuarios = (ArrayList<User>) ModelUserDAO.getListaUsuarios();
        return SUCCESS;
    }

    /**
     * Permite la edición de un usuario.
     * @return SUCCESS si se ha podido editar un usuario con éxito.
     */
        public String editar() {
        return SUCCESS;
    }

    

    /**
     * Permite modificar los datos de un usuario.
     * @return SUCCESS si se ha podido editar los datos del usuario.
     */
        public String modificar() {
        ModelUserDAO ModelUserDAO = new ModelUserDAO();
        ModelUserDAO.modificarUsuario(this.usuario);
        addActionMessage(this.usuario.getUser() + ": User updated!");
        return SUCCESS;

    }

    /**
     * Elimina un usuario.
     * @return SUCCESS si el usuario ha podido ser eliminado con éxito.
     */
        public String eliminar() {
        ModelUserDAO ModelUserDAO = new ModelUserDAO();
        ModelUserDAO.eliminarUsuario(this.user);
        addActionMessage(this.usuario.getUser() + ": User deleted from database!");
        return SUCCESS;
    }

}
