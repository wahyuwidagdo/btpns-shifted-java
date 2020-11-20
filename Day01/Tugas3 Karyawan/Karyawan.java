/** Dokumentasi
Ini merupakan program latihan 3 di hari pertama dari belajar Java di G2Academy
Author : Wahyu F. Widagdo [Edo]
Nickname : VanillaMan
CreateOn : 9 Nov 2020
 */

// Deklarasikan Karyawan Class
class Karyawan {
    // Inisialisasi State/Variable/Attribut
    String nama = "";
    String jabatan = "";
    int gaji;

    /*
    Disini/dibawah ini, merupakan behavior atau method-method dari object/class Karyawan
    Kita akan mendeklarasikan method-methodnya di bawah ini.
     */

    // method pendeklarasian/penginisialisaian nilai/value dari nama
    void setNama(String namaKamu) {
        nama = namaKamu;
    }

    // method untuk mengambil nilai dari nama yang di deklarasikan di method setNama
    String getNama() {
        return nama;
    }

    // method pendeklarasian/penginisialisaian nilai/value dari jabatan
    void setJabatan(String jabatanmu) {
        jabatan = jabatanmu;
    }

    // method untuk mengambil nilai dari jabatan yang di deklarasikan di method setJabatan
    String getJabatan() {
        return jabatan;
    }

    // method pendeklarasian/penginisialisaian nilai/value dari gaji
    void setGaji(int gajimu) {
        gaji = gajimu;
    }

    // method untuk mengambil nilai dari gaji yang di deklarasikan di method setGaji
    int getGaji() {
        return gaji;
    }

    // Output berupa print text
    void printStates(){
        System.out.println("Nama : " + nama + "\n" + "Jabatan : " + jabatan + "\n" + "Gaji : " + gaji );
    }

    // Output untuk pembatas dari setiap Object yang berbeda
    void printLines() {
        System.out.println("=====================");
    }
}