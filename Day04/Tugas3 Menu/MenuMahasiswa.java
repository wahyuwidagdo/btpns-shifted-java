// import java.util.ArrayList;
// import java.util.Scanner;
// import java.util.Collection;
import java.util.*;
import java.io.*;

public class MenuMahasiswa {
    static ArrayList<Mahasiswa> mhs = new ArrayList<Mahasiswa>(); // Membuat object array list dan menjadikannya menjadi instance
    // InputStreamReader r = new InputStreamReader(System.in); // Tidak jadi pakai InputStreamReader
    // BufferedReader br = new BufferedReader(r); // Tidak jadi pakai BufferedReader
    public static void main(String args[]) {
        String menu = "0"; // buat state/variable sebagai parameter/arguments untuk while
        while (Integer.parseInt(menu) != 6) { // lakukan while dengan state ulang
            System.out.println(" ");
            Scanner input = new Scanner(System.in); // Menggunakan(Inisialisasi) class scanner untuk mengambil nilai input
            String ul = "", lagi;
            System.out.println("============================");
            System.out.println("************MENU************");
            System.out.println("============================");
            System.out.println(" ");
            System.out.println("1. Buat Object Mahasiswa");
            System.out.println("2. Edit Data Mahasiswa");
            System.out.println("3. Remove Object Mahasiswa");
            System.out.println("4. Laporan Data Mahasiswa");
            System.out.println("5. Tulis Laporan ke File TXT");
            System.out.println("6. Exit");
            System.out.println("===============================");
            System.out.print("Pilih menu [1/2/3/4/5/6] = ");
            menu = input.nextLine();
            System.out.println("===============================");
            System.out.println(" ");

            switch (Integer.parseInt(menu)) {
                case 1:
                    createMahasiswa();
                    break;
                case 2:
                    editMahasiswa();
                break;
                case 3:
                    removeMahasiswa();
                break;
                case 4:
                    laporanMahasiswa();
                break;
                case 5:
                    tulisLaporan();
                break;
                case 6:
                    exit();
                break;
            }
        }
    }

    public static void createMahasiswa() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("=======================");
            System.out.println("*Buat Object Mahasiswa*");
            System.out.println("=======================");
            System.out.println("");
            System.out.print("ID : ");
            String id = input.nextLine();
            System.out.print("Nama : ");
            String nama = input.nextLine();
            System.out.print("Nilai : ");
            String nilai = input.nextLine();
            Mahasiswa mahasiswa = new Mahasiswa(Integer.parseInt(id), nama, Integer.parseInt(nilai));
            mhs.add(Integer.parseInt(id), mahasiswa);
            System.out.println("");
            System.out.println("Berhasil membuat object mahasiswa baru.");
            System.out.println("Press Enter untuk Menu selanjutnya!!");
            input.nextLine();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void editMahasiswa() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("=====================");
            System.out.println("*Edit Data Mahasiswa*");
            System.out.println("=====================");
            System.out.println("");
            System.out.print("Masukkan ID Mahasiswa : ");
            String idEdit = input.nextLine();
            Mahasiswa dataEdit = mhs.get(Integer.parseInt(idEdit));
            System.out.println("Data Sebelumnya : ");
            System.out.println("=====================");
            System.out.println("");
            System.out.println("ID       : " + idEdit);
            System.out.println("Nama     : " + dataEdit.getNama());
            System.out.println("Nilai    : " + dataEdit.getNilai());
            System.out.println("=====================");
            System.out.println("");
            System.out.println("Masukkan Data Baru : ");
            System.out.print("Nama : ");
            String namaEdit = input.nextLine();
            System.out.print("Nilai : ");
            String nilaiEdit = input.nextLine();
            dataEdit.setId(Integer.parseInt(idEdit));
            dataEdit.setNama(namaEdit);
            dataEdit.setNilai(Integer.parseInt(nilaiEdit));
            System.out.println("");
            System.out.println("Berhasil mengedit data mahasiswa.");
            System.out.println("Press Enter...!! Untuk kembali ke Menu utama");
            input.nextLine();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void removeMahasiswa() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("=====================");
            System.out.println("*Remove Object Mahasiswa*");
            System.out.println("=====================");
            System.out.println("");
            System.out.print("Masukkan ID Mahasiswa : ");
            String idHapus = input.nextLine();
            mhs.remove(Integer.parseInt(idHapus));
            System.out.println("");
            System.out.println("Data/Object berhasil dihapus...!!!");
            System.out.println("Please press enter...!! Untuk kembali ke Menu utama");
            input.nextLine();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void laporanMahasiswa() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("========================");
            System.out.println("*Laporan Data Mahasiswa*");
            System.out.println("========================");
            System.out.println("");
            Collections.sort(mhs);
            for (Mahasiswa str: mhs) {
                System.out.print("ID: "+str.getId()+" | Nama: "+str.getNama()+" | Nilai: "+str.getNilai()+"\n");
            }
            System.out.println("");
            System.out.println("Press Enter untuk kembali ke Menu utama!!");
            input.nextLine();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void tulisLaporan() {
        try {
            Scanner input = new Scanner(System.in);
            FileWriter fw = new FileWriter("laporanMahasiswaExport.txt");
            Collections.sort(mhs);
            for (Mahasiswa str: mhs) {
                fw.write("Id: "+str.getId()+"\n");
                fw.write("Nama: "+str.getNama()+"\n");
                fw.write("Nilai: "+str.getNilai()+"\n");
                fw.write("\n");
            }
            fw.close();
            System.out.println("Success Export Tulis Laporan!!!");
            System.out.println("Please Press Enter untuk kembali ke Menu utama");
            input.nextLine();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void exit() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("========================");
            System.out.println("*Anda Keluar Dari Program*");
            System.out.println("========================");
            System.out.println("");
            System.out.println("This Program was made by Wahyu F. Widagdo [Edo] with LOVE");
            System.out.println("I did this till midnight and about 3:00 AM");
            System.out.println("It was fun and exciting, Terima Kasih Banyak~");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}