package Tugas1Day09;

import java.util.ArrayList;

class Staff extends Worker {
    int tunjanganMakan;
    ArrayList email = new ArrayList();

    Staff(int id, String nama, ArrayList email) {
        this.IDKaryawan = id;
        this.nama = nama;
        this.email = email;
        this.hitungTunjanganMakan();
    }

    void hitungTunjanganMakan() {
        this.tunjanganMakan = this.absensiHari * 20000;
    }

    int getTunjanganMakan() {
        return this.tunjanganMakan;
    }

    ArrayList<String> getEmail() {
        return this.email;
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
