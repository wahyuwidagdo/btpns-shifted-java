import java.io.*;
class Mahasiswa {
    String id = "";
    String nama = "";
    String gender = "";

    Mahasiswa(String id, String nama, String gender) {
        this.id = id;
        this.nama = nama;
        this.gender = gender;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}

public class MahasiswaWrite {
    public static void main(String args[]) {
        Mahasiswa mhs1 = new Mahasiswa("001", "Miruno", "laki");
        Mahasiswa mhs2 = new Mahasiswa("002", "Saburo", "Angee");
        Mahasiswa mhs3 = new Mahasiswa("003", "Uchiha Bayu", "bijuu");

        String[] mahasiswas = {
            "ID : " + mhs1.getId() + " Nama : " + mhs1.getNama() + " Gender : " + mhs1.getGender(), 
            "ID : " + mhs2.getId() + " Nama : " + mhs2.getNama() + " Gender : " + mhs2.getGender(), 
            "ID : " + mhs3.getId() + " Nama : " + mhs3.getNama() + " Gender : " + mhs3.getGender()
        };
        String output = mahasiswas[0] + "\n" + mahasiswas[1] + "\n" + mahasiswas[2];
        try {
            FileOutputStream fout = new FileOutputStream("./home/flathat/mahasiswa.txt");
            FileInputStream fin = new FileInputStream("./home/flathat/mahasiswa.txt");
            BufferedOutputStream bout = new BufferedOutputStream(fout);
            byte b[] = output.getBytes();
            bout.write(b);
            bout.flush();
            bout.close();
            fout.close();
            System.out.println("Sukses");
            int i = 0;
            while((i=fin.read())!=-1){    
                System.out.print((char)i);    
                } 
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}