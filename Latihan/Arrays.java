class Mahasiswa {
    String ID = "";
    String nama = "";
    String gender = "";

    public Mahasiswa(String ID, String nama, String gender) {
        this.ID = ID;
        this.nama = nama;
        this.gender = gender;
    }

    String getID() {
        return ID;
    }

    String getNama() {
        return nama;
    }

    String getGender() {
        return gender;
    }
}

public class Arrays {
    public static void main(String[] args) {
        Mahasiswa[] abadi = {
        new Mahasiswa("123456789", "Saburo", "Laki"),
        new Mahasiswa("345123455", "Nobure", "Cherry"),
        new Mahasiswa("345123455", "Poak e Coy", "Samyaan")
        };

        for (int i = 0; i < abadi.length; i++) {
            System.out.println("ID " + abadi[i].getID() + "Nama " + abadi[i].getNama() + "Gender " + abadi[i].getGender());
        }
    }
}