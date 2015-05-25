/*
 * Javabean User.
 */
package aas.hermes.dao.javabeans;

/**
 * Javabean User.
 * @author David
 */
public class User {
    private String user;
    private String password;
    private String role;
    private int id_tb_user;

    /**
     * Constructor del beam User.
     */
    public User() {
    }

    /**
     * Constructor del beam User con parámetros.
     * @param user Nombre del usuario.
     * @param password Contraseña del usuario.
     * @param role Role del usuario.
     */
    public User(String user, String password, String role) {
        this.user = user;
        this.password = password;
        this.role = role;
    }
    
    /**
     * Devuelve el identificador de un usuario.
     * @return
     */
    public int getId_tb_user() {
        return id_tb_user;
    }

    /**
     * Recupera el identificador de un usuario.
     * @param id_tb_user Identificador de usuario.
     */
    public void setId_tb_user(int id_tb_user) {
        this.id_tb_user = id_tb_user;
    }
        
    /**
     * Recupera el nombre de un usaurio.
     * @return Nombre de usuario.
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role
     */
    public void setRole(String role) {
        this.role = role;
    }
}
