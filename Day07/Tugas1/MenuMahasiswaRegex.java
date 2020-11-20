import java.io.*;
import java.util.*;
import java.util.regex.*;

public class MenuMahasiswaRegex {
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Mahasiswa> mhs = new ArrayList<Mahasiswa>();
    public static void main(String[] args) {
        try {
            System.out.println(" ");
            System.out.println("===========================");
            System.out.println("***********LOGIN***********");
            System.out.println("===========================");
            System.out.println(" ");
            System.out.print("Username : " );
            String loginUsername = scan.nextLine();
            if (Pattern.matches("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$", loginUsername)) {
                System.out.print("Password : ");
                String loginPassword = scan.nextLine();
                if (Pattern.matches("^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$", loginPassword)) {
                    FileReader frusername = new FileReader(".\\username.txt");
                    int i = 0;
                    String username = "";
                    while((i = frusername.read())!=-1)
                        username += (char)i;
                    frusername.close();
                    FileReader frpassword  = new FileReader(".\\password.txt");
                    i = 0;
                    String password = "";
                    while((i = frpassword.read())!=-1)
                        password += (char)i;
                    frpassword.close();
                    System.out.println(username);
                    System.out.println(password);
                    if(loginUsername.equals(username) && loginPassword.equals(password)){
                        menus();
                    } else {
                        System.out.println("Format username dan password salah.");
                    }
                } else {
                    System.out.println("Format Password salah.");
                }
            } else {
                System.out.println("Format Username/email salah.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void menus() {
        String menu = "0";
        while(!menu.equals("4")) {
            System.out.println(" ");
            System.out.println("============================");
            System.out.println("************MENU************");
            System.out.println("============================");
            System.out.println(" ");
            System.out.println("1. Create or Input Mahasiswa");
            System.out.println("2. Edit or Delete Mahasiswa");
            System.out.println("3. Laporan Nilai Mahasiswa");
            System.out.println("4. Exit");
            System.out.println("===============================");
            System.out.print("Pilih menu [1/2/3/4] = ");
            menu = scan.nextLine();
            System.out.println("===============================");
            System.out.println(" ");
            switch(Integer.parseInt(menu)) {
                case 1:
                    createMahasiswa();
                break;
                case 2:
                    editOrDelete();
                break;
                case 3:
                    laporanMahasiswa();
                break;
            }
        }
    }

    public static void createMahasiswa() {
        try {
            System.out.println("");
            System.out.println("=======================");
            System.out.println("*Buat Object Mahasiswa*");
            System.out.println("=======================");
            System.out.println("");
            System.out.print("ID          : ");
            int id = Integer.parseInt(scan.nextLine());
            System.out.print("Nama        : ");
            String nama = scan.nextLine();
            System.out.print("Nilai Bahasa Inggris   : ");
            Double bhsInggris = Double.parseDouble(scan.nextLine());
            System.out.print("Nilai Fisika   : ");
            Double fisika = Double.parseDouble(scan.nextLine());
            System.out.print("Nilai Algoritma : ");
            Double algoritma = Double.parseDouble(scan.nextLine());
            Mahasiswa mahasiswa = new Mahasiswa(id, nama, bhsInggris, fisika, algoritma);
            mhs.add(mahasiswa);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void editOrDelete() {
        try {
            String menu = "0";
            while (Integer.parseInt(menu) != 3) {
                System.out.println("");
                System.out.println("=================================");
                System.out.println("*Edit or Delete Object Mahasiswa*");
                System.out.println("=================================");
                System.out.println("");
                System.out.println("1. Edit Mahasiswa");
                System.out.println("2. Hapus Mahasiswa");
                System.out.println("3. Back");
                System.out.println("");
                System.out.print("Pilih Menu [1/2/3] : ");
                menu = scan.nextLine();
                switch (Integer.parseInt(menu)) {
                    case 1:
                        editMahasiswa();
                        break;
                    case 2:
                        deleteMahasiswa();
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void editMahasiswa() {
        try {
            System.out.println("Masukkan ID : ");
            int idEdit = Integer.parseInt(scan.nextLine());
            Mahasiswa mahasiswaEdit = mhs.get(BinarySearch(mhs, idEdit));
            System.out.println("");
            System.out.println("==================");
            System.out.println("Data Sebelumnya : ");
            System.out.println("==================");
            System.out.println("");
            System.out.println("ID          : " + idEdit);
            System.out.println("Nama        : " + mahasiswaEdit.getNama());
            System.out.println("Nilai UTS   : " + mahasiswaEdit.getNilai(0));
            System.out.println("Nilai UAS   : " + mahasiswaEdit.getNilai(1));
            System.out.println("Nilai Tugas : " + mahasiswaEdit.getNilai(2));
            System.out.println("");
            System.out.print("Nama : ");
            String editNama = scan.nextLine();
            System.out.print("Nilai Bahasa Inggris : ");
            Double editBhsInggris = Double.parseDouble(scan.nextLine());
            System.out.print("Nilai Fisika : ");
            Double editFisika = Double.parseDouble(scan.nextLine());
            System.out.print("Nilai Algoritma : ");
            Double editAlgoritma = Double.parseDouble(scan.nextLine());
            mahasiswaEdit.setNama((editNama));
            mahasiswaEdit.nilai.set(0, editBhsInggris);
            mahasiswaEdit.nilai.set(1, editFisika);
            mahasiswaEdit.nilai.set(2, editAlgoritma);
            System.out.println("");
            System.out.print("Tekan Enter!");
            scan.nextLine();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void deleteMahasiswa() {
        try {
            System.out.println("");
            System.out.print("Masukkan ID Mahasiswa : ");
            int idDelete = Integer.parseInt(scan.nextLine());  
            mhs.remove(BinarySearch(mhs, idDelete));
            System.out.println("");
            System.out.print("Tekan Enter!");
            scan.nextLine();
            
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public static void laporanMahasiswa() {
        try {
            BubleSort(mhs);
            System.out.println("");
            System.out.println("Laporan Data Mahasiswa");
            String formatTable = "| %-10s | %.1f       | %.1f    | %.1f       |%n";
            System.out.format("+------------+------------+---------+-----------+%n");
            System.out.format("| NAMA       | B.Inggris  | Fisika  | Algoritma |%n");
            System.out.format("+------------+------------+---------+-----------+%n");
            Iterator itr = mhs.iterator();
            while(itr.hasNext()){  
                Mahasiswa data = (Mahasiswa)itr.next();
                System.out.format(formatTable, data.getNama(), data.getNilai(0), data.getNilai(1), data.getNilai(2));
            }
            System.out.format("+------------+------------+---------+-----------+%n");
            System.out.println("");
            System.out.print("Tekan Enter!");
            scan.nextLine();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void BubleSort(ArrayList<Mahasiswa> List) {
        for (int i = 0; i < List.size() - 1; i++) {
            for (int j = 0; j < List.size() - 1 - i; j++) {
                if (List.get(j + 1).getId() < List.get(j).getId()) {
                    Mahasiswa temp = List.get(j);
                    List.set(j, List.get(j+1));
                    List.set(j+1, temp);
                }
            }
        }
    }

    public static int BinarySearch(ArrayList<Mahasiswa> List, int id) {
        BubleSort(List);
        int target = id; // the element to be searched
        int left = 0;
        int middle = 0;
        int right = List.size() - 1;
        while (left <= right) {
            middle = (left + right) / 2;
            if (List.get(middle).getId() == target) {
                break;
            } else if (List.get(middle).getId() < target) {
                left = middle + 1;
            } else if (List.get(middle).getId() > target) {
                right = middle - 1;
            }
        }
        return middle;
    }
}