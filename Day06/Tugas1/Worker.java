// class Worker {
//     int id, absensi;
//     String nama;

//     public void setId(int id) {
//         this.id = id;
//     }

//     public int getId() {
//         return id;
//     }

//     public void setNama(String nama) {
//         this.nama = nama;
//     }

//     public String getNama() {
//         return nama;
//     }

//     void tambahAbsensi() {
//         absensi = absensi + 1;
//     }

//     public int getAbsensi() {
//         return absensi;
//     }
// }

abstract class Worker {
    int id, tunjanganPulsa, gajiPokok, gajiTotal, absensi=20;
    String nama;

    public abstract void setId(int id);

    public abstract int getId();

    public abstract void setNama(String nama);

    public abstract String getNama();

    public abstract void setTunjanganPulsa(int tunjanganPulsa);

    public abstract int getTunjanganPulsa();

    public abstract void setGajiPokok(int gajiPokok);

    public abstract int getGajiPokok();

    abstract void tambahAbsensi();

    public abstract int getAbsensi();

    abstract int hitungGajiTotal();

    public abstract void setGajiTotal(int gajiTotal);

    public abstract int getGajiTotal();
}