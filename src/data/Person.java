/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Finally
 */
public class Person {
    private String nama;
    private String alamat;
    private String email;
    private String noTelp;
    
    public Person(){
        
    }
    public Person(String nama,String alamat,String email, String noTelp){
    this.nama = nama;
    this.alamat = alamat;
    this.email = email;
    this.noTelp=noTelp;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the alamat
     */
    public String getAlamat() {
        return alamat;
    }

    /**
     * @param alamat the alamat to set
     */
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the noTelp
     */
    public String getNoTelp() {
        return noTelp;
    }

    /**
     * @param noTelp the noTelp to set
     */
    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }
    
}
