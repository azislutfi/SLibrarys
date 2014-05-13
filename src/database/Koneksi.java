/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import data.Buku;
import data.Kategori;
import data.Mahasiswa;
import data.Peminjaman;
import data.Petugas;
import data.Tataletak;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Finally
 */
public class Koneksi {

    Connection conn = null;

    public Koneksi() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
                    + "slibrary", "root", "");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
    public void insertBuku(Buku a) {
        if (a != null) {
            try {
                PreparedStatement ps;
                ps = conn.prepareStatement("insert into buku values"
                        + "(?,?,?,?,?,?,?,?)");
                ps.setString(1, a.getKDBuku());
                ps.setString(2, a.getNamaBuku());
                ps.setInt(3, a.getJumlah());
                ps.setInt(4, a.getStok());
                ps.setString(5, a.getPenulis());
                ps.setString(6, a.getPenerbit());
                ps.setString(7, a.getKdKategori());
                ps.setString(8, a.getKdTataLetak());
                ps.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void insertKategori(Kategori a) {
        if (a != null) {
            try {
                PreparedStatement ps;
                ps = conn.prepareStatement("insert into kategori values"
                        + "(?,?,?)");
                ps.setString(1, a.getKdKategori());
                ps.setString(2, a.getNamaKategori());
                ps.setString(3, a.getKeterangan());
                ps.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void insertMahasiswa(Mahasiswa a) {
        if (a != null) {
            try {
                PreparedStatement ps;
                ps = conn.prepareStatement("insert into mahasiswa values"
                        + "(?,?,?,?,?)");
                ps.setString(1, a.getNIM());
                ps.setString(2, a.getNama());
                ps.setString(3, a.getAlamat());
                ps.setString(4, a.getEmail());
                ps.setString(5, a.getNoTelp());
                ps.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void insertPeminjaman(Peminjaman a) {
        if (a != null) {
            try {
                PreparedStatement ps;
                ps = conn.prepareStatement("insert into mahasiswa values"
                        + "(?,?,?,?,?,?)");
                ps.setString(1, a.getIdTransaksi());
                ps.setDate(2,(Date) a.getTanggalPinjam());
                ps.setDate(3,(Date) a.getTanggalHarusKembali());
                ps.setDate(4,(Date) a.getTanggalKembali());
                ps.setDouble(5, a.getDenda());
                ps.setString(6, a.getNIM());
                ps.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void insertPetugas(Petugas a) {
        if (a != null) {
            try {
                PreparedStatement ps;
                ps = conn.prepareStatement("insert into petugas values"
                        + "(?,?,?,?,?,?,?)");
                ps.setString(1, a.getIdPetugas());
                ps.setString(2, a.getNama());
                ps.setString(3, a.getAlamat());
                ps.setString(4, a.getEmail());
                ps.setString(5, a.getNoTelp());
                ps.setString(6, a.getUsername());
                ps.setString(7, a.getPassword());
                ps.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void insertTataLetak(Tataletak a) {
        if (a != null) {
            try {
                PreparedStatement ps;
                ps = conn.prepareStatement("insert into tataletak values"
                        + "(?,?)");
                ps.setString(1, a.getKdTataLetak());
                ps.setString(2, a.getKeterangan());
                ps.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public Buku cariBuku(String KDBuku) {
        PreparedStatement ps = null;
        Buku a=new Buku();
        try {
            ps = conn.prepareStatement("select * from buku where kd_buku=?");
            ps.setString(1, KDBuku);
            ps.executeUpdate();
            a.setKDBuku(ps.getResultSet().getString(1));
            a.setNamaBuku(ps.getResultSet().getString(2));
            a.setJumlah(ps.getResultSet().getInt(3));
            a.setStok(ps.getResultSet().getInt(4));
            a.setPenulis(ps.getResultSet().getString(5));
            a.setPenerbit(ps.getResultSet().getString(6));
            a.setKdKategori(ps.getResultSet().getString(7));
            a.setKdTataLetak(ps.getResultSet().getString(8));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return a;
    }
    
    public Kategori cariKategori(String kdKategori) {
        PreparedStatement ps = null;
        Kategori a=new Kategori();
        try {
            ps = conn.prepareStatement("select * from kategori where kd_kategori=?");
            ps.setString(1, kdKategori);
            ps.executeUpdate();
            a.setKdKategori(ps.getResultSet().getString(1));
            a.setNamaKategori(ps.getResultSet().getString(2));
            a.setKeterangan(ps.getResultSet().getString(3));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return a;
    }
    
    public Mahasiswa cariMahasiswa(String NIM) {
        PreparedStatement ps = null;
        Mahasiswa a=new Mahasiswa();
        try {
            ps = conn.prepareStatement("select * from mahasiswa where NIM=?");
            ps.setString(1, NIM);
            ps.executeUpdate();
            a.setNIM(ps.getResultSet().getString(1));
            a.setNama(ps.getResultSet().getString(2));
            a.setAlamat(ps.getResultSet().getString(3));
            a.setEmail(ps.getResultSet().getString(4));
            a.setNoTelp(ps.getResultSet().getString(5));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return a;
    }
    
    public Peminjaman cariPeminjaman(String idTransaksi) {
        PreparedStatement ps = null;
        Peminjaman a=new Peminjaman();
        try {
            ps = conn.prepareStatement("select * from buku where kd_buku=?");
            ps.setString(1, idTransaksi);
            ps.executeUpdate();
            a.setIdTransaksi(ps.getResultSet().getString(1));
            a.setTanggalPinjam(ps.getResultSet().getDate(2));
            a.setTanggalHarusKembali(ps.getResultSet().getDate(3));
            a.setTanggalKembali(ps.getResultSet().getDate(4));
            a.setDenda(ps.getResultSet().getDouble(5));
            a.setNIM(ps.getResultSet().getString(6));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return a;
    }
    
    public Petugas cariPetugas(String idPetugas) {
        PreparedStatement ps = null;
        Petugas a=new Petugas();
        try {
            ps = conn.prepareStatement("select * from petugas where id_petugas=?");
            ps.setString(1, idPetugas);
            ps.executeUpdate();
            a.setIdPetugas(ps.getResultSet().getString(1));
            a.setNama(ps.getResultSet().getString(2));
            a.setAlamat(ps.getResultSet().getString(3));
            a.setEmail(ps.getResultSet().getString(4));
            a.setNoTelp(ps.getResultSet().getString(5));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return a;
    }
    
    public Tataletak cariTataLetak(String kdTataLetak) {
        PreparedStatement ps = null;
        Tataletak a=new Tataletak();
        try {
            ps = conn.prepareStatement("select * from tataletak where kd_tataletak=?");
            ps.setString(1, kdTataLetak);
            ps.executeUpdate();
            a.setKdTataLetak(ps.getResultSet().getString(1));
            a.setKeterangan(ps.getResultSet().getString(2));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return a;
    }
    
    public void deleteBuku(Buku a) {
        if (a != null) {
            try {
                PreparedStatement ps;
                ps = conn.prepareStatement("delete from buku "
                        + "where kd_buku=?");

                ps.setString(1, a.getKDBuku());
                ps.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void deleteKategori(Kategori a) {
        if (a != null) {
            try {
                PreparedStatement ps;
                ps = conn.prepareStatement("delete from kategori "
                        + "where kd_kategori=?");

                ps.setString(1, a.getKdKategori());
                ps.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void deleteMahasiswa(Mahasiswa a) {
        if (a != null) {
            try {
                PreparedStatement ps;
                ps = conn.prepareStatement("delete from mahasiswa "
                        + "where NIM=?");

                ps.setString(1, a.getNIM());
                ps.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void deletePeminjaman(Peminjaman a) {
        if (a != null) {
            try {
                PreparedStatement ps;
                ps = conn.prepareStatement("delete from peminjaman "
                        + "where id_transaksi=?");

                ps.setString(1, a.getIdTransaksi());
                ps.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void deletePetugas(Petugas a) {
        if (a != null) {
            try {
                PreparedStatement ps;
                ps = conn.prepareStatement("delete from petugas "
                        + "where id_petugas=?");

                ps.setString(1, a.getIdPetugas());
                ps.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void deleteTataLetak(Tataletak a) {
        if (a != null) {
            try {
                PreparedStatement ps;
                ps = conn.prepareStatement("delete from tataletak "
                        + "where kd_tataletak=?");

                ps.setString(1, a.getKdTataLetak());
                ps.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public ArrayList<Buku> loadDaftarBuku() {
        ArrayList<Buku> daftarBuku = new ArrayList<Buku>();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from buku");
            while (rs.next()) {
                Buku a = new Buku();
                a.setKDBuku(rs.getString(1));
                a.setNamaBuku(rs.getString(2));
                a.setJumlah(rs.getInt(3));
                a.setStok(rs.getInt(4));
                a.setPenulis(rs.getString(5));
                a.setPenerbit(rs.getString(6));
                a.setKdKategori(rs.getString(7));
                a.setKdTataLetak(rs.getString(8));
                System.out.println(a.getKDBuku()+a.getNamaBuku()+a.getJumlah()+a.getStok()+
                        a.getPenulis()+a.getPenerbit()+a.getKdKategori()+a.getKdTataLetak());
                daftarBuku.add(a);
            }
        } catch (SQLException ex) {
        }
        return daftarBuku;
    }
    
    public ArrayList<Kategori> loadDaftarKategori() {
        ArrayList<Kategori> daftarKategori = new ArrayList<Kategori>();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from kategori");
            while (rs.next()) {
                Kategori a = new Kategori();
                a.setKdKategori(rs.getString(1));
                a.setNamaKategori(rs.getString(2));
                a.setKeterangan(rs.getString(3));
                System.out.println(a.getKdKategori()+a.getNamaKategori()+a.getKeterangan());
                daftarKategori.add(a);
            }
        } catch (SQLException ex) {
        }
        return daftarKategori;
    }
    
    public ArrayList<Mahasiswa> loadDaftarMahasiswa() {
        ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<Mahasiswa>();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from mahasiswa");
            while (rs.next()) {
                Mahasiswa a = new Mahasiswa();
                a.setNIM(rs.getString(1));
                a.setNama(rs.getString(2));
                a.setAlamat(rs.getString(3));
                a.setEmail(rs.getString(4));
                a.setNoTelp(rs.getString(5));
                System.out.println(a.getNIM()+a.getNama()+a.getAlamat()+a.getEmail()+a.getNoTelp());
                daftarMahasiswa.add(a);
            }
        } catch (SQLException ex) {
        }
        return daftarMahasiswa;
    }
    
    public ArrayList<Peminjaman> loadDaftarPeminjaman() {
        ArrayList<Peminjaman> daftarPeminjaman = new ArrayList<Peminjaman>();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from peminjaman");
            while (rs.next()) {
                Peminjaman a = new Peminjaman();
                a.setIdTransaksi(rs.getString(1));
                a.setTanggalPinjam(rs.getDate(2));
                a.setTanggalHarusKembali(rs.getDate(3));
                a.setTanggalKembali(rs.getDate(4));
                a.setDenda(rs.getDouble(5));
                a.setNIM(rs.getString(6));
                System.out.println(a.getIdTransaksi()+a.getTanggalPinjam()+a.getTanggalHarusKembali()
                        +a.getTanggalKembali()+a.getDenda()+a.getNIM());
                daftarPeminjaman.add(a);
            }
        } catch (SQLException ex) {
        }
        return daftarPeminjaman;
    }
    
    public ArrayList<Petugas> loadDaftarPetugas() {
        ArrayList<Petugas> daftarPetugas = new ArrayList<Petugas>();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from petugas");
            while (rs.next()) {
                Petugas a = new Petugas();
                a.setIdPetugas(rs.getString(1));
                a.setNama(rs.getString(2));
                a.setAlamat(rs.getString(3));
                a.setEmail(rs.getString(4));
                a.setNoTelp(rs.getString(5));
                a.setUsername(rs.getString(6));
                a.setPassword(rs.getString(7));
                System.out.println(a.getIdPetugas()+a.getNama()+a.getAlamat()+a.getEmail()+a.getNoTelp()+a.getUsername()+a.getPassword());
                daftarPetugas.add(a);
            }
        } catch (SQLException ex) {
        }
        return daftarPetugas;
    }
    
    public ArrayList<Tataletak> loadDaftarTataLetak() {
        ArrayList<Tataletak> daftarTataletak = new ArrayList<Tataletak>();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from tataletak");
            while (rs.next()) {
                Tataletak a = new Tataletak();
                a.setKdTataLetak(rs.getString(1));
                a.setKeterangan(rs.getString(2));
                System.out.println(a.getKdTataLetak()+a.getKeterangan());
                daftarTataletak.add(a);
            }
        } catch (SQLException ex) {
        }
        return daftarTataletak;
    }
    
    public void updateBuku(Buku a) {
        if (a != null) {
            try {
                PreparedStatement ps;
                ps = conn.prepareStatement
                ("UPDATE `slibrary`.`buku` SET `nama_buku` = ?, `jumlah` = ?, `stok` = ?, `penulis` = ?, `penerbit` = ?, `kd_kategori` = ?, `kd_tataletak` = ? WHERE `buku`.`kd_buku` = ?");

                ps.setString(8, a.getKDBuku());
                ps.setString(1, a.getNamaBuku());
                ps.setInt(2, a.getJumlah());
                ps.setInt(3, a.getStok());
                ps.setString(4, a.getPenulis());
                ps.setString(5, a.getPenerbit());
                ps.setString(6, a.getKdKategori());
                ps.setString(7, a.getKdTataLetak());
                ps.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void updateKategori(Kategori a) {
        if (a != null) {
            try {
                PreparedStatement ps;
                ps = conn.prepareStatement("update kategori set nama_kategori=?,"
                        + "keterangan=? where kd_kategori=?");
                ps.setString(3, a.getKdKategori());
                ps.setString(1, a.getNamaKategori());
                ps.setString(2, a.getKeterangan());
                ps.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void updateMahasiswa(Mahasiswa a) {
        if (a != null) {
            try {
                PreparedStatement ps;
                ps = conn.prepareStatement("UPDATE `slibrary`.`mahasiswa` SET `nama` = ?, `alamat` = ?, `email` = ?, ` no_telp` = ? WHERE `mahasiswa`.`NIM` = ?");
                ps.setString(1, a.getNama());
                ps.setString(2, a.getAlamat());
                ps.setString(3, a.getEmail());
                ps.setString(4, a.getNoTelp());
                ps.setString(5, a.getNIM());
                ps.executeUpdate();
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void updatePeminjaman(Peminjaman a) {
        if (a != null) {
            try {
                PreparedStatement ps;
                ps = conn.prepareStatement("update peminjaman set tanggal_pinjam=?,"
                        + "tanggal_harus_kembali=?,tanggal_kembali=?,denda=?"
                        + "NIM=? where id_transaksi=?");
                ps.setString(6, a.getIdTransaksi());
                ps.setDate(1,(Date) a.getTanggalPinjam());
                ps.setDate(2,(Date) a.getTanggalHarusKembali());
                ps.setDate(3,(Date) a.getTanggalKembali());
                ps.setDouble(4, a.getDenda());
                ps.setString(5, a.getNIM());
                ps.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void updatePetugas(Petugas a) {
        if (a != null) {
            try {
                PreparedStatement ps;
                ps = conn.prepareStatement
                ("UPDATE `slibrary`.`petugas` SET `nama` = ?, `alamat` = ?, `email` = ?, `no_telp` = ?, `username` = ?, `password` = ? WHERE `petugas`.`id_petugas` = ?");
                ps.setString(7, a.getIdPetugas());
                ps.setString(1, a.getNama());
                ps.setString(2, a.getAlamat());
                ps.setString(3, a.getEmail());
                ps.setString(4, a.getNoTelp());
                ps.setString(5, a.getUsername());
                ps.setString(6, a.getPassword());
                ps.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void updateTataLetak(Tataletak a) {
        if (a != null) {
            try {
                PreparedStatement ps;
                ps = conn.prepareStatement("update tataletak set keterangan=?"
                        + "where kd_tataletak=?");
                ps.setString(2, a.getKdTataLetak());
                ps.setString(1, a.getKeterangan());
                ps.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
