import java.util.*;
import java.io.*;

public class MenuKaryawan {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Staff> stf = new ArrayList<Staff>();
    static ArrayList<Manager> mnj = new ArrayList<Manager>();
    public static void main(String args []) {
        String menu = "0";
        while (Integer.parseInt(menu) != 6) { // lakukan while untuk pemilihan menu
            System.out.println(" ");
            Scanner input = new Scanner(System.in); // Menggunakan(Inisialisasi) class scanner untuk mengambil nilai input
            System.out.println("============================");
            System.out.println("************MENU************");
            System.out.println("============================");
            System.out.println(" ");
            System.out.println("1. Tambah Data Karyawan");
            System.out.println("2. Tambah Absensi Karyawan");
            System.out.println("3. Hitung Tunjangan");
            System.out.println("4. Hitung Total Gaji");
            System.out.println("5. Laporan Gaji");
            System.out.println("6. Exit");
            System.out.println("===============================");
            System.out.print("Pilih menu [1/2/3/4/5/6] = ");
            menu = input.nextLine();
            System.out.println("===============================");
            System.out.println(" ");

            switch (Integer.parseInt(menu)) {
                case 1:
                    createKaryawan();
                    break;
                case 2:
                    addAbsensi();
                break;
                case 3:
                    hitungTunjangan();
                break;
                case 4:
                    hitungGaji();
                break;
                case 5:
                    laporanGaji();
                break;
            }
        }
    }

    public static void createKaryawan() {
        String nama, menu = "0";
        int id;
        while(!menu.equals("3")) {
            try {
                System.out.println("Tambah Karyawan");
                System.out.println("=====================");
                System.out.println("");
                System.out.println("1. Tambah Manager");
                System.out.println("2. Tambah Staff");
                System.out.println("3. << Back\n");
                System.out.print("Input Pilihan : ");
                menu = input.nextLine();
                switch(Integer.parseInt(menu)) {
                    case 1:
                        System.out.print("Input ID Karyawan : ");
                        id = Integer.parseInt(input.nextLine());
                        System.out.print("Input Nama : ");
                        nama = input.nextLine();
                        Manager manager = new Manager(id, nama);
                        mnj.add(id, manager);
                    break;
                    case 2:
                        System.out.print("Input ID Karyawan : ");
                        id = Integer.parseInt(input.nextLine());
                        System.out.print("Input Nama : ");
                        nama = input.nextLine();
                        Staff staff = new Staff(id, nama);
                        stf.add(id, staff);
                    break;

                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void addAbsensi() {
        String menu = "0";
        int id;
        while(!menu.equals("3")) {
            try {
                System.out.println("Tambah Absensi");
                System.out.println("=====================");
                System.out.println("");
                System.out.println("1. Absensi Manager");
                System.out.println("2. Absensi Staff");
                System.out.println("3. << Back\n");
                System.out.print("Input Pilihan : ");
                menu = input.nextLine();
                switch(Integer.parseInt(menu)) {
                    case 1:
                        System.out.print("Input ID Karyawan : ");
                        id = Integer.parseInt(input.nextLine());
                        mnj.get(id).tambahAbsensi();
                    break;
                    case 2:
                        System.out.print("Input ID Karyawan : ");
                        id = Integer.parseInt(input.nextLine());
                        stf.get(id).tambahAbsensi();
                    break;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void hitungTunjangan() {
        String menu = "0";
        int id = 0;
        while(!menu.equals("3")) {
            try {
                System.out.println("Hitung Tunjangan");
                System.out.println("=====================");
                System.out.println("");
                System.out.println("1. Tunjangan Manager");
                System.out.println("2. Tunjangan Staff");
                System.out.println("3. << Back\n");
                System.out.print("Input Pilihan : ");
                menu = input.nextLine();
                switch(Integer.parseInt(menu)) {
                    case 1:
                        String submenu = "0";
                        while(!submenu.equals("3")) {
                            System.out.println("");
                            System.out.println("Tunjangan Manager");
                            System.out.println("=====================");
                            System.out.println("");
                            System.out.println("1. Tunjangan Transport");
                            System.out.println("2. Tunjangan Entertaint");
                            System.out.println("3. << Back\n");
                            System.out.print("Input Pilihan : ");
                            submenu = input.nextLine();
                            switch(Integer.parseInt(submenu)) {
                                case 1:
                                    System.out.print("Input ID : ");
                                    id = Integer.parseInt(input.nextLine());
                                    mnj.get(id).hitungTunjanganTransport();
                                break;
                                case 2:
                                    System.out.print("Input ID : ");
                                    id = Integer.parseInt(input.nextLine());
                                    System.out.print("Input Jumlah Entertaint : ");
                                    int jumlah = Integer.parseInt(input.nextLine());
                                    mnj.get(id).hitungTunjanganEntertaint(jumlah);
                                break;
                            }
                        }
                    break;
                    case 2:
                        System.out.print("Input ID Karyawan : ");
                        id = Integer.parseInt(input.nextLine());
                        stf.get(id).hitungTunjanganMakan();
                    break;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void hitungGaji() {
        String menu = "0";
        while(!menu.equals("3")) {
            try {
                System.out.println("Hitung Total Gaji");
                System.out.println("=====================");
                System.out.println("");
                System.out.println("1. Total Gaji Manager");
                System.out.println("2. Total Gaji Staff");
                System.out.println("3. << Back\n");
                System.out.print("Input Pilihan : ");
                menu = input.nextLine();
                switch(Integer.parseInt(menu)) {
                    case 1:
                        for (Manager manager : mnj) {
                            manager.setGajiTotal(manager.hitungGajiTotal());
                        }
                        System.out.print("Berhasil Mendapatkan Total! Tekan Enter! ");
                        input.nextLine();
                    break;
                    case 2:
                        for (Staff staff : stf) {
                            staff.setGajiTotal(staff.hitungGajiTotal());
                        }
                        System.out.print("Berhasil Mendapatkan Total! Tekan Enter! ");
                        input.nextLine();
                    break;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void laporanGaji() {
        try {
            String output = "";
            String format = "| %-2d | %-11s | %-10s | %-5d   | %-1d    |%n";
            output += output.format("+----+-------------+------------+---------+------------+%n");
            output += output.format("| ID |  Nama       | Jabatan    | Absensi | Gaji Total |%n");
            output += output.format("+----+-------------+------------+---------+------------+%n");
            for (int i = 0; i < mnj.size(); i++) {
                output += output.format(format, mnj.get(i).getId(), mnj.get(i).getNama(), "Manager", mnj.get(i).getAbsensi(), (mnj.get(i).getGajiPokok() + mnj.get(i).getTunjanganPulsa() + mnj.get(i).getTunjanganTransport() + mnj.get(i).getTunjanganEntertaint()));
            }
            output += output.format("+----+-------------+------------+---------+------------+%n");
            for (int i = 0; i < stf.size(); i++) {
                output += output.format(format, stf.get(i).getId(), stf.get(i).getNama(), "Staff", stf.get(i).getAbsensi(), (stf.get(i).getGajiPokok() + stf.get(i).getTunjanganPulsa() + stf.get(i).getTunjanganPulsa()));
            }
            output += output.format("+----+-------------+------------+---------+------------+%n");
            System.out.println(output);
            FileWriter fw=new FileWriter(".\\Karyawan.txt");
            fw.write(output);
            fw.close();
            System.out.print("Tekan Enter!");
            input.nextLine();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}