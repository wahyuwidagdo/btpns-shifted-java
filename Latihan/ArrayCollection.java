import java.util.*;
class Mahasiswas {
    String ID = "";
    String nama = "";
    String gender = "";

    Mahasiswas(String ID, String nama, String gender) {
        this.ID = ID;
        this.nama = nama;
        this.gender = gender;
    }
}

public class ArrayCollection {
    public static void main(String[] args) {
        // Buat object Mahasiswa
        Mahasiswas mhs1 = new Mahasiswas("001", "Miruno", "laki");
        Mahasiswas mhs2 = new Mahasiswas("002", "Saburo", "Angee");
        Mahasiswas mhs3 = new Mahasiswas("003", "Uchiha Bayu", "bijuu");

        // Buat ArrayList
        // ArrayList<Student> al=new ArrayList<Student>();
        // ArrayList<Mahasiswas> al=new ArrayList<Mahasiswas>();
        ArrayList<Mahasiswas> aru = new ArrayList<Mahasiswas>();
        aru.add(mhs1); //Adding Mahasiswas class object
        aru.add(mhs2);
        aru.add(mhs3);

        // Nge-get Iterator
        Iterator itr = aru.iterator();
        
        // Melintasi element dari objek ArrayList
        while(itr.hasNext()) {
            Mahasiswas mh = (Mahasiswas)itr.next();
            System.out.println(mh.ID + " " + mh.nama + " " + mh.gender);
        }
    }
}