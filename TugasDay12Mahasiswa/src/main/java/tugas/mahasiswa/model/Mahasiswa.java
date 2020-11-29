package tugas.mahasiswa.model;

//import javax.persistence.*;

//@Entity
//@Table(name = "mahasiswa")
public class Mahasiswa {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long id;
//    private String fullname, address, status;
//
//    public Mahasiswa(String fullname, String address, String status) {
//        this.fullname = fullname;
//        this.address = address;
//        this.status = status;
//    }

    long idmhs;
    int absensi;
    String fullname, address, status;

    public Mahasiswa(long idmhs, String fullname, String address, String status, int absensi) {
        this.idmhs = idmhs;
        this.absensi = absensi;
        this.fullname = fullname;
        this.address = address;
        this.status = status;
    }

    public Mahasiswa() {

    }

    public void setIdmhs(long idmhs) {
        this.idmhs = idmhs;
    }

    public long getIdmhs() {
        return idmhs;
    }

    public void setAbsensi(int absensi) {
        this.absensi = absensi;
    }

    public int getAbsensi() {
        return absensi;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
