import java.util.*;
import java.io.*;

public class MenuNilai {
    static ArrayList<Mahasiswa> mhs = new ArrayList<Mahasiswa>();
    public static void main(String args []) {
        String menu = "0";
        while (Integer.parseInt(menu) != 6) { // lakukan while untuk pemilihan menu
            System.out.println(" ");
            Scanner input = new Scanner(System.in); // Menggunakan(Inisialisasi) class scanner untuk mengambil nilai input
            String ul = "", lagi;
            System.out.println("============================");
            System.out.println("************MENU************");
            System.out.println("============================");
            System.out.println(" ");
            System.out.println("1. Buat Object Mahasiswa");
            System.out.println("2. Edit Data Mahasiswa");
            System.out.println("3. Delete Data Mahasiswa");
            System.out.println("4. Tampilkan di layar");
            System.out.println("5. Tulis ke File");
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
                    deleteMahasiswa();
                break;
                case 4:
                    tampilanLayar();
                break;
                case 5:
                    tulisFile();
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
            System.out.print("UTS : ");
            String uts = input.nextLine();
            System.out.print("UAS : ");
            String uas = input.nextLine();
            System.out.print("Tugas : ");
            String tugas = input.nextLine();
            // String nilaiAkhir = input.nextLine(); // Error
            // String nilaiAkhir = input.nextLine(nilaiAkhir); // Error
            // String nilaiAkhir = input.nextLine(nilaiAkhir()); // Error
            // nilaiAkhir(); // Error
            Mahasiswa mahasiswa = new Mahasiswa(Integer.parseInt(id), nama, Integer.parseInt(uts), Integer.parseInt(uas), Integer.parseInt(tugas)/**, Double.parseDouble(nilaiAkhir) */);
            mhs.add(Integer.parseInt(id), mahasiswa /**, Double.parseDouble(nilaiAkhir) // Error */);
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
            System.out.println("Nama     : " + dataEdit.getNama());
            System.out.println("UTS    : " + dataEdit.getUts());
            System.out.println("UAS    : " + dataEdit.getUas());
            System.out.println("TUGAS    : " + dataEdit.getTugas());
            System.out.println("=====================");
            System.out.println("");
            System.out.println("Masukkan Data Baru : ");
            System.out.print("Nama : ");
            String namaEdit = input.nextLine();
            System.out.print("UTS : ");
            String utsEdit = input.nextLine();
            System.out.print("UAS : ");
            String uasEdit = input.nextLine();
            System.out.print("TUGAS : ");
            String tugasEdit = input.nextLine();
            dataEdit.setId(Integer.parseInt(idEdit));
            dataEdit.setNama(namaEdit);
            dataEdit.setUts(Integer.parseInt(utsEdit));
            dataEdit.setUas(Integer.parseInt(uasEdit));
            dataEdit.setTugas(Integer.parseInt(tugasEdit));
            System.out.println("");
            System.out.println("Berhasil mengedit data mahasiswa.");
            System.out.println("Press Enter...!! Untuk kembali ke Menu utama");
            input.nextLine();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void deleteMahasiswa() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("=======================");
            System.out.println("*Delete Data Mahasiswa*");
            System.out.println("=======================");
            System.out.println("");
            System.out.print("Masukkan ID Mahasiswa : ");
            String idHapus = input.nextLine();
            mhs.remove(Integer.parseInt(idHapus));
            System.out.println("");
            System.out.println("Data berhasil dihapus...!!!");
            System.out.println("Please press enter...!! Untuk kembali ke Menu utama");
            input.nextLine();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void tampilanLayar() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("========================");
            System.out.println("*Laporan Data Mahasiswa*");
            System.out.println("========================");
            System.out.println("");
            Collections.sort(mhs);
            System.out.format("+-------------------------------------------------------------------------------------+%n");
            System.out.format("| Nama     | UTS     | UAS     | TUGAS     | NILAI AKHIR                              |%n");
            System.out.format("+-------------------------------------------------------------------------------------+%n");
            for (Mahasiswa str: mhs) {
                // System.out.print("Nama: "+str.getNama()+" | UTS: "+str.getUts()+" | UAS: "+str.getUas()+" | TUGAS: "+str.getTugas()+" | NILAI AKHIR: \n");
                for (int i = 0; i < mhs.size(); i++) {
                    System.out.print("| "+str.getNama()+"     | "+str.getUts()+"     | "+str.getUas()+"     | "+str.getTugas()+"     | NILAI AKHIR: Belum nemu cara masukin fungsi/method nilaiAkhir \n");
                }
            }
            System.out.println("");
            System.out.println("Press Enter untuk kembali ke Menu utama!!");
            input.nextLine();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void tulisFile() {
        try {
            Scanner input = new Scanner(System.in);
            FileWriter fw = new FileWriter("nilaiMahasiswat.txt");
            Collections.sort(mhs);
            for (Mahasiswa str: mhs) {
                fw.write("Nama: "+str.getNama()+"\n");
                fw.write("UTS: "+str.getUts()+"\n");
                fw.write("UAS: "+str.getUas()+"\n");
                fw.write("TUGAS: "+str.getTugas()+"\n");
                fw.write("\n");
            }
            fw.close();
            System.out.println("Success Tulis ke File!!!");
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
            System.out.println("I did this with my all, but still didn't solved it");
            System.out.println("It was fun and exciting, Terima Kasih Banyak~");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}