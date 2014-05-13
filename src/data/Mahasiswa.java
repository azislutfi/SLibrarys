/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Finally
 */
public class Mahasiswa extends Person{
    private String NIM;
    public Mahasiswa(){
        
    }
    public Mahasiswa(String NIM, String nama, String alamat, String email, String noTelp){
        super(nama,alamat,email,noTelp);
        this.NIM=NIM;
    }

    /**
     * @return the NIM
     */
    public String getNIM() {
        return NIM;
    }

    /**
     * @param NIM the NIM to set
     */
    public void setNIM(String NIM) {
        this.NIM = NIM;
    }
}
