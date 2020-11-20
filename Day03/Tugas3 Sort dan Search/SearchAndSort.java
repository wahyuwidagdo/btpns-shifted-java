import java.util.*;
class SearchAndSort {
    public static void main(String args []) {
        ArrayList<Integer> datas = dataInput(21, 23, 26, 12, 15); // Inisialisasi data input
        ArrayList<Integer> dataSortir = dataSort(datas); // Inisialisasi data yang di sortir dengan method dataSort berdasarkan input dari datas
        String search = dataSearch(dataSortir, 23); // Inisialisasi data yang di search dengan method dataSearch berdasarkan hasil dataSortir
        
        // Print Hasil
        System.out.println("Data Input: " + datas);
        System.out.println("Data setelah di sortir: " + dataSortir);
        System.out.println("Data ditemukan: " + search);
    }

    // Method untuk input data
    public static ArrayList<Integer> dataInput(int data1, int data2, int data3, int data4, int data5) {
        ArrayList<Integer> data = new ArrayList<Integer>(); // Buat objek data dengan tipe data objek reference berupa arraylist integer
        data.add(data1); //Menambah data ke arraylist
        data.add(data2);
        data.add(data3);
        data.add(data4);
        data.add(data5);
        return data; //Mengembalikan nilai arraylist data
    }

    // Method untuk sortir data
    public static ArrayList<Integer> dataSort(ArrayList<Integer> sort) {
        for (int i = 0; i < sort.size() - 1; i++) {
            for (int j = 0; j < sort.size() - 1 - i; j++) {
                // System.out.print("sort[j+1] = " + sort.get(j+1));
                // System.out.print("<=>");
                // System.out.println("sort[j] = " + sort.get(j));
                if (sort.get(j + 1) < sort.get(j)) {
                    int temp = sort.get(j);
                    sort.set(j, sort.get(j + 1));
                    sort.set(j + 1, temp);
                }
            }
        }
        return sort; //Mengembalikan nilai arraylist yang sudah di sortir
    }
    
    // Method untuk search data
    public static String dataSearch(ArrayList<Integer> data, int target) {
        int left = 0;
        int middle;
        int right = data.size() - 1;
        String Hasil = target + "Data tidak ditemukan";
        while (left <= right) {
            middle = (left + right) /2;
            if (data.get(middle) == target) {
                Hasil = "Data " + target + " ditemukan pada index " + middle;
                break;
            } else if (data.get(middle) < target) {
                left = middle + 1;
            } else if (data.get(middle) > target) {
                right = middle - 1;
            }
        }
        return Hasil; //Mengembalikan hasil dari search data
    }
}