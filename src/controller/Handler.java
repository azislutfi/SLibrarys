/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import data.Aplikasi;
import gui.InterfaceView;
import gui.gAwal;
import gui.gBuku;
import gui.gCariBuku;
import gui.gKategori;
import gui.gLogin;
import gui.gMahasiswa;
import gui.gMenuAdmin;
import gui.gMenuPetugas;
import gui.gPeminjaman;
import gui.gPengembalian;
import gui.gPengunjung;
import gui.gPetugas;
import gui.gTataLetak;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.JComboBox;


    
/**
 *
 * @author Finally
 */
public class Handler implements ActionListener {
    private InterfaceView view;
    private Aplikasi model;

    // set the default view
    public void setView(InterfaceView view) {
        this.view = view;
    }

    // add action listener to the view
    public void setListener() {
        view.addListener(this);
    }

    // model initialization
    public void setModel(Aplikasi model) {
        this.model = model;
        this.model.loadBuku();
        this.model.loadKategori();
        this.model.loadMahasiswa();
        this.model.loadPeminjaman();
        this.model.loadPetugas();
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {

        // list of used view
        gBuku gbuk;
        gCariBuku gcarbuk;
        gKategori gkat;
        gLogin glog;
        gMahasiswa gmhs;
        gMenuAdmin gma;
        gMenuPetugas gmp;
        gPengunjung gpeng;
        gPetugas gpet;
        gTataLetak gtl;
        gAwal ga;
        gPeminjaman gpem;
        gPengembalian gpen;
        
        int petu;
        String a;
        // check where the action source
        Object source = e.getSource();
        
        
        if (view instanceof gAwal){
            ga = (gAwal) view;
            if (source.equals(ga.getBOK())){
                ga.setVisible(false);
                gCariBuku gg=new gCariBuku();
                gg.setCbCari(model.getListNBuku());
                gg.setTabelBuku(model.getListBukuAll());
                setView(gg);
                setListener();
                view.setVisible(true);
            }
        }else if (view instanceof gCariBuku){
            gcarbuk = (gCariBuku) view;
            a = String.valueOf(((JComboBox) gcarbuk.getCbCari()).getSelectedItem());
            if(source.equals(gcarbuk.getBCari())){
                gcarbuk.setTabelBuku(model.getListBukuAll());
                a = String.valueOf(((JComboBox) gcarbuk.getCbCari()).getSelectedItem());
                try{
                if (gcarbuk.getCari().equals("")){
                    gcarbuk.viewErrorMsg("Isi Keyword Terlebih Dahulu");
                }else{
                    System.out.println(a);
                    if (String.valueOf(((JComboBox) gcarbuk.getCbCari()).getSelectedItem()).equals("kodeBuku")){
                    gcarbuk.setTabelBuku(model.getBukus(gcarbuk.getCari()));
                    }else{
                        gcarbuk.setTabelBuku(model.getcariListBuku(a, gcarbuk.getCari()));
                    }
                }}catch (NullPointerException ex){
                    gcarbuk.viewErrorMsg("Data Tidak Ditemukan");
                }catch (Exception ex){
                    gcarbuk.viewErrorMsg(ex.getMessage());
                }
                gcarbuk.setCbCari(model.getListNBuku());
                
            }else if (source.equals(gcarbuk.getBLogin())){
                gcarbuk.setVisible(false);
                setView(new gLogin());
                setListener();
                view.setVisible(true);
            }
            
        }else if (view instanceof gLogin){
            glog = (gLogin) view;
            if (source.equals(glog.getBLogin())){
                if(model.getPetugas(glog.getUsername() , glog.getPassword())!=null){
                    if (model.getPetugass(glog.getUsername() , glog.getPassword())==1){
                        glog.setVisible(false);
                        setView(new gMenuAdmin());
                        view.setPetu(1);
                        setListener();
                        view.setVisible(true);
                    }else{
                        glog.setVisible(false);
                        setView(new gMenuPetugas());
                        view.setPetu(2);
                        setListener();
                        view.setVisible(true);
                    }
                }else{
                    view.viewErrorMsg("Username atau Password Salah");
                    glog.reset();
                }
            }
        
        }else if(view instanceof gMenuAdmin){
            gma=(gMenuAdmin) view;
            if (source.equals(gma.getMahasiswa())){
                gma.setVisible(false);
                gMahasiswa gg=new gMahasiswa();
                gg.setCbCari(model.getListNMahasiswa());
                gg.setTabelMahasiswa(model.getListMahasiswaAll());
                setView(gg);
                setListener();
                view.setPetu(1);
                view.setVisible(true);
            }else if (source.equals(gma.getBuku())){
                gma.setVisible(false);
                gBuku gg=new gBuku();
                gg.setCbCariBuku(model.getListNBuku());
                gg.setTabelBuku(model.getListBukuAll());
                gg.setCbCariKategori(model.getListNkategori());
                gg.setTabelKategori(model.getListKategoriAll());
                gg.setCbCariTataLetak(model.getListNTataLetak());
                gg.setTabelTataLetak(model.getListTataLetakAll());
                setView(gg);
                setListener();
                view.setPetu(1);
                view.setVisible(true);
            }else if (source.equals(gma.getKategori())){
                gma.setVisible(false);
                gKategori gg=new gKategori();
                gg.setCbCari(model.getListNkategori());
                gg.setTabelKategori(model.getListKategoriAll());
                setView(gg);
                setListener();
                view.setPetu(1);
                view.setVisible(true);
            }else if (source.equals(gma.getTataLetak())){
                gma.setVisible(false);
                gTataLetak gg=new gTataLetak();
                gg.setCbCari(model.getListNTataLetak());
                gg.setTabelTataLetak(model.getListTataLetakAll());
                setView(gg);
                setListener();
                view.setPetu(1);
                view.setVisible(true);
            }else if (source.equals(gma.getPetugas())){
                gma.setVisible(false);
                gPetugas gg=new gPetugas();
                gg.setCbCari(model.getListNPetugas());
                gg.setTabelPetugas(model.getListPetugasAll());
                setView(gg);
                setListener();
                view.setPetu(1);
                view.setVisible(true);
            }else if (source.equals(gma.getLogout())){
                petu=0;
                gma.setVisible(false);
                setView(new gCariBuku());
                setListener();
                view.setPetu(1);
                view.setVisible(true);
            }
        }else if(view instanceof gMenuPetugas){
            gmp=(gMenuPetugas) view;
            if (source.equals(gmp.getMahasiswa())){
                gmp.setVisible(false);
                gMahasiswa gg=new gMahasiswa();
                gg.setCbCari(model.getListNMahasiswa());
                gg.setTabelMahasiswa(model.getListMahasiswaAll());
                setView(gg);
                setListener();
                view.setPetu(2);
                view.setVisible(true);
            }else if (source.equals(gmp.getBuku())){
                gmp.setVisible(false);
                gBuku gg=new gBuku();
                gg.setCbCariBuku(model.getListNBuku());
                gg.setTabelBuku(model.getListBukuAll());
                gg.setCbCariKategori(model.getListNkategori());
                gg.setTabelKategori(model.getListKategoriAll());
                gg.setCbCariTataLetak(model.getListNTataLetak());
                gg.setTabelTataLetak(model.getListTataLetakAll());
                setView(gg);
                setListener();
                view.setPetu(2);
                view.setVisible(true);
            }else if (source.equals(gmp.getKategori())){
                gmp.setVisible(false);
                gKategori gg=new gKategori();
                gg.setCbCari(model.getListNkategori());
                gg.setTabelKategori(model.getListKategoriAll());
                setView(gg);
                setListener();
                view.setPetu(2);
                view.setVisible(true);
            }else if (source.equals(gmp.getTataLetak())){
                gmp.setVisible(false);
                gTataLetak gg=new gTataLetak();
                gg.setCbCari(model.getListNTataLetak());
                gg.setTabelTataLetak(model.getListTataLetakAll());
                setView(gg);
                setListener();
                view.setPetu(2);
                view.setVisible(true);
            }else if (source.equals(gmp.getLogout())){
                petu=0;
                gmp.setVisible(false);
                setView(new gCariBuku());
                setListener();
                view.setPetu(2);
                view.setVisible(true);
            }
        }else if(view instanceof gMahasiswa){
            gmhs=(gMahasiswa)view;
            a = String.valueOf(((JComboBox) gmhs.getCbCari()).getSelectedItem());
            if (source.equals(gmhs.getBReset())){
                gmhs.resetSemua();
                gmhs.setTabelMahasiswa(model.getListMahasiswaAll());
            }else if (source.equals(gmhs.getBTambah())){
                try {
                    model.addMahasiswa(gmhs.getNIM(),gmhs.getNama(),gmhs.getAlamat(),gmhs.getEmail(),gmhs.getNoTelp());
                    gmhs.viewErrorMsg("Tambah Data Mahasiswa Berhasil");
                }catch (Exception ex) {
                    view.viewErrorMsg(ex.getMessage());
                }
                gmhs.resetSemua();
                gmhs.setTabelMahasiswa(model.getListMahasiswaAll());
            }else if(source.equals(gmhs.getBUpdate())){
                try{
                    model.updateMahasiswa(gmhs.getNIM(),gmhs.getNama(),gmhs.getAlamat(),gmhs.getEmail(),gmhs.getNoTelp());
                    gmhs.viewErrorMsg("Data Mahasiswa Berhasil Diupdate");}
                catch(Exception ex) {
                    view.viewErrorMsg(ex.getMessage());
                }
                gmhs.resetSemua();
                gmhs.setTabelMahasiswa(model.getListMahasiswaAll());
            }else if(source.equals(gmhs.getBHapus())){
                try {
                    model.removeMahasiswa(gmhs.getNIM());
                    gmhs.viewErrorMsg("Hapus Data Mahasiswa Berhasil");
                }catch (Exception ex) {
                    view.viewErrorMsg(ex.getMessage());
                }
                gmhs.resetSemua();
                gmhs.setTabelMahasiswa(model.getListMahasiswaAll());
            }else if(source.equals(gmhs.getBKembali())){
                if (gmhs.getPetu()==1){
                    gmhs.setVisible(false);
                    setView(new gMenuAdmin());
                    setListener();
                    view.setVisible(true);
                }else if(gmhs.getPetu()==2){
                    gmhs.setVisible(false);
                    setView(new gMenuPetugas());
                    setListener();
                    view.setVisible(true);
                }
            }else if(source.equals(gmhs.getBCari())){
                a = String.valueOf(((JComboBox) gmhs.getCbCari()).getSelectedItem());
                try{
                if (gmhs.getCari().equals("")){
                    gmhs.viewErrorMsg("Isi Keyword Terlebih Dahulu");
                }else{
                if (String.valueOf(((JComboBox) gmhs.getCbCari()).getSelectedItem()).equals("NIM")){
                    gmhs.setTabelMahasiswa(model.getMahasiswas(gmhs.getCari()));
                }else{
                    gmhs.setTabelMahasiswa(model.getcariListMahasiswa(a, gmhs.getCari()));
                }
                }}catch (NullPointerException ex){
                    gmhs.viewErrorMsg("Data Tidak Ditemukan");
                }catch (Exception ex){
                    gmhs.viewErrorMsg(ex.getMessage());
                }
                
            }
            
        }else if(view instanceof gBuku){
            gbuk=(gBuku) view;
            a = String.valueOf(((JComboBox) gbuk.getCbCariBuku()).getSelectedItem());
            if (source.equals(gbuk.getBReset())){
                gbuk.resetSemua();
                gbuk.setTabelBuku(model.getListBukuAll());
                gbuk.setTabelKategori(model.getListKategoriAll());
                gbuk.setTabelTataLetak(model.getListTataLetakAll());
            }else if (source.equals(gbuk.getBTambah())){
                try {
                    model.addBuku(gbuk.getKodeBuku(),gbuk.getNamaBuku(),gbuk.getPenulis(),gbuk.getPenerbit(),gbuk.getKodeKategori(),gbuk.getKodeTataLetak(),gbuk.getJumlahBuku(),gbuk.getJumlahBuku());
                    gbuk.viewErrorMsg("Tambah Data Buku Berhasil");
                }catch (Exception ex) {
                    view.viewErrorMsg(ex.getMessage());
                }
                gbuk.resetSemua();
                gbuk.setTabelBuku(model.getListBukuAll());
            }else if(source.equals(gbuk.getBUpdate())){
                try{
                model.updateBuku(gbuk.getKodeBuku(),gbuk.getNamaBuku(),gbuk.getPenulis(),gbuk.getPenerbit(),gbuk.getKodeKategori(),gbuk.getKodeTataLetak(),gbuk.getJumlahBuku(),gbuk.getJumlahBuku());
                gbuk.viewErrorMsg("Data Buku Berhasil Diupdate");}
                catch(Exception ex) {
                    view.viewErrorMsg(ex.getMessage());
                }
                gbuk.resetSemua();
                gbuk.setTabelBuku(model.getListBukuAll());
            }else if(source.equals(gbuk.getBHapus())){
                try {
                    model.removeBuku(gbuk.getKodeBuku());
                    gbuk.viewErrorMsg("Hapus Data Buku Berhasil");
                }catch (Exception ex) {
                    view.viewErrorMsg(ex.getMessage());
                }
                gbuk.resetSemua();
                gbuk.setTabelBuku(model.getListBukuAll());
            }else if(source.equals(gbuk.getBKembali())){
                if (gbuk.getPetu()==1){
                    gbuk.setVisible(false);
                    setView(new gMenuAdmin());
                    setListener();
                    view.setVisible(true);
                }else if(gbuk.getPetu()==2){
                    gbuk.setVisible(false);
                    setView(new gMenuPetugas());
                    setListener();
                    view.setVisible(true);
                }
            }else if(source.equals(gbuk.getBCari())){
                a = String.valueOf(((JComboBox) gbuk.getCbCariBuku()).getSelectedItem());
                try{
                if (gbuk.getCariBuku().equals("")){
                    gbuk.viewErrorMsg("Isi Keyword Terlebih Dahulu");
                }else{
                if (String.valueOf(((JComboBox) gbuk.getCbCariBuku()).getSelectedItem()).equals("KodeBuku")){
                    gbuk.setTabelBuku(model.getBukus(gbuk.getCariBuku()));
                }else{
                    gbuk.setTabelBuku(model.getcariListBuku(a, gbuk.getCariBuku()));
                }
                }}catch (NullPointerException ex){
                    gbuk.viewErrorMsg("Data Tidak Ditemukan");
                }catch (Exception ex){
                    gbuk.viewErrorMsg(ex.getMessage());
                }
                
            }else if(source.equals(gbuk.getBCariKategori())){
                a = String.valueOf(((JComboBox) gbuk.getCbCariKategori()).getSelectedItem());
                try{
                if (gbuk.getCariKategori().equals("")){
                    gbuk.viewErrorMsg("Isi Keyword Terlebih Dahulu");
                }else{
                if (String.valueOf(((JComboBox) gbuk.getCbCariKategori()).getSelectedItem()).equals("kodeKategori")){
                    gbuk.setTabelKategori(model.getKategoris(gbuk.getCariKategori()));
                }else{
                    gbuk.setTabelKategori(model.getcariListKategori(a, gbuk.getCariKategori()));
                }
                }}catch (NullPointerException ex){
                    gbuk.viewErrorMsg("Data Tidak Ditemukan");
                }catch (Exception ex){
                    gbuk.viewErrorMsg(ex.getMessage());
                }
                
            }else if(source.equals(gbuk.getBCariTataLetak())){
                a = String.valueOf(((JComboBox) gbuk.getCbCariTataLetak()).getSelectedItem());
                try{
                if (gbuk.getCariTataLetak().equals("")){
                    gbuk.viewErrorMsg("Isi Keyword Terlebih Dahulu");
                }else{
                if (String.valueOf(((JComboBox) gbuk.getCbCariTataLetak()).getSelectedItem()).equals("kodeTataLetak")){
                    gbuk.setTabelTataLetak(model.getTataLetaks(gbuk.getCariTataLetak()));
                }else{
                    gbuk.setTabelKategori(model.getcariListKategori(a, gbuk.getCariKategori()));
                }
                }}catch (NullPointerException ex){
                    gbuk.viewErrorMsg("Data Tidak Ditemukan");
                }catch (Exception ex){
                    gbuk.viewErrorMsg(ex.getMessage());
                }
                
            }
        }else if(view instanceof gKategori){
            gkat=(gKategori) view;
            a = String.valueOf(((JComboBox) gkat.getCbCari()).getSelectedItem());
            if (source.equals(gkat.getBReset())){
                gkat.resetSemua();
                gkat.setTabelKategori(model.getListKategoriAll());
            }else if (source.equals(gkat.getBTambah())){
                try {
                    model.addKategori(gkat.getKodeKategori(),gkat.getNamaKategori(),gkat.getKeterangan());
                    gkat.viewErrorMsg("Tambah Data Kategori Berhasil");
                }catch (Exception ex) {
                    view.viewErrorMsg(ex.getMessage());
                }
                gkat.resetSemua();
                gkat.setTabelKategori(model.getListKategoriAll());
            }else if(source.equals(gkat.getBUpdate())){
                try{
                model.updateKategori(gkat.getKodeKategori(),gkat.getNamaKategori(),gkat.getKeterangan());
                gkat.viewErrorMsg("Data Kategori Berhasil Diupdate");}
                catch(Exception ex) {
                    view.viewErrorMsg(ex.getMessage());
                }
                gkat.resetSemua();
                gkat.setTabelKategori(model.getListKategoriAll());
            }else if(source.equals(gkat.getBHapus())){
                try {
                    model.removeKategori(gkat.getKodeKategori());
                    gkat.viewErrorMsg("Hapus Data Kategori Berhasil");
                }catch (Exception ex) {
                    view.viewErrorMsg(ex.getMessage());
                }
                gkat.resetSemua();
                gkat.setTabelKategori(model.getListKategoriAll());
            }else if(source.equals(gkat.getBKembali())){
                if (gkat.getPetu()==1){
                    gkat.setVisible(false);
                    setView(new gMenuAdmin());
                    setListener();
                    view.setVisible(true);
                }else if(gkat.getPetu()==2){
                    gkat.setVisible(false);
                    setView(new gMenuPetugas());
                    setListener();
                    view.setVisible(true);
                }
            }else if(source.equals(gkat.getBCari())){
                a = String.valueOf(((JComboBox) gkat.getCbCari()).getSelectedItem());
                try{
                if (gkat.getCari().equals("")){
                    gkat.viewErrorMsg("Isi Keyword Terlebih Dahulu");
                }else{
                if (String.valueOf(((JComboBox) gkat.getCbCari()).getSelectedItem()).equals("KodeKategori")){
                    gkat.setTabelKategori(model.getKategoris(gkat.getCari()));
                }else{
                    gkat.setTabelKategori(model.getcariListKategori(a, gkat.getCari()));
                }
                }}catch (NullPointerException ex){
                    gkat.viewErrorMsg("Data Tidak Ditemukan");
                }catch (Exception ex){
                    gkat.viewErrorMsg(ex.getMessage());
                }
                
            }
        }else if(view instanceof gTataLetak){
            gtl=(gTataLetak) view;
            a = String.valueOf(((JComboBox) gtl.getCbCari()).getSelectedItem());
            if (source.equals(gtl.getBReset())){
                gtl.resetSemua();
                gtl.setTabelTataLetak(model.getListTataLetakAll());
            }else if (source.equals(gtl.getBTambah())){
                try {
                    model.addTataletak(gtl.getKodeTataLetak(),gtl.getKeterangan());
                    gtl.viewErrorMsg("Tambah Data Tata Letak Berhasil");
                }catch (Exception ex) {
                    view.viewErrorMsg(ex.getMessage());
                }
                gtl.resetSemua();
                gtl.setTabelTataLetak(model.getListTataLetakAll());
            }else if(source.equals(gtl.getBUpdate())){
                try{
                model.updateTataLetak(gtl.getKodeTataLetak(),gtl.getKeterangan());
                gtl.viewErrorMsg("Data Tata Letak Berhasil Diupdate");}
                catch(Exception ex) {
                    view.viewErrorMsg(ex.getMessage());
                }
                gtl.resetSemua();
                gtl.setTabelTataLetak(model.getListTataLetakAll());
            }else if(source.equals(gtl.getBHapus())){
                try {
                    model.removeTataLetak(gtl.getKodeTataLetak());
                    gtl.viewErrorMsg("Hapus Data Tata Letak Berhasil");
                }catch (Exception ex) {
                    view.viewErrorMsg(ex.getMessage());
                }
                gtl.resetSemua();
                gtl.setTabelTataLetak(model.getListTataLetakAll());
            }else if(source.equals(gtl.getBKembali())){
                if (gtl.getPetu()==1){
                    gtl.setVisible(false);
                    setView(new gMenuAdmin());
                    setListener();
                    view.setVisible(true);
                }else if(gtl.getPetu()==2){
                    gtl.setVisible(false);
                    setView(new gMenuPetugas());
                    setListener();
                    view.setVisible(true);
                }
            }else if(source.equals(gtl.getBCari())){
                a = String.valueOf(((JComboBox) gtl.getCbCari()).getSelectedItem());
                try{
                if (gtl.getCari().equals("")){
                    gtl.viewErrorMsg("Isi Keyword Terlebih Dahulu");
                }else{
                if (String.valueOf(((JComboBox) gtl.getCbCari()).getSelectedItem()).equals("KodeKategori")){
                    gtl.setTabelTataLetak(model.getKategoris(gtl.getCari()));
                }else{
                    gtl.setTabelTataLetak(model.getcariListKategori(a, gtl.getCari()));
                }
                }}catch (NullPointerException ex){
                    gtl.viewErrorMsg("Data Tidak Ditemukan");
                }catch (Exception ex){
                    gtl.viewErrorMsg(ex.getMessage());
                }
                
            }
        }else if(view instanceof gPetugas){
            gpet =(gPetugas) view;
            a = String.valueOf(((JComboBox) gpet.getCbCari()).getSelectedItem());
            if (source.equals(gpet.getBReset())){
                gpet.resetSemua();
                gpet.setTabelPetugas(model.getListPetugasAll());
            }else if (source.equals(gpet.getBTambah())){
                try {
                    model.addPetugas(gpet.getIdPetugas(),gpet.getNama(),gpet.getAlamat(),gpet.getEmail(),gpet.getNoTelp(),gpet.getUsername(),gpet.getPassword());
                    gpet.viewErrorMsg("Tambah Data Petugas Berhasil");
                }catch (Exception ex) {
                    view.viewErrorMsg(ex.getMessage());
                }
                gpet.resetSemua();
                gpet.setTabelPetugas(model.getListPetugasAll());
            }else if(source.equals(gpet.getBUpdate())){
                try{
                model.updatePetugas(gpet.getIdPetugas(),gpet.getNama(),gpet.getAlamat(),gpet.getEmail(),gpet.getNoTelp(),gpet.getUsername(),gpet.getPassword());
                gpet.viewErrorMsg("Data Petugas Berhasil Diupdate");}
                catch(Exception ex) {
                    view.viewErrorMsg(ex.getMessage());
                }
                gpet.resetSemua();
                gpet.setTabelPetugas(model.getListPetugasAll());
            }else if(source.equals(gpet.getBHapus())){
                try {
                    model.removePetugas(gpet.getIdPetugas());
                    gpet.viewErrorMsg("Hapus Data Petugas Berhasil");
                }catch (Exception ex) {
                    view.viewErrorMsg(ex.getMessage());
                }
                gpet.resetSemua();
                gpet.setTabelPetugas(model.getListPetugasAll());
            }else if(source.equals(gpet.getBKembali())){
                if (gpet.getPetu()==1){
                    gpet.setVisible(false);
                    setView(new gMenuAdmin());
                    setListener();
                    view.setVisible(true);
                }else if(gpet.getPetu()==2){
                    gpet.setVisible(false);
                    setView(new gMenuPetugas());
                    setListener();
                    view.setVisible(true);
                }
            }else if(source.equals(gpet.getBCari())){
                a = String.valueOf(((JComboBox) gpet.getCbCari()).getSelectedItem());
                try{
                if (gpet.getCari().equals("")){
                    gpet.viewErrorMsg("Isi Keyword Terlebih Dahulu");
                }else{
                if (String.valueOf(((JComboBox) gpet.getCbCari()).getSelectedItem()).equals("idPetugas")){
                    gpet.setTabelPetugas(model.getPetugass(gpet.getCari()));
                }else{
                    gpet.setTabelPetugas(model.getcariListPetugas(a, gpet.getCari()));
                }
                }}catch (NullPointerException ex){
                    gpet.viewErrorMsg("Data Tidak Ditemukan");
                }catch (Exception ex){
                    gpet.viewErrorMsg(ex.getMessage());
                }
            }/*else if(view instanceof gPeminjaman){
            gpem=(gPeminjaman) view;
            a = String.valueOf(((JComboBox) gpem.getCbCari()).getSelectedItem());
            if (source.equals(gpem.getBReset())){
                gpem.resetSemua();
                gpem.setTabelRawatInap(model.getListPasienInapAll());
                gpem.setTabelPasien(model.getListPasienAll());
                gpem.setTabelRuang(model.getListRuanganAll());
            }else if (source.equals(pi.getBTambah())){
                try {
                    model.addPasienInap(pi.getIdPasienInap(),pi.getIdPasien(),pi.getKdRuang(),pi.getTglMasuk(),pi.getTglKeluar(),pi.getBiaya());
                    pi.viewErrorMsg("Tambah Data Rawat Inap Berhasil");
                }catch (Exception ex) {
                    view.viewErrorMsg(ex.getMessage());
                }
                pi.resetSemua();
                pi.setTabelRawatInap(model.getListPasienInapAll());
            }else if(source.equals(pi.getBUpdate())){
                try{
                model.updatePasienInap(pi.getIdPasienInap(), pi.getIdPasien(),pi.getKdRuang(), pi.getTglMasuk(), pi.getTglKeluar(), pi.getBiaya());
                pi.viewErrorMsg("Data Rawat Inap Berhasil Diupdate");}
                catch(Exception ex) {
                    view.viewErrorMsg(ex.getMessage());
                }
                pi.resetSemua();
                pi.setTabelRawatInap(model.getListPasienInapAll());
            }else if(source.equals(pi.getBHapus())){
                try {
                    model.removePasienInap(pi.getIdPasienInap());
                    pi.viewErrorMsg("Hapus Data Rawat Inap Berhasil");
                }catch (Exception ex) {
                    view.viewErrorMsg(ex.getMessage());
                }
                pi.resetSemua();
                pi.setTabelRawatInap(model.getListPasienInapAll());
            }else if(source.equals(pi.getBBack())){
                if (pi.getPetu()==1){
                    pi.setVisible(false);
                    setView(new gMenuAdmin());
                    setListener();
                    view.setVisible(true);
                }else if(pi.getPetu()==2){
                    pi.setVisible(false);
                    setView(new gMenuPetugas());
                    setListener();
                    view.setVisible(true);
                }
            }else if(source.equals(pi.getBCari())){
                idD = String.valueOf(((JComboBox) pi.getCbCari()).getSelectedItem());
                try{
                if (pi.getCari().equals("")){
                    pi.viewErrorMsg("Isi Keyword Terlebih Dahulu");
                }else{
                if (String.valueOf(((JComboBox) pi.getCbCari()).getSelectedItem()).equals("idRawatInap")){
                    pi.setTabelRawatInap(model.getPasienInaps(pi.getCari()));
                }else{
                    pi.setTabelRawatInap(model.getcariListPasienInap(idD, pi.getCari()));
                }
                }}catch (NullPointerException ex){
                    pi.viewErrorMsg("Data Tidak Ditemukan");
                }catch (Exception ex){
                    pi.viewErrorMsg(ex.getMessage());
                }
                
            }else if(source.equals(pi.getBCariRuang())){
                idD = String.valueOf(((JComboBox) pi.getCbCariRuang()).getSelectedItem());
                try{
                if (pi.getCariRuangan().equals("")){
                    pi.viewErrorMsg("Isi Keyword Terlebih Dahulu");
                }else{
                if (String.valueOf(((JComboBox) pi.getCbCariRuang()).getSelectedItem()).equals("kode ruang")){
                    pi.setTabelRuang(model.getRuangans(pi.getCariRuangan()));
                }else{
                    pi.setTabelRuang(model.getcariListRuang(idD, pi.getCariRuangan()));
                }
                }}catch (NullPointerException ex){
                    pi.viewErrorMsg("Data Tidak Ditemukan");
                }catch (Exception ex){
                    pi.viewErrorMsg(ex.getMessage());
                }
                
            }else if(source.equals(pi.getBCariPasien())){
                idD = String.valueOf(((JComboBox) pi.getCbCariPasien()).getSelectedItem());
                try{
                if (pi.getCariPasien().equals("")){
                    pi.viewErrorMsg("Isi Keyword Terlebih Dahulu");
                }else{
                if (String.valueOf(((JComboBox) pi.getCbCariPasien()).getSelectedItem()).equals("idPasien")){
                    pi.setTabelPasien(model.getPasiens(pi.getCariPasien()));
                }else{
                    pi.setTabelPasien(model.getcariListPasien(idD, pi.getCariPasien()));
                }
                }}catch (NullPointerException ex){
                    pi.viewErrorMsg("Data Tidak Ditemukan");
                }catch (Exception ex){
                    pi.viewErrorMsg(ex.getMessage());
                }
                
            }
        }*/
    }
}
}

