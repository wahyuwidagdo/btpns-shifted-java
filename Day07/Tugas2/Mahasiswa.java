// class Mahasiswa {
//     String nama = "";
//     String jenis_kelamin = "";
//     int umur;

//     void setNama(String namaKamu){
//         nama = namaKamu;
//     }

//     String getNama(){
//         return nama;
//     }

//     void setJK(String JK){
//         jenis_kelamin = JK;
//     }

//     String getJK(){
//         return jenis_kelamin;
//     }

//     void setUmur(int newUmur){
//         umur = newUmur;
//     }

//     int getUmur(){
//         return umur;
//     }

//     void printStates(){
//         System.out.println("Nama : " + nama + "\n" + "Jenis Kelamin : " + jenis_kelamin + "\n" + "Umur : " + umur );
//     }

//     void printLines() {
//         System.out.println("=====================");
//     }
// }

// public class Mahasiswa implements Comparable {
//     int id;
//     String nama = "";
//     int nilai;

//     public Mahasiswa(int id, String nama, int nilai) {
//         this.id = id;
//         this.nama = nama;
//         this.nilai = nilai;
//     }

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

//     public void setNilai(int nilai) {
//         this.nilai = nilai;
//     }

//     public int getNilai() {
//         return nilai;
//     }

//     @Override
//     public int compareTo(Object o) {
//         int compare= ((Mahasiswa)o).getId();
//         return this.id-compare;
//     }
// }

// public class Mahasiswa implements Comparable {
//     String nama = "";
//     int id, uts, uas, tugas;
//     double nilaiAkhir = nilaiAkhir(uts, uas, tugas);

//     public Mahasiswa(int id, String nama, int uts, int uas, int tugas /*, double nilaiAkhir*/) {
//         this.id = id;
//         this.nama = nama;
//         this.uts = uts;
//         this.uas = uas;
//         this.tugas = tugas;
//         // this.nilaiAkhir = nilaiAkhir;
//     }

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

//     public void setUts(int uts) {
//         this.uts = uts;
//     }

//     public int getUts() {
//         return uts;
//     }

//     public void setUas(int uas) {
//         this.uas = uas;
//     }

//     public int getUas() {
//         return uas;
//     }

//     public void setTugas(int tugas) {
//         this.tugas = tugas;
//     }

//     public int getTugas() {
//         return tugas;
//     }

//     public double nilaiAkhir(int uts, int uas, int tugas) {
//         double nilaiAkhir;
//         nilaiAkhir = (0.35*uts)+(0.45*uas)+(0.2*tugas);
//         return nilaiAkhir;
//     }

//     @Override
//     public int compareTo(Object o) {
//         int compare= ((Mahasiswa)o).getId();
//         return this.id-compare;
//     }
// }

import java.util.*;
public class Mahasiswa {
    int id;
    String nama;
    ArrayList<Double> nilai = new ArrayList();
    
    public Mahasiswa(int id, String nama, double bhsInggris, double fisika, double algoritma) {
        this.id = id;
        this.nama = nama;
        setNilai(bhsInggris, fisika, algoritma);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setNilai(double bhsInggris, double fisika, double algoritma) {
        this.nilai.add(bhsInggris);
        this.nilai.add(fisika);
        this.nilai.add(algoritma);
    }

    public double getNilai(int index) {
        return this.nilai.get(index);
    }
}