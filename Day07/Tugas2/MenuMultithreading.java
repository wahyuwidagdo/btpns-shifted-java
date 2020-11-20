import java.util.*;
import java.io.*;

public class MenuMultithreading {
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Mahasiswa> mhs = new ArrayList<Mahasiswa>();
    public static void main(String args []) {
        try {
            menu();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void menu() {
        String menu = "0";
        try {
            while(Integer.parseInt(menu) != 4) {
                System.out.println("");
                System.out.println("======================");
                System.out.println("*********Menu*********");
                System.out.println("======================");
                System.out.println("");
                System.out.println("1. Create or Input Mahasiswa");
                System.out.println("2. Tampilkan Laporan Data Mahasiswa");
                System.out.println("3. Tampilkan Laporan Mahasiswa dan Tulis ke File (Thread)");
                System.out.println("4. Exit");
                System.out.println("");
                System.out.print("Pilih Menu [1/2/3/4] : ");
                menu = scan.nextLine();
                switch(Integer.parseInt(menu)) {
                    case 1:
                        createMahasiswa();
                    break;
                    case 2:
                        tampilkanLaporan();
                    break;
                    case 3:
                        printLaporan();
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
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

    public static void tampilkanLaporan() {
        try {
            BubbleSort(mhs);
            PrintToScreen pts = new PrintToScreen(mhs);
            pts.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void printLaporan(){
        BubbleSort(mhs);
        PrintToScreen Thread1 = new PrintToScreen(mhs);
        Print Thread2 = new Print(mhs);
        Thread1.start();
        Thread2.start();
    }

    public static void BubbleSort(ArrayList<Mahasiswa> List){
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
        BubbleSort(List);
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