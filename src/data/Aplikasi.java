/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import database.Koneksi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.sql.Date;
/**
 *
 * @author Finally
 */
public class Aplikasi {
    
    private Koneksi kon;
    private ArrayList<Buku> daftarBuku;
    private ArrayList<Mahasiswa> daftarMahasiswa;
    private ArrayList<Peminjaman> daftarPeminjaman;
    private ArrayList<Kategori> daftarKategori;
    private ArrayList<Tataletak> daftarTataletak;
    private ArrayList<Petugas> daftarPetugas;
    
    private int jBuku;
    private int jMahasiswa;
    private int jPeminjaman;
    private int jKategori;
    private int jTataletak;
    private int jPetugas;
    
    public Aplikasi() {
        jBuku=0;
        jMahasiswa=0;
        jPeminjaman=0;
        jKategori=0;
        jTataletak=0;
        jPetugas=0;
        kon = new Koneksi();
        daftarBuku = new ArrayList<>();
        daftarMahasiswa = new ArrayList<>();
        daftarPeminjaman = new ArrayList<>();
        daftarKategori = new ArrayList<>();
        daftarTataletak = new ArrayList<>();
        daftarPetugas = new ArrayList<>();
    }
    
    public Buku getBuku(String KDBuku){
        int x=-1;
        for (int i = 0; i < daftarBuku.size(); i++){
            if (daftarBuku.get(i).getKDBuku().equals(KDBuku)){
                x=i;
            }
        }
        if (x!=-1){
            return daftarBuku.get(x);
        }else{
            return null;
        }
    }
    
    public Kategori getKategori(String kdKategori){
        int x=-1;
        for (int i = 0; i < daftarKategori.size(); i++){
            if (daftarKategori.get(i).getKdKategori().equals(kdKategori)){
                x=i;
            }
        }
        if (x!=-1){
            return daftarKategori.get(x);
        }else{
            return null;
        }
    }
    
    public Mahasiswa getMahasiswa(String NIM){
        int x=-1;
        for (int i = 0; i < daftarMahasiswa.size(); i++){
            if (daftarMahasiswa.get(i).getNIM().equals(NIM)){
                x=i;
            }
        }
        if (x!=-1){
            return daftarMahasiswa.get(x);
        }else{
            return null;
        }
    }
    
    public Peminjaman getPeminjaman(String idTransaksi){
        int x=-1;
        for (int i = 0; i < daftarPeminjaman.size(); i++){
            if (daftarPeminjaman.get(i).getIdTransaksi().equals(idTransaksi)){
                x=i;
            }
        }
        if (x!=-1){
            return daftarPeminjaman.get(x);
        }else{
            return null;
        }
    }
    
    public Petugas getPetugas(String idPetugas){
        int x=-1;
        for (int i = 0; i < daftarPetugas.size(); i++){
            if (daftarPetugas.get(i).getIdPetugas().equals(idPetugas)){
                x=i;
            }
        }
        if (x!=-1){
            return daftarPetugas.get(x);
        }else{
            return null;
        }
    }
    
    public Tataletak getTataLetak(String kdTataLetak){
        int x=-1;
        for (int i = 0; i < daftarTataletak.size(); i++){
            if (daftarTataletak.get(i).getKdTataLetak().equals(kdTataLetak)){
                x=i;
            }
        }
        if (x!=-1){
            return daftarTataletak.get(x);
        }else{
            return null;
        }
    }
    
    public void addBuku(String KDBuku, String namaBuku, String penulis, String penerbit, 
            String kdKategori, String kdTataLetak, int jumlah, int stok) throws Exception{
        if (getBuku(KDBuku) == null) {
            daftarBuku.add(new Buku(KDBuku,namaBuku,penulis,penerbit,kdKategori,kdTataLetak,jumlah, stok));
            jBuku++;
            kon.insertBuku(new Buku(KDBuku,namaBuku,penulis,penerbit,kdKategori,kdTataLetak,jumlah, stok));
            System.out.println(KDBuku+namaBuku+penulis+penerbit+kdKategori+kdTataLetak+jumlah+stok);
        } else {
            throw new Exception("duplicate Dokter");
        }
    }
    
    public void addKategori(String kdKategori, String namaKategori, 
            String keterangan) throws Exception{
        if (getBuku(kdKategori) == null) {
            daftarKategori.add(new Kategori(kdKategori,namaKategori,keterangan));
            jKategori++;
            kon.insertKategori(new Kategori(kdKategori,namaKategori,keterangan));
            System.out.println(kdKategori+namaKategori+keterangan);
        } else {
            throw new Exception("duplicate Dokter");
        }
    }
    
    public void addMahasiswa(String NIM, String nama, String alamat, String email, 
            String noTelp) throws Exception{
        if (getMahasiswa(NIM)== null) {
            daftarMahasiswa.add(new Mahasiswa(NIM,nama,alamat,email,noTelp));
            jMahasiswa++;
            kon.insertMahasiswa(new Mahasiswa(NIM,nama,alamat,email,noTelp));
            System.out.println(NIM+nama+alamat+email+noTelp);
        } else {
            throw new Exception("duplicate Dokter");
        }
    }
    
    public void addPeminjaman(String idTransaksi, Date tanggalPinjam, Date 
            tanggalHarusKembali, Date tanggalKembali, double denda, String NIM) throws Exception{
        if (getPeminjaman(idTransaksi)== null) {
            daftarPeminjaman.add(new Peminjaman(idTransaksi,tanggalPinjam,
                    tanggalHarusKembali,tanggalKembali,denda,NIM));
            jPeminjaman++;
            kon.insertPeminjaman(new Peminjaman(idTransaksi,tanggalPinjam,tanggalHarusKembali,tanggalKembali,denda,NIM));
            System.out.println(idTransaksi+tanggalPinjam+tanggalHarusKembali+tanggalKembali+denda+NIM);
        } else {
            throw new Exception("duplicate Dokter");
        }
    }
    
    public void addPetugas(String idPetugas,String nama, String alamat, String email, String noTelp, 
             String username, String password) throws Exception{
        if (getPetugas(idPetugas)== null) {
            daftarPetugas.add(new Petugas(idPetugas,nama,alamat,email,noTelp,username,password));
            jPetugas++;
            kon.insertPetugas(new Petugas(idPetugas,nama,alamat,email,noTelp,username,password));
            System.out.println(idPetugas+nama+alamat+email+noTelp+username+password);
        } else {
            throw new Exception("duplicate Dokter");
        }
    }
    
    public void addTataletak(String kdTataLetak, String keterangan) throws Exception{
        if (getTataLetak(kdTataLetak)== null) {
            daftarTataletak.add(new Tataletak(kdTataLetak,keterangan));
            jTataletak++;
            kon.insertTataLetak(new Tataletak(kdTataLetak,keterangan));
            System.out.println(kdTataLetak+keterangan);
        } else {
            throw new Exception("duplicate Dokter");
        }
    }
    
    public String[][] getBukus(String KDBuku){
        String a[][]=new String[1][8];
        a[0][0]=getBuku(KDBuku).getKDBuku();
        a[0][1]=getBuku(KDBuku).getNamaBuku();
        a[0][5]=getBuku(KDBuku).getPenerbit();
        a[0][4]=getBuku(KDBuku).getPenulis();
        a[0][6]=getBuku(KDBuku).getKdKategori();
        a[0][7]=getBuku(KDBuku).getKdTataLetak();
        a[0][2]=String.valueOf(getBuku(KDBuku).getJumlah());
        a[0][3]=String.valueOf(getBuku(KDBuku).getStok());
        for (int k=0;k<daftarKategori.size();k++){
                    if (getBuku(KDBuku).getKdKategori().equals(daftarKategori.get(k).getKdKategori())){
                        a[0][6] = (daftarKategori.get(k).getNamaKategori());
                    }
                }
        return a;
        
                
               
    }
    
    public String[][] getKategoris(String kdKategori){
        String a[][]=new String[1][3];
        a[0][0]=getKategori(kdKategori).getKdKategori();
        a[0][1]=getKategori(kdKategori).getNamaKategori();
        a[0][2]=getKategori(kdKategori).getKeterangan();
        return a;
    }
    
    public String[][] getMahasiswas(String NIM){
        String a[][]=new String[1][5];
        a[0][0]=getMahasiswa(NIM).getNIM();
        a[0][1]=getMahasiswa(NIM).getNama();
        a[0][2]=getMahasiswa(NIM).getAlamat();
        a[0][3]=getMahasiswa(NIM).getEmail();
        a[0][4]=getMahasiswa(NIM).getNoTelp();
        return a;
    }
    
    public String[][] getPeminjamans(String idtransaksi){
        String a[][]=new String[1][6];
        a[0][0]=getPeminjaman(idtransaksi).getIdTransaksi();
        a[0][1]=String.valueOf(getPeminjaman(idtransaksi).getTanggalPinjam());
        a[0][2]=String.valueOf(getPeminjaman(idtransaksi).getTanggalHarusKembali());
        a[0][3]=String.valueOf(getPeminjaman(idtransaksi).getTanggalKembali());
        a[0][4]=String.valueOf(getPeminjaman(idtransaksi).getDenda());
        a[0][5]=getPeminjaman(idtransaksi).getNIM();
        return a;
    }
    
    public String[][] getPetugass(String idPetugas){
        String a[][]=new String[1][7];
        a[0][0]=getPetugas(idPetugas).getIdPetugas();
        a[0][1]=getPetugas(idPetugas).getNama();
        a[0][2]=getPetugas(idPetugas).getAlamat();
        a[0][3]=getPetugas(idPetugas).getEmail();
        a[0][4]=getPetugas(idPetugas).getNoTelp();
        a[0][5]=getPetugas(idPetugas).getUsername();
        a[0][6]=getPetugas(idPetugas).getPassword();
        return a;
    }
    
    public String[][] getTataLetaks(String kdTataLetak){
        String a[][]=new String[1][2];
        a[0][0]=getTataLetak(kdTataLetak).getKdTataLetak();
        a[0][1]=getTataLetak(kdTataLetak).getKeterangan();
        return a;
    }
    
    public void sortDaftarBuku() {
        Collections.sort(daftarBuku, new Comparator<Buku>() {
            @Override
            public int compare(Buku d1, Buku d2) {
                return d1.getKDBuku().compareTo(d2.getKDBuku());
            }
        });
    }
    
    public void sortDaftarKategori() {
        Collections.sort(daftarKategori, new Comparator<Kategori>() {
            @Override
            public int compare(Kategori d1, Kategori d2) {
                return d1.getKdKategori().compareTo(d2.getKdKategori());
            }
        });
    }
    
    public void sortDaftarMahasiswa() {
        Collections.sort(daftarMahasiswa, new Comparator<Mahasiswa>() {
            @Override
            public int compare(Mahasiswa d1, Mahasiswa d2) {
                return d1.getNIM().compareTo(d2.getNIM());
            }
        });
    }
    
    public void sortDaftarPeminjaman() {
        Collections.sort(daftarPeminjaman, new Comparator<Peminjaman>() {
            @Override
            public int compare(Peminjaman d1, Peminjaman d2) {
                return d1.getIdTransaksi().compareTo(d2.getIdTransaksi());
            }
        });
    }
    
    public void sortDaftarPetugas() {
        Collections.sort(daftarPetugas, new Comparator<Petugas>() {
            @Override
            public int compare(Petugas d1, Petugas d2) {
                return d1.getIdPetugas().compareTo(d2.getIdPetugas());
            }
        });
    }
    
    public void sortDaftarTataLetak() {
        Collections.sort(daftarTataletak, new Comparator<Tataletak>() {
            @Override
            public int compare(Tataletak d1, Tataletak d2) {
                return d1.getKdTataLetak().compareTo(d2.getKdTataLetak());
            }
        });
    }
    
    public void loadBuku(){
        daftarBuku=kon.loadDaftarBuku();
    }
    
    public void loadKategori(){
        daftarKategori=kon.loadDaftarKategori();
    }
    
    public void loadMahasiswa(){
        daftarMahasiswa=kon.loadDaftarMahasiswa();
    }
    
    public void loadPeminjaman(){
        daftarPeminjaman=kon.loadDaftarPeminjaman();
    }
    
    public void loadPetugas(){
        daftarPetugas=kon.loadDaftarPetugas();
    }
    
    public void loadTataLetak(){
        daftarTataletak=kon.loadDaftarTataLetak();
    }
    
    public String[][] getListBukuAll() {
        sortDaftarBuku();
        loadBuku();
        String a[][] = new String[daftarBuku.size()][8];
        for (int i = 0; i < daftarBuku.size(); i++) {
            a[i][0] = daftarBuku.get(i).getKDBuku();
            a[i][1] = daftarBuku.get(i).getNamaBuku();
            a[i][5] = daftarBuku.get(i).getPenerbit();
            a[i][4] = daftarBuku.get(i).getPenulis();
            a[i][6] = daftarBuku.get(i).getKdKategori();
            a[i][7] = daftarBuku.get(i).getKdTataLetak();
            a[i][2] = String.valueOf(daftarBuku.get(i).getJumlah());
            a[i][3] = String.valueOf(daftarBuku.get(i).getStok());
            for (int k=0;k<daftarKategori.size();k++){
                if (daftarBuku.get(i).getKdKategori().equals(daftarKategori.get(k).getKdKategori())){
                        a[i][6] = (daftarKategori.get(k).getNamaKategori());
                }
            }
        }
        return a;
    }
    
    public String[][] getListKategoriAll() {
        sortDaftarKategori();
        loadKategori();
        String a[][] = new String[daftarKategori.size()][3];
        for (int i = 0; i < daftarKategori.size(); i++) {
            a[i][0] = daftarKategori.get(i).getKdKategori();
            a[i][1] = daftarKategori.get(i).getNamaKategori();
            a[i][2] = daftarKategori.get(i).getKeterangan();
        }
        return a;
    }
    
    public String[][] getListMahasiswaAll() {
        sortDaftarMahasiswa();
        loadMahasiswa();
        String a[][] = new String[daftarMahasiswa.size()][5];
        for (int i = 0; i < daftarMahasiswa.size(); i++) {
            a[i][0] = daftarMahasiswa.get(i).getNIM();
            a[i][1] = daftarMahasiswa.get(i).getNama();
            a[i][2] = daftarMahasiswa.get(i).getAlamat();
            a[i][3] = daftarMahasiswa.get(i).getEmail();
            a[i][4] = daftarMahasiswa.get(i).getNoTelp();
        }
        return a;
    }
    
    public String[][] getListPeminjamanAll() {
        sortDaftarPeminjaman();
        loadPeminjaman();
        String a[][] = new String[daftarPeminjaman.size()][6];
        for (int i = 0; i < daftarPeminjaman.size(); i++) {
            a[i][0] = daftarPeminjaman.get(i).getIdTransaksi();
            a[i][1] = String.valueOf(daftarPeminjaman.get(i).getTanggalPinjam());
            a[i][2] = String.valueOf(daftarPeminjaman.get(i).getTanggalHarusKembali());
            a[i][3] = String.valueOf(daftarPeminjaman.get(i).getTanggalKembali());
            a[i][4] = String.valueOf(daftarPeminjaman.get(i).getDenda());
            a[i][5] = daftarPeminjaman.get(i).getNIM();
        }
        return a;
    }
    
    public String[][] getListPetugasAll() {
        sortDaftarPetugas();
        loadPetugas();
        String a[][] = new String[daftarPetugas.size()][7];
        for (int i = 0; i < daftarPetugas.size(); i++) {
            a[i][0] = daftarPetugas.get(i).getIdPetugas();
            a[i][1] = daftarPetugas.get(i).getNama();
            a[i][2] = daftarPetugas.get(i).getAlamat();
            a[i][3] = daftarPetugas.get(i).getEmail();
            a[i][4] = daftarPetugas.get(i).getNoTelp();
            a[i][5] = daftarPetugas.get(i).getUsername();
            a[i][6] = daftarPetugas.get(i).getPassword();
        }
        return a;
    }
    
    public String[][] getListTataLetakAll() {
        sortDaftarTataLetak();
        loadTataLetak();
        String a[][] = new String[daftarTataletak.size()][2];
        for (int i = 0; i < daftarTataletak.size(); i++) {
            a[i][0] = daftarTataletak.get(i).getKdTataLetak();
            a[i][1] = daftarTataletak.get(i).getKeterangan();
        }
        return a;
    }
    
    public String[] getListNBuku(){
        String a[]=new String[6];
        a[0]="kodeBuku";
        a[1]="namaBuku";
        a[2]="penerbit";
        a[3]="penulis";
        a[4]="kategori";
        a[5]="tataLetak";
        System.out.println(a[0]+a[1]+a[2]+a[3]+a[4]+a[5]);
        return a;
    }
    
    public String[] getListNkategori(){
        String a[]=new String[2];
        a[0]="kodeKategori";
        a[1]="namaKategori";
        System.out.println(a[0]+a[1]);
        return a;
    }
    
    public String[] getListNMahasiswa(){
        String a[]=new String[5];
        a[0]="NIM";
        a[1]="nama";
        a[2]="alamat";
        a[3]="email";
        a[4]="noTelp";
        System.out.println(a[0]+a[1]+a[2]+a[3]+a[4]);
        return a;
    }
    
    public String[] getListNPeminjaman(){
        String a[]=new String[5];
        a[0]="idTransaksi";
        a[1]="tanggalPinjam";
        a[2]="tanggalKembali";
        a[3]="tanggalHarusKembali";
        a[4]="NIM";
        System.out.println(a[0]+a[1]+a[2]+a[3]+a[4]);
        return a;
    }
    
    public String[] getListNPetugas(){
        String a[]=new String[5];
        a[0]="idPetugas";
        a[1]="nama";
        a[2]="alamat";
        a[3]="email";
        a[4]="noTelp";
        System.out.println(a[0]+a[1]+a[2]+a[3]+a[4]);
        return a;
    }
    
    public String[] getListNTataLetak(){
        String a[]=new String[1];
        a[0]="kodeTataLetak";
        System.out.println(a[0]);
        return a;
    }
    
    public String[][] getcariListBuku(String jenis,String nilai){
        sortDaftarBuku();
        loadBuku();
        String a[][]=new String[daftarBuku.size()][8];
        System.out.println("jenis"+jenis);
        if (jenis.equals("kodeBuku")){
            int j=0;
        for (int i = 0; i < daftarBuku.size(); i++){
            if (daftarBuku.get(i).getKDBuku().equalsIgnoreCase(nilai)){
                a[j][0] = daftarBuku.get(i).getKDBuku();
                a[j][1] = daftarBuku.get(i).getNamaBuku();
                a[j][4] = daftarBuku.get(i).getPenulis();
                a[j][5] = daftarBuku.get(i).getPenerbit();
                for (int k=0;k<daftarKategori.size();k++){
                    if (daftarBuku.get(i).getKdKategori().equals(daftarKategori.get(k).getKdKategori())){
                        a[j][6] = (daftarKategori.get(k).getNamaKategori());
                    }
                }
                a[j][7] = daftarBuku.get(i).getKdTataLetak();
                a[j][2] = String.valueOf(daftarBuku.get(i).getJumlah());
                a[j][3] = String.valueOf(daftarBuku.get(i).getStok());
                j++;
            }
        }
        String b[][]=new String[j][8];
        for (int i = 0; i < j; i++){
                b[i][0] = a[i][0];
                b[i][1] = a[i][1];
                b[i][2] = a[i][2];
                b[i][3] = a[i][3];
                b[i][4] = a[i][4];
                b[i][5] = a[i][5];
                b[i][6] = a[i][6];
                b[i][7] = a[i][7];
        }
        return b;
        }else if (jenis.equals("namaBuku")){
            int j=0;
        for (int i = 0; i < daftarBuku.size(); i++){
            if (daftarBuku.get(i).getNamaBuku().equals(nilai)){
                a[j][0] = daftarBuku.get(i).getKDBuku();
                a[j][1] = daftarBuku.get(i).getNamaBuku();
                a[j][4] = daftarBuku.get(i).getPenulis();
                a[j][5] = daftarBuku.get(i).getPenerbit();
                for (int k=0;k<daftarKategori.size();k++){
                    if (daftarBuku.get(i).getKdKategori().equals(daftarKategori.get(k).getKdKategori())){
                        a[j][6] = (daftarKategori.get(k).getNamaKategori());
                    }
                }
                a[j][7] = daftarBuku.get(i).getKdTataLetak();
                a[j][2] = String.valueOf(daftarBuku.get(i).getJumlah());
                a[j][3] = String.valueOf(daftarBuku.get(i).getStok());
                j++;
            }
        }
        String b[][]=new String[j][8];
        for (int i = 0; i < j; i++){
                b[i][0] = a[i][0];
                b[i][1] = a[i][1];
                b[i][2] = a[i][2];
                b[i][3] = a[i][3];
                b[i][4] = a[i][4];
                b[i][5] = a[i][5];
                b[i][6] = a[i][6];
                b[i][7] = a[i][7];
        }
        return b;
        }else if (jenis.equals("penerbit")){
            int j=0;
            System.out.println("penerbit");
        for (int i = 0; i < daftarBuku.size(); i++){
            if (daftarBuku.get(i).getPenerbit().equals(nilai)){
                a[j][0] = daftarBuku.get(i).getKDBuku();
                a[j][1] = daftarBuku.get(i).getNamaBuku();
                a[j][4] = daftarBuku.get(i).getPenulis();
                a[j][5] = daftarBuku.get(i).getPenerbit();
                for (int k=0;k<daftarKategori.size();k++){
                    if (daftarBuku.get(i).getKdKategori().equals(daftarKategori.get(k).getKdKategori())){
                        a[j][6] = (daftarKategori.get(k).getNamaKategori());
                    }
                }
                a[j][7] = daftarBuku.get(i).getKdTataLetak();
                a[j][2] = String.valueOf(daftarBuku.get(i).getJumlah());
                a[j][3] = String.valueOf(daftarBuku.get(i).getStok());
                j++;
            }
        }
        String b[][]=new String[j][8];
        for (int i = 0; i < j; i++){
                b[i][0] = a[i][0];
                b[i][1] = a[i][1];
                b[i][2] = a[i][2];
                b[i][3] = a[i][3];
                b[i][4] = a[i][4];
                b[i][5] = a[i][5];
                b[i][6] = a[i][6];
                b[i][7] = a[i][7];
        }
        return b;
        }else if (jenis.equals("penulis")){
            int j=0;
        for (int i = 0; i < daftarBuku.size(); i++){
            if (daftarBuku.get(i).getPenulis().equals(nilai)){
                a[j][0] = daftarBuku.get(i).getKDBuku();
                a[j][1] = daftarBuku.get(i).getNamaBuku();
                a[j][4] = daftarBuku.get(i).getPenulis();
                a[j][5] = daftarBuku.get(i).getPenerbit();
                for (int k=0;k<daftarKategori.size();k++){
                    if (daftarBuku.get(i).getKdKategori().equals(daftarKategori.get(k).getKdKategori())){
                        a[j][6] = (daftarKategori.get(k).getNamaKategori());
                    }
                }
                a[j][7] = daftarBuku.get(i).getKdTataLetak();
                a[j][2] = String.valueOf(daftarBuku.get(i).getJumlah());
                a[j][3] = String.valueOf(daftarBuku.get(i).getStok());
                j++;
            }
        }
        String b[][]=new String[j][8];
        for (int i = 0; i < j; i++){
                b[i][0] = a[i][0];
                b[i][1] = a[i][1];
                b[i][2] = a[i][2];
                b[i][3] = a[i][3];
                b[i][4] = a[i][4];
                b[i][5] = a[i][5];
                b[i][6] = a[i][6];
                b[i][7] = a[i][7];
        }
        return b;
        }else if (jenis.equals("kategori")){
            int j=0;
        for (int i = 0; i < daftarBuku.size(); i++){
            if (daftarBuku.get(i).getKdKategori().equals(nilai)){
                a[j][0] = daftarBuku.get(i).getKDBuku();
                a[j][1] = daftarBuku.get(i).getNamaBuku();
                a[j][4] = daftarBuku.get(i).getPenulis();
                a[j][5] = daftarBuku.get(i).getPenerbit();
                for (int k=0;k<daftarKategori.size();k++){
                    if (daftarBuku.get(i).getKdKategori().equals(daftarKategori.get(k).getKdKategori())){
                        a[j][6] = (daftarKategori.get(k).getNamaKategori());
                    }
                }
                a[j][7] = daftarBuku.get(i).getKdTataLetak();
                a[j][2] = String.valueOf(daftarBuku.get(i).getJumlah());
                a[j][3] = String.valueOf(daftarBuku.get(i).getStok());
                j++;
            }
        }
        String b[][]=new String[j][8];
        for (int i = 0; i < j; i++){
                b[i][0] = a[i][0];
                b[i][1] = a[i][1];
                b[i][2] = a[i][2];
                b[i][3] = a[i][3];
                b[i][4] = a[i][4];
                b[i][5] = a[i][5];
                b[i][6] = a[i][6];
                b[i][7] = a[i][7];
        }
        return b;
        }else{
            System.out.println("talet");
            int j=0;
        for (int i = 0; i < daftarBuku.size(); i++){
            if (daftarBuku.get(i).getKdTataLetak().equals(nilai)){
                a[j][0] = daftarBuku.get(i).getKDBuku();
                a[j][1] = daftarBuku.get(i).getNamaBuku();
                a[j][4] = daftarBuku.get(i).getPenulis();
                a[j][5] = daftarBuku.get(i).getPenerbit();
                for (int k=0;k<daftarKategori.size();k++){
                    if (daftarBuku.get(i).getKdKategori().equals(daftarKategori.get(k).getKdKategori())){
                        a[j][6] = (daftarKategori.get(k).getNamaKategori());
                    }
                }
                a[j][7] = daftarBuku.get(i).getKdTataLetak();
                a[j][2] = String.valueOf(daftarBuku.get(i).getJumlah());
                a[j][3] = String.valueOf(daftarBuku.get(i).getStok());
                j++;
            }
        }
        String b[][]=new String[j][8];
        for (int i = 0; i < j; i++){
                b[i][0] = a[i][0];
                b[i][1] = a[i][1];
                b[i][2] = a[i][2];
                b[i][3] = a[i][3];
                b[i][4] = a[i][4];
                b[i][5] = a[i][5];
                b[i][6] = a[i][6];
                b[i][7] = a[i][7];
        }
        System.out.println("wahhh");
        return b;
        
        }
        
    }
    
    public String[][] getcariListKategori(String jenis,String nilai){
        sortDaftarKategori();
        loadKategori();
        String a[][]=new String[daftarKategori.size()][2];
        if (jenis.equals("kodeKategori")){
            int j=0;
        for (int i = 0; i < daftarKategori.size(); i++){
            if (daftarKategori.get(i).getKdKategori().equalsIgnoreCase(nilai)){
                a[j][0] = daftarKategori.get(i).getKdKategori();
                a[j][1] = daftarKategori.get(i).getNamaKategori();
                j++;
            }
        }
        String b[][]=new String[j][2];
        for (int i = 0; i < j; i++){
                b[i][0] = a[i][0];
                b[i][1] = a[i][1];
        }
        return b;
        }else{
            int j=0;
        for (int i = 0; i < daftarKategori.size(); i++){
            if (daftarKategori.get(i).getNamaKategori().equalsIgnoreCase(nilai)){
                a[j][0] = daftarKategori.get(i).getKdKategori();
                a[j][1] = daftarKategori.get(i).getNamaKategori();
                j++;
            }
        }
        String b[][]=new String[j][2];
        for (int i = 0; i < j; i++){
                b[i][0] = a[i][0];
                b[i][1] = a[i][1];
        }
        return b;
        }
    }
    
    public String[][] getcariListMahasiswa(String jenis,String nilai){
        sortDaftarMahasiswa();
        loadMahasiswa();
        String a[][]=new String[daftarMahasiswa.size()][5];
        if (jenis.equals("NIM")){
            int j=0;
        for (int i = 0; i < daftarMahasiswa.size(); i++){
            if (daftarMahasiswa.get(i).getNIM().equalsIgnoreCase(nilai)){
                a[j][0] = daftarMahasiswa.get(i).getNIM();
                a[j][1] = daftarMahasiswa.get(i).getNama();
                a[j][2] = daftarMahasiswa.get(i).getAlamat();
                a[j][3] = daftarMahasiswa.get(i).getEmail();
                a[j][4] = daftarMahasiswa.get(i).getNoTelp();
                j++;
            }
        }
        String b[][]=new String[j][5];
        for (int i = 0; i < j; i++){
                b[i][0] = a[i][0];
                b[i][1] = a[i][1];
                b[i][2] = a[i][2];
                b[i][3] = a[i][3];
                b[i][4] = a[i][4];
        }
        return b;
        }else if(jenis.equals("nama")){
            int j=0;
        for (int i = 0; i < daftarMahasiswa.size(); i++){
            if (daftarMahasiswa.get(i).getNama().equalsIgnoreCase(nilai)){
                a[j][0] = daftarMahasiswa.get(i).getNIM();
                a[j][1] = daftarMahasiswa.get(i).getNama();
                a[j][2] = daftarMahasiswa.get(i).getAlamat();
                a[j][3] = daftarMahasiswa.get(i).getEmail();
                a[j][4] = daftarMahasiswa.get(i).getNoTelp();
                j++;
            }
        }
        String b[][]=new String[j][5];
        for (int i = 0; i < j; i++){
                b[i][0] = a[i][0];
                b[i][1] = a[i][1];
                b[i][2] = a[i][2];
                b[i][3] = a[i][3];
                b[i][4] = a[i][4];
        }
        return b;
        }else if(jenis.equals("alamat")){
            int j=0;
        for (int i = 0; i < daftarMahasiswa.size(); i++){
            if (daftarMahasiswa.get(i).getAlamat().equalsIgnoreCase(nilai)){
                a[j][0] = daftarMahasiswa.get(i).getNIM();
                a[j][1] = daftarMahasiswa.get(i).getNama();
                a[j][2] = daftarMahasiswa.get(i).getAlamat();
                a[j][3] = daftarMahasiswa.get(i).getEmail();
                a[j][4] = daftarMahasiswa.get(i).getNoTelp();
                j++;
            }
        }
        String b[][]=new String[j][5];
        for (int i = 0; i < j; i++){
                b[i][0] = a[i][0];
                b[i][1] = a[i][1];
                b[i][2] = a[i][2];
                b[i][3] = a[i][3];
                b[i][4] = a[i][4];
        }
        return b;
        }else if(jenis.equals("email")){
            int j=0;
        for (int i = 0; i < daftarMahasiswa.size(); i++){
            if (daftarMahasiswa.get(i).getEmail().equalsIgnoreCase(nilai)){
                a[j][0] = daftarMahasiswa.get(i).getNIM();
                a[j][1] = daftarMahasiswa.get(i).getNama();
                a[j][2] = daftarMahasiswa.get(i).getAlamat();
                a[j][3] = daftarMahasiswa.get(i).getEmail();
                a[j][4] = daftarMahasiswa.get(i).getNoTelp();
                j++;
            }
        }
        String b[][]=new String[j][5];
        for (int i = 0; i < j; i++){
                b[i][0] = a[i][0];
                b[i][1] = a[i][1];
                b[i][2] = a[i][2];
                b[i][3] = a[i][3];
                b[i][4] = a[i][4];
        }
        return b;
        }else{
            int j=0;
        for (int i = 0; i < daftarMahasiswa.size(); i++){
            if (daftarMahasiswa.get(i).getNoTelp().equalsIgnoreCase(nilai)){
                a[j][0] = daftarMahasiswa.get(i).getNIM();
                a[j][1] = daftarMahasiswa.get(i).getNama();
                a[j][2] = daftarMahasiswa.get(i).getAlamat();
                a[j][3] = daftarMahasiswa.get(i).getEmail();
                a[j][4] = daftarMahasiswa.get(i).getNoTelp();
                j++;
            }
        }
        String b[][]=new String[j][5];
        for (int i = 0; i < j; i++){
                b[i][0] = a[i][0];
                b[i][1] = a[i][1];
                b[i][2] = a[i][2];
                b[i][3] = a[i][3];
                b[i][4] = a[i][4];
        }
        return b;
        }
    }
    
    public String[][] getcariListPeminjaman(String jenis,String nilai){
        sortDaftarPeminjaman();
        loadPeminjaman();
        String a[][]=new String[daftarPeminjaman.size()][6];
        if (jenis.equals("idTransaksi")){
            int j=0;
        for (int i = 0; i < daftarPeminjaman.size(); i++){
            if (daftarPeminjaman.get(i).getIdTransaksi().equalsIgnoreCase(nilai)){
                a[j][0] = daftarPeminjaman.get(i).getIdTransaksi();
                a[j][1] = String.valueOf(daftarPeminjaman.get(i).getTanggalPinjam());
                a[j][2] = String.valueOf(daftarPeminjaman.get(i).getTanggalHarusKembali());
                a[j][3] = String.valueOf(daftarPeminjaman.get(i).getTanggalKembali());
                a[j][4] = String.valueOf(daftarPeminjaman.get(i).getDenda());
                a[j][5] = daftarPeminjaman.get(i).getNIM();
                j++;
            }
        }
        String b[][]=new String[j][6];
        for (int i = 0; i < j; i++){
                b[i][0] = a[i][0];
                b[i][1] = a[i][1];
                b[i][2] = a[i][2];
                b[i][3] = a[i][3];
                b[i][4] = a[i][4];
                b[i][5] = a[i][5];
        }
        return b;
        }else if (jenis.equals("tanggalPinjam")){
            int j=0;
        for (int i = 0; i < daftarPeminjaman.size(); i++){
            if (String.valueOf(daftarPeminjaman.get(i).getTanggalPinjam()).equalsIgnoreCase(nilai)){
                a[j][0] = daftarPeminjaman.get(i).getIdTransaksi();
                a[j][1] = String.valueOf(daftarPeminjaman.get(i).getTanggalPinjam());
                a[j][2] = String.valueOf(daftarPeminjaman.get(i).getTanggalHarusKembali());
                a[j][3] = String.valueOf(daftarPeminjaman.get(i).getTanggalKembali());
                a[j][4] = String.valueOf(daftarPeminjaman.get(i).getDenda());
                a[j][5] = daftarPeminjaman.get(i).getNIM();
                j++;
            }
        }
        String b[][]=new String[j][6];
        for (int i = 0; i < j; i++){
                b[i][0] = a[i][0];
                b[i][1] = a[i][1];
                b[i][2] = a[i][2];
                b[i][3] = a[i][3];
                b[i][4] = a[i][4];
                b[i][5] = a[i][5];
        }
        return b;
        }else if (jenis.equals("tanggalHarusKembali")){
            int j=0;
        for (int i = 0; i < daftarPeminjaman.size(); i++){
            if (String.valueOf(daftarPeminjaman.get(i).getTanggalHarusKembali()).equalsIgnoreCase(nilai)){
                a[j][0] = daftarPeminjaman.get(i).getIdTransaksi();
                a[j][1] = String.valueOf(daftarPeminjaman.get(i).getTanggalPinjam());
                a[j][2] = String.valueOf(daftarPeminjaman.get(i).getTanggalHarusKembali());
                a[j][3] = String.valueOf(daftarPeminjaman.get(i).getTanggalKembali());
                a[j][4] = String.valueOf(daftarPeminjaman.get(i).getDenda());
                a[j][5] = daftarPeminjaman.get(i).getNIM();
                j++;
            }
        }
        String b[][]=new String[j][6];
        for (int i = 0; i < j; i++){
                b[i][0] = a[i][0];
                b[i][1] = a[i][1];
                b[i][2] = a[i][2];
                b[i][3] = a[i][3];
                b[i][4] = a[i][4];
                b[i][5] = a[i][5];
        }
        return b;
        }else if (jenis.equals("tanggalKembali")){
            int j=0;
        for (int i = 0; i < daftarPeminjaman.size(); i++){
            if (String.valueOf(daftarPeminjaman.get(i).getTanggalKembali()).equalsIgnoreCase(nilai)){
                a[j][0] = daftarPeminjaman.get(i).getIdTransaksi();
                a[j][1] = String.valueOf(daftarPeminjaman.get(i).getTanggalPinjam());
                a[j][2] = String.valueOf(daftarPeminjaman.get(i).getTanggalHarusKembali());
                a[j][3] = String.valueOf(daftarPeminjaman.get(i).getTanggalKembali());
                a[j][4] = String.valueOf(daftarPeminjaman.get(i).getDenda());
                a[j][5] = daftarPeminjaman.get(i).getNIM();
                j++;
            }
        }
        String b[][]=new String[j][6];
        for (int i = 0; i < j; i++){
                b[i][0] = a[i][0];
                b[i][1] = a[i][1];
                b[i][2] = a[i][2];
                b[i][3] = a[i][3];
                b[i][4] = a[i][4];
                b[i][5] = a[i][5];
        }
        return b;
        }else{
            int j=0;
        for (int i = 0; i < daftarPeminjaman.size(); i++){
            if (daftarPeminjaman.get(i).getNIM().equalsIgnoreCase(nilai)){
                a[j][0] = daftarPeminjaman.get(i).getIdTransaksi();
                a[j][1] = String.valueOf(daftarPeminjaman.get(i).getTanggalPinjam());
                a[j][2] = String.valueOf(daftarPeminjaman.get(i).getTanggalHarusKembali());
                a[j][3] = String.valueOf(daftarPeminjaman.get(i).getTanggalKembali());
                a[j][4] = String.valueOf(daftarPeminjaman.get(i).getDenda());
                a[j][5] = daftarPeminjaman.get(i).getNIM();
                j++;
            }
        }
        String b[][]=new String[j][6];
        for (int i = 0; i < j; i++){
                b[i][0] = a[i][0];
                b[i][1] = a[i][1];
                b[i][2] = a[i][2];
                b[i][3] = a[i][3];
                b[i][4] = a[i][4];
                b[i][5] = a[i][5];
        }
        return b;
        }
    }
    
    public String[][] getcariListPetugas(String jenis,String nilai){
        sortDaftarPetugas();
        loadPetugas();
        String a[][]=new String[daftarPetugas.size()][7];
        if (jenis.equals("idPetugas")){
            int j=0;
        for (int i = 0; i < daftarPetugas.size(); i++){
            if (daftarPetugas.get(i).getIdPetugas().equalsIgnoreCase(nilai)){
                a[j][0] = daftarPetugas.get(i).getIdPetugas();
                a[j][1] = daftarPetugas.get(i).getNama();
                a[j][2] = daftarPetugas.get(i).getAlamat();
                a[j][3] = daftarPetugas.get(i).getEmail();
                a[j][4] = daftarPetugas.get(i).getNoTelp();
                a[j][5] = daftarPetugas.get(i).getUsername();
                a[j][6] = daftarPetugas.get(i).getPassword();
                
                j++;
            }
        }
        String b[][]=new String[j][7];
        for (int i = 0; i < j; i++){
                b[i][0] = a[i][0];
                b[i][1] = a[i][1];
                b[i][2] = a[i][2];
                b[i][3] = a[i][3];
                b[i][4] = a[i][4];
                b[i][5] = a[i][5];
                b[i][6] = a[i][6];
        }
        return b;
        }else if (jenis.equals("nama")){
            int j=0;
        for (int i = 0; i < daftarPetugas.size(); i++){
            if (daftarPetugas.get(i).getNama().equalsIgnoreCase(nilai)){
                a[j][0] = daftarPetugas.get(i).getIdPetugas();
                a[j][1] = daftarPetugas.get(i).getNama();
                a[j][2] = daftarPetugas.get(i).getAlamat();
                a[j][3] = daftarPetugas.get(i).getEmail();
                a[j][4] = daftarPetugas.get(i).getNoTelp();
                a[j][5] = daftarPetugas.get(i).getUsername();
                a[j][6] = daftarPetugas.get(i).getPassword();
                
                j++;
            }
        }
        String b[][]=new String[j][7];
        for (int i = 0; i < j; i++){
                b[i][0] = a[i][0];
                b[i][1] = a[i][1];
                b[i][2] = a[i][2];
                b[i][3] = a[i][3];
                b[i][4] = a[i][4];
                b[i][5] = a[i][5];
                b[i][6] = a[i][6];
        }
        return b;
        }if (jenis.equals("alamat")){
            int j=0;
        for (int i = 0; i < daftarPetugas.size(); i++){
            if (daftarPetugas.get(i).getAlamat().equalsIgnoreCase(nilai)){
                a[j][0] = daftarPetugas.get(i).getIdPetugas();
                a[j][1] = daftarPetugas.get(i).getNama();
                a[j][2] = daftarPetugas.get(i).getAlamat();
                a[j][3] = daftarPetugas.get(i).getEmail();
                a[j][4] = daftarPetugas.get(i).getNoTelp();
                a[j][5] = daftarPetugas.get(i).getUsername();
                a[j][6] = daftarPetugas.get(i).getPassword();
                
                j++;
            }
        }
        String b[][]=new String[j][7];
        for (int i = 0; i < j; i++){
                b[i][0] = a[i][0];
                b[i][1] = a[i][1];
                b[i][2] = a[i][2];
                b[i][3] = a[i][3];
                b[i][4] = a[i][4];
                b[i][5] = a[i][5];
                b[i][6] = a[i][6];
        }
        return b;
        }if (jenis.equals("email")){
            int j=0;
        for (int i = 0; i < daftarPetugas.size(); i++){
            if (daftarPetugas.get(i).getEmail().equalsIgnoreCase(nilai)){
                a[j][0] = daftarPetugas.get(i).getIdPetugas();
                a[j][1] = daftarPetugas.get(i).getNama();
                a[j][2] = daftarPetugas.get(i).getAlamat();
                a[j][3] = daftarPetugas.get(i).getEmail();
                a[j][4] = daftarPetugas.get(i).getNoTelp();
                a[j][5] = daftarPetugas.get(i).getUsername();
                a[j][6] = daftarPetugas.get(i).getPassword();
                j++;
            }
        }
        String b[][]=new String[j][7];
        for (int i = 0; i < j; i++){
                b[i][0] = a[i][0];
                b[i][1] = a[i][1];
                b[i][2] = a[i][2];
                b[i][3] = a[i][3];
                b[i][4] = a[i][4];
                b[i][5] = a[i][5];
                b[i][6] = a[i][6];
        }
        return b;
        }else{
            int j=0;
        for (int i = 0; i < daftarPetugas.size(); i++){
            if (daftarPetugas.get(i).getNoTelp().equalsIgnoreCase(nilai)){
                a[j][0] = daftarPetugas.get(i).getIdPetugas();
                a[j][1] = daftarPetugas.get(i).getNama();
                a[j][2] = daftarPetugas.get(i).getAlamat();
                a[j][3] = daftarPetugas.get(i).getEmail();
                a[j][4] = daftarPetugas.get(i).getNoTelp();
                a[j][5] = daftarPetugas.get(i).getUsername();
                a[j][6] = daftarPetugas.get(i).getPassword();
                
                j++;
            }
        }
        String b[][]=new String[j][7];
        for (int i = 0; i < j; i++){
                b[i][0] = a[i][0];
                b[i][1] = a[i][1];
                b[i][2] = a[i][2];
                b[i][3] = a[i][3];
                b[i][4] = a[i][4];
                b[i][5] = a[i][5];
                b[i][6] = a[i][6];
        }
        return b;
        }
    }
    
    public String[][] getcariListTataletak(String jenis,String nilai){
        sortDaftarTataLetak();
        loadTataLetak();
        String a[][]=new String[daftarTataletak.size()][2];
            int j=0;
        for (int i = 0; i < daftarTataletak.size(); i++){
            if (daftarTataletak.get(i).getKdTataLetak().equalsIgnoreCase(nilai)){
                a[j][0] = daftarTataletak.get(i).getKdTataLetak();
                a[j][1] = daftarTataletak.get(i).getKeterangan();
                j++;
            }
        }
        String b[][]=new String[j][2];
        for (int i = 0; i < j; i++){
                b[i][0] = a[i][0];
                b[i][1] = a[i][1];
        }
        return b;
    }
    
    public Petugas getPetugas(String username, String password){
        loadPetugas();
        int x=-1;
        for (int i=0;i<daftarPetugas.size();i++){
            if (daftarPetugas.get(i).getUsername().equals(username) && daftarPetugas.get(i).getPassword().equals(password)){
                x=i;
            }
        }
        if (x!=-1){
            return daftarPetugas.get(x);
        }else{
            return null;
        }
    }
    
    public int getPetugass(String username, String password){
        Petugas p=new Petugas();
        p=getPetugas(username,password);
            if (String.valueOf(p.getIdPetugas().charAt(0)).equals("A") && 
                    String.valueOf(p.getIdPetugas().charAt(1)).equals("D") &&
                    String.valueOf(p.getIdPetugas().charAt(2)).equals("M")){
                return 1;
            }else{
                return 2;
            }
    }
    
    public void removeBuku(String KDBuku) throws Exception{
        int x=-1;
        for (int i = 0; i < daftarBuku.size(); i++){
            if (daftarBuku.get(i).getKDBuku().equals(KDBuku)){
                x=i;
            }
        }
        if (x!=-1){
            kon.deleteBuku(daftarBuku.get(x));
            daftarBuku.remove(x);
            jBuku--;
        }else{
            throw new Exception("Buku tidak ditemukan");
        }
    }
    
    public void removeKategori(String kdKategori) throws Exception{
        int x=-1;
        for (int i = 0; i < daftarKategori.size(); i++){
            if (daftarKategori.get(i).getKdKategori().equals(kdKategori)){
                x=i;
            }
        }
        if (x!=-1){
            kon.deleteKategori(daftarKategori.get(x));
            daftarKategori.remove(x);
            jKategori--;
        }else{
            throw new Exception("Kategori tidak ditemukan");
        }
    }
    
    public void removeMahasiswa(String NIM) throws Exception{
        int x=-1;
        for (int i = 0; i < daftarMahasiswa.size(); i++){
            if (daftarMahasiswa.get(i).getNIM().equals(NIM)){
                x=i;
            }
        }
        if (x!=-1){
            kon.deleteMahasiswa(daftarMahasiswa.get(x));
            daftarMahasiswa.remove(x);
            jMahasiswa--;
        }else{
            throw new Exception("Mahasiswa tidak ditemukan");
        }
    }
    
    public void removePeminjaman(String idTransaksi) throws Exception{
        int x=-1;
        for (int i = 0; i < daftarPeminjaman.size(); i++){
            if (daftarPeminjaman.get(i).getIdTransaksi().equals(idTransaksi)){
                x=i;
            }
        }
        if (x!=-1){
            kon.deletePeminjaman(daftarPeminjaman.get(x));
            daftarPeminjaman.remove(x);
            jPeminjaman--;
        }else{
            throw new Exception("Transaksi Peminjaman tidak ditemukan");
        }
    }
    
    public void removePetugas(String idPetugas) throws Exception{
        int x=-1;
        for (int i = 0; i < daftarPetugas.size(); i++){
            if (daftarPetugas.get(i).getIdPetugas().equals(idPetugas)){
                x=i;
            }
        }
        if (x!=-1){
            kon.deletePetugas(daftarPetugas.get(x));
            daftarPetugas.remove(x);
            jPetugas--;
        }else{
            throw new Exception("Petugas tidak ditemukan");
        }
    }
    
    public void removeTataLetak(String kdTataLetak) throws Exception{
        int x=-1;
        for (int i = 0; i < daftarTataletak.size(); i++){
            if (daftarTataletak.get(i).getKdTataLetak().equals(kdTataLetak)){
                x=i;
            }
        }
        if (x!=-1){
            kon.deleteTataLetak(daftarTataletak.get(x));
            daftarTataletak.remove(x);
            jMahasiswa--;
        }else{
            throw new Exception("Tata Letak tidak ditemukan");
        }
    }
    
    public void updateBuku(String KDBuku, String namaBuku, String penulis, String penerbit, 
            String kdKategori, String kdTataLetak, int jumlah, int stok){
        if (getBuku(KDBuku)!=null){
        kon.updateBuku(new Buku(KDBuku,namaBuku,penulis,penerbit,kdKategori,kdTataLetak,jumlah,stok));
        loadBuku();
        sortDaftarBuku();
        }
    }
    public void updateKategori(String kdKategori, String namaKategori, String keterangan){
        if (getKategori(kdKategori)!=null){
        kon.updateKategori(new Kategori(kdKategori,namaKategori,keterangan));
        loadKategori();
        sortDaftarKategori();
        }
    }
    public void updateMahasiswa(String NIM,String nama, String alamat, String email, String noTelp){
        if (getMahasiswa(NIM)!=null){
        kon.updateMahasiswa(new Mahasiswa(NIM,nama,alamat,email,noTelp));
        loadMahasiswa();
        sortDaftarMahasiswa();
        }
    }
    public void updatePeminjaman(String idTransaksi, Date tanggalPinjam, Date tanggalHarusKembali, 
            Date tanggalKembali, double denda, String NIM){
        if (getPeminjaman(idTransaksi)!=null){
        kon.updatePeminjaman(new Peminjaman(idTransaksi,tanggalPinjam,tanggalHarusKembali,tanggalKembali,denda,NIM));
        loadPeminjaman();
        sortDaftarPeminjaman();
        }
    }
    public void updatePetugas(String idPetugas,String nama, String alamat, String email, String noTelp,
            String username,String password){
        if (getPetugas(idPetugas)!=null){
        kon.updatePetugas(new Petugas(idPetugas,nama,alamat,email,noTelp,username,password));
        loadPetugas();
        sortDaftarPetugas();
        }
    }
    public void updateTataLetak(String kdTataLetak, String keterangan){
        if (getTataLetak(kdTataLetak)!=null){
        kon.updateTataLetak(new Tataletak(kdTataLetak,keterangan));
        loadTataLetak();
        sortDaftarTataLetak();
        }
    }
}
