/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Finally
 */
public class Peminjaman {
    private String idTransaksi;
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private Date tanggalPinjam;
    private Date tanggalHarusKembali;
    private Date tanggalKembali;
    private double denda;
    private String NIM;
    
    public Peminjaman(){
        
    }
    public Peminjaman(String idTransaksi, Date tanggalPinjam, Date tanggalHarusKembali, Date tanggalKembali, double denda, String NIM){
        this.idTransaksi=idTransaksi;
        this.tanggalKembali=tanggalKembali;
        this.tanggalHarusKembali=tanggalHarusKembali;
        this.tanggalPinjam=tanggalPinjam;
        this.denda=denda;
        this.NIM=NIM;
    }

    /**
     * @return the idTransaksi
     */
    public String getIdTransaksi() {
        return idTransaksi;
    }

    /**
     * @param idTransaksi the idTransaksi to set
     */
    public void setIdTransaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    /**
     * @return the dateFormat
     */
    public DateFormat getDateFormat() {
        return dateFormat;
    }

    /**
     * @param dateFormat the dateFormat to set
     */
    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    /**
     * @return the tanggalPinjam
     */
    public Date getTanggalPinjam() {
        return tanggalPinjam;
    }

    /**
     * @param tanggalPinjam the tanggalPinjam to set
     */
    public void setTanggalPinjam(Date tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    /**
     * @return the tanggalHarusKembali
     */
    public Date getTanggalHarusKembali() {
        return tanggalHarusKembali;
    }

    /**
     * @param tanggalHarusKembali the tanggalHarusKembali to set
     */
    public void setTanggalHarusKembali(Date tanggalHarusKembali) {
        this.tanggalHarusKembali = tanggalHarusKembali;
    }

    /**
     * @return the tanggalKembali
     */
    public Date getTanggalKembali() {
        return tanggalKembali;
    }

    /**
     * @param tanggalKembali the tanggalKembali to set
     */
    public void setTanggalKembali(Date tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }

    /**
     * @return the denda
     */
    public double getDenda() {
        return denda;
    }

    /**
     * @param denda the denda to set
     */
    public void setDenda(double denda) {
        this.denda = denda;
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
