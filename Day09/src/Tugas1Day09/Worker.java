package Tugas1Day09;

abstract class Worker {
    int IDKaryawan, absensiHari = 20, tunjanganPulsa = 100000,gajiPokok = 5000000;
    String nama;

    public abstract  void setIDKaryawan(int IDKaryawan);
    public abstract  int getIDKaryawan();
    public abstract  void setNama(String nama);
    public abstract  String getNama();
    public abstract  void setTunjanganPulsa(int tunjanganPulsa);
    public abstract  int getTunjanganPulsa();
    public abstract  void setGajiPokok(int gajiPokok);
    public abstract  int getGajiPokok();
    public abstract  int getAbsensiHari();
    abstract void tambahAbsensi();
}
