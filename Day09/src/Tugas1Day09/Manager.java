package Tugas1Day09;

import java.util.ArrayList;

class Manager extends Worker {
    int tunjanganTransport = 0, tunjanganEntertaint = 0;
    ArrayList telp = new ArrayList();

    Manager(int id, String nama, ArrayList telp) {
        this.IDKaryawan = id;
        this.nama = nama;
        this.telp = telp;
        hitungTunjanganTransport();
        hitungTunjanganEntertaint();
    }

    void hitungTunjanganTransport() {
        this.tunjanganTransport = this.absensiHari * 50000;
    }

    int getTunjanganTransport() {
        return this.tunjanganTransport;
    }

    void hitungTunjanganEntertaint() {
        this.tunjanganEntertaint = this.absensiHari * 50000;
    }

    int getTunjanganEntertaint() {
        return  this.tunjanganEntertaint;
    }

    ArrayList<String> getTelp() {
        return this.telp;
    }

    @Override
    public void setIDKaryawan(int IDKaryawan) {
        this.IDKaryawan = IDKaryawan;
    }

    @Override
    public int getIDKaryawan() {
        return this.IDKaryawan;
    }

    @Override
    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public String getNama() {
        return this.nama;
    }

    @Override
    public void setTunjanganPulsa(int tunjanganPulsa) {
        this.tunjanganPulsa = tunjanganPulsa;
    }

    @Override
    public int getTunjanganPulsa() {
        return this.tunjanganPulsa;
    }

    @Override
    public void setGajiPokok(int gajiPokok) {
        this.gajiPokok = gajiPokok;
    }

    @Override
    public int getGajiPokok() {
        return this.gajiPokok;
    }

    @Override
    public int getAbsensiHari() {
        return this.absensiHari;
    }

    @Override
    void tambahAbsensi() {
        this.absensiHari += 1;
    }
}
