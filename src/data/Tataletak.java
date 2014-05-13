/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Finally
 */
public class Tataletak {
    private String kdTataLetak;
    private String keterangan;
    public Tataletak(){
        
    }
    public Tataletak(String kdTataLetak, String keterangan){
        this.kdTataLetak=kdTataLetak;
        this.keterangan=keterangan;
    }

    /**
     * @return the kdTataLetak
     */
    public String getKdTataLetak() {
        return kdTataLetak;
    }

    /**
     * @param kdTataLetak the kdTataLetak to set
     */
    public void setKdTataLetak(String kdTataLetak) {
        this.kdTataLetak = kdTataLetak;
    }

    /**
     * @return the keterangan
     */
    public String getKeterangan() {
        return keterangan;
    }

    /**
     * @param keterangan the keterangan to set
     */
    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    
}
