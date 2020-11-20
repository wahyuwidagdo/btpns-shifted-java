import java.util.*;
import java.io.*;

public class MenuStaff {
    static ArrayList<Staff> stf = new ArrayList<Staff>();
    public static void main(String args []) {
        String jabatan;
        String menu = "0";
        while (Integer.parseInt(menu) != 4) { // lakukan while untuk pemilihan menu
            System.out.println(" ");
            Scanner input = new Scanner(System.in); // Menggunakan(Inisialisasi) class scanner untuk mengambil nilai input
            System.out.println("============================");
            System.out.println("************MENU************");
            System.out.println("============================");
            System.out.println(" ");
            System.out.println("1. Buat Object Staff");
            System.out.println("2. Tambah Absensi");
            System.out.println("3. Tampilkan di layar");
            System.out.println("4. Exit");
            System.out.println("===============================");
            System.out.print("Pilih menu [1/2/3/4] = ");
            menu = input.nextLine();
            System.out.println("===============================");
            System.out.println(" ");

            switch (Integer.parseInt(menu)) {
                case 1:
                    createStaff();
                    break;
                case 2:
                    addAbsensi();
                break;
                case 3:
                    tampilanLayar();
                break;
                case 4:
                    // exit();
                break;
            }
        }
    }

    public static void createStaff() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("=======================");
            System.out.println("*Buat Object Staff*");
            System.out.println("=======================");
            System.out.println("");
            System.out.print("ID : ");
            String id = input.nextLine();
            System.out.print("Nama : ");
            String nama = input.nextLine();
            System.out.print("Jabatan : ");
            String jabatan = input.nextLine();
            Staff staff = new Staff(Integer.parseInt(id),nama,jabatan);
            stf.add(staff);
            System.out.println("");
            System.out.println("Berhasil membuat object staff baru.");
            System.out.println("Press Enter untuk Menu selanjutnya!!");
            input.nextLine();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void addAbsensi() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("========================");
            System.out.println("*Tambah Absensi*");
            System.out.println("========================");
            System.out.println("");
            System.out.print("Masukkan ID Staff : ");
            int id = Integer.parseInt(input.nextLine());
            Staff absen = (Staff)stf.get(id);
            absen.tambahAbsensi();
            System.out.println("");
            System.out.println("Tambah Absen Berhasil.");
            System.out.println("Press Enter untuk Menu selanjutnya!!");
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
            String format = "| %-2d | %-10s | %-10s | %-9d |%n";
            System.out.format("+------------------------------------------+%n");
            System.out.format("| ID | Nama       | Jabatan    | Absensi   |%n");
            System.out.format("+------------------------------------------+%n");
                // System.out.print("Nama: "+str.getNama()+" | UTS: "+str.getUts()+" | UAS: "+str.getUas()+" | TUGAS: "+str.getTugas()+" | NILAI AKHIR: \n");
                for (int i = 0; i < stf.size(); i++) {
                    System.out.format(format, stf.get(i).getId(), stf.get(i).getNama(), stf.get(i).getJabatan(), stf.get(i).getAbsensi());
                }
            System.out.println("");
            System.out.println("Press Enter untuk kembali ke Menu utama!!");
            input.nextLine();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}