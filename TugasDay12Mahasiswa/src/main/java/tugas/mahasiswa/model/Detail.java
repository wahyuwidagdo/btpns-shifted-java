package tugas.mahasiswa.model;

//import javax.persistence.*;

//@Entity
//@Table(name = "detail")
public class Detail {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long id;
//    private int physics, calculus, biologi;
//    @OneToOne
//    @JoinColumn(name = "mahasiswa_id", referencedColumnName = "id")
//    private Mahasiswa mahasiswa;
//
//    public Detail(int physics, int calculus, int biologi, Mahasiswa mahasiswa) {
//        this.physics = physics;
//        this.calculus = calculus;
//        this.biologi = biologi;
//        this.mahasiswa = mahasiswa;
//    }

        long iddetail, idmhs;
        int physics, calculus, biologi;

    public Detail(long iddetail, long idmhs, int physics, int calculus, int biologi) {
        this.iddetail = iddetail;
        this.idmhs = idmhs;
        this.physics = physics;
        this.calculus = calculus;
        this.biologi = biologi;
    }

    public Detail() {

    }

    public void setIddetail(long iddetail) {
        this.iddetail = iddetail;
    }

    public long getIddetail() {
        return iddetail;
    }

    public void setIdmhs(long idmhs) {
        this.idmhs = idmhs;
    }

    public long getIdmhs() {
        return idmhs;
    }

    public void setPhysics(int physics) {
        this.physics = physics;
    }

    public int getPhysics() {
        return physics;
    }

    public void setCalculus(int calculus) {
        this.calculus = calculus;
    }

    public int getCalculus() {
        return calculus;
    }

    public void setBiologi(int biologi) {
        this.biologi = biologi;
    }

    public int getBiologi() {
        return biologi;
    }
}
