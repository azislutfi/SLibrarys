/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Finally
 */
public class Petugas extends Person{
    private String idPetugas;
    private String username;
    private String password;
    public Petugas(){
  
    }
    public Petugas(String idPetugas,String nama, String alamat, String email,String noTelp, String username, String password){
        super(nama,alamat,email,noTelp);
        this.idPetugas=idPetugas;
        this.username=username;
        this.password=password;
    }

    /**
     * @return the idPetugas
     */
    public String getIdPetugas() {
        return idPetugas;
    }

    /**
     * @param idPetugas the idPetugas to set
     */
    public void setIdPetugas(String idPetugas) {
        this.idPetugas = idPetugas;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
}
