/** Dokumentasi
Ini merupakan program latihan 3 di hari pertama dari belajar Java di G2Academy
Author : Wahyu F. Widagdo [Edo]
Nickname : VanillaMan
CreateOn : 9 Nov 2020
 */

// Mendeklarasikan KaryawanDemo Class
class KaryawanDemo {
    /*
    Ini nama/istilahnya saya lupa, pokoknya setiap mau menjalankan program java
    pasti ada syntax public static void main
    untuk (String[] args) mungkin optional, tetapi untuk lebih jelasnya akan saya tanyakan ke pengajar besok 
    */
    public static void main(String[] args) {
        // Inisialisai/mendeklarasikan Object
        Karyawan manajer = new Karyawan();
        Karyawan supervisor = new Karyawan();
        Karyawan staff = new Karyawan();

        /* Invoke method ke Object
        Memanggil method-method yang sudah di deklarasikan di Class Karyawan 
        dan invoke ke object Karyawan manajer
        */
        manajer.setNama("Edo");
        manajer.getNama();
        manajer.setJabatan("Manajer");
        manajer.getJabatan();
        manajer.setGaji(10000000);
        manajer.getGaji();
        manajer.printStates();
        manajer.printLines();

        /* Invoke method ke Object
        Memanggil method-method yang sudah di deklarasikan di Class Karyawan 
        dan invoke ke object Karyawan supervisor
        */
        supervisor.setNama("Malin");
        supervisor.getNama();
        supervisor.setJabatan("Supervisor");
        supervisor.getJabatan();
        supervisor.setGaji(10000000/2);
        supervisor.getGaji();
        supervisor.printStates();
        supervisor.printLines();

        /* Invoke method ke Object
        Memanggil method-method yang sudah di deklarasikan di Class Karyawan 
        dan invoke ke object Karyawan staff
        */
        staff.setNama("Buyuang");
        staff.getNama();
        staff.setJabatan("Staff");
        staff.getJabatan();
        staff.setGaji(10000000/4);
        staff.getGaji();
        staff.printStates();
        staff.printLines();
    }
}