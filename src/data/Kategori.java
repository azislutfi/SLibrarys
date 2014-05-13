/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Finally
 */
public class Kategori {
    private String kdKategori;
    private String namaKategori;
    private String keterangan;
    public Kategori(){
        
    }
    public Kategori(String kdKategori, String namaKategori, String keterangan){
        this.kdKategori=kdKategori;
        this.namaKategori=namaKategori;
        this.keterangan=keterangan;
    }

    /**
     * @return the kdKategori
     */
    public String getKdKategori() {
        return kdKategori;
    }

    /**
     * @param kdKategori the kdKategori to set
     */
    public void setKdKategori(String kdKategori) {
        this.kdKategori = kdKategori;
    }

    /**
     * @return the namaKategori
     */
    public String getNamaKategori() {
        return namaKategori;
    }

    /**
     * @param namaKategori the namaKategori to set
     */
    public void setNamaKategori(String namaKategori) {
        this.namaKategori = namaKategori;
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
