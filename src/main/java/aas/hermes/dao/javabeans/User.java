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

     public User() {
    }

    public User(String user, String password, String role) {
        this.user = user;
        this.password = password;
        this.role = role;
    }
    
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
}
