package br.com.fatec.bean;

/**
 * Created by ANDRE on 28/08/2017.
 */

public class Usuario {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        Usuario usuario = (Usuario) o;
        if (username == usuario.username){
            return true;
        }
        return false;
    }
}
