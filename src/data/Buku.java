/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Finally
 */
public class Buku {
    private String KDBuku, namaBuku, penulis, penerbit, kdKategori, kdTataLetak;
    private int jumlah, stok;
    public Buku(){
        
    }
    public Buku(String KDBuku,String namaBuku,String penulis,String penerbit,
            String kdKategori,String kdTataLetak, int jumlah, int stok){
        this.KDBuku=KDBuku;
        this.namaBuku=namaBuku;
        this.penulis=penulis;
        this.penerbit=penerbit;
        this.jumlah=jumlah;
        this.stok=stok;
        this.kdKategori=kdKategori;
        this.kdTataLetak=kdTataLetak;
    }
    
    

    /**
     * @return the KDBuku
     */
    public String getKDBuku() {
        return KDBuku;
    }

    /**
     * @param KDBuku the KDBuku to set
     */
    public void setKDBuku(String KDBuku) {
        this.KDBuku = KDBuku;
    }

    /**
     * @return the namaBuku
     */
    public String getNamaBuku() {
        return namaBuku;
    }

    /**
     * @param namaBuku the namaBuku to set
     */
    public void setNamaBuku(String namaBuku) {
        this.namaBuku = namaBuku;
    }

    /**
     * @return the penulis
     */
    public String getPenulis() {
        return penulis;
    }

    /**
     * @param penulis the penulis to set
     */
    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    /**
     * @return the penerbit
     */
    public String getPenerbit() {
        return penerbit;
    }

    /**
     * @param penerbit the penerbit to set
     */
    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    /**
     * @return the jumlah
     */
    public int getJumlah() {
        return jumlah;
    }

    /**
     * @param jumlah the jumlah to set
     */
    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    /**
     * @return the stok
     */
    public int getStok() {
        return stok;
    }

    /**
     * @param stok the stok to set
     */
    public void setStok(int stok) {
        this.stok = stok;
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
    
}
