/** Membuat class BangunRuang
Pertama kita buat dulu class bangung ruang untuk menampung state dan juga behavior/methodnya.
 */
public class BangunRuang {
    /** Membuat fungsi main
	Membuat fungsi main yang mana di fungsi yang ini pertama kali program dijalankan.
	*/
    public static void main(String args []) {
        /** Inisialisasi State/Attribut
        Analisa setiap state/attribute yang akan kita deklarasikan/inisialisasi, 
        type data apakah yang cocok untuk state tersebut.
        */
        //Ini state awal
        int panjang = 20;
        int lebar = 10;
        int tinggi = 5;
        double r = 5;
        int rusuk = 5;
        // Ini merupakan state hasil perhitungan bangun ruang
        int volumeBalok = volumeBangun(panjang, lebar, tinggi);
        double volumeBola = volumeBangun(r);
        int volumeKubus = volumeBangun(rusuk);
        //Ini merupakan hasil menghitung average dan summary
        double averages = average(volumeBalok, volumeBola, volumeKubus);
        double summaries = summary(volumeBalok, volumeBola, volumeKubus);

        /**Output Print
        Output print out hasil perhitungan
         */
        System.out.println("Volume Balok : " + volumeBalok);
        System.out.println("Volume Bola : " + volumeBola);
        System.out.println("Volume Kubus : " + volumeKubus);
        System.out.println("Average : " + averages);
        System.out.println("Summary : " + summaries);

    }

    /** Pembuatan Method 
    Pembuatan method-method untuk perhitungan volume bangun ruang dan juga average beserta summary
     */

    /**Method Overloading
    Membuat method overloading dengan nama volumeBangun, method overloading adalah method yang menggunakan nama method yang sama
    namun isi atau outpunya berbeda
    */
    
    //Method overloading untuk menghitung volume balok
    public static int volumeBangun(int panjang, int lebar, int tinggi) {
        int balok;
        balok = panjang * lebar * tinggi;
        return balok;
    }

    //Method overloading untuk menghitung volume bola
    public static double volumeBangun(double r) {
        double bola;
        bola = 3.14 * r * r * r * 4/3;
        return bola;
    }

    //Method overloading untuk menghitung volume kubus
    public static int volumeBangun(int rusuk) {
        int kubus;
        kubus = rusuk * rusuk * rusuk;
        return kubus;
    }

    /** Method Average dan Summary
    Method untuk menghitung average dan summary dipisahkan dari method overloading atas permintaan soal.
    Dikarenakan adanya perbedaan type data pada volume balok, bola, dan kubus, maka harus di parse/konvert dulu
    agar tipe datanya sama sehingga bisa dilakukan perhitungan.
     */

    //Method untuk menghitung average
    public static double average(int volumeBalok, double volumeBola, int volumeKubus) {
        double ratarata;
        ratarata = (volumeBalok + volumeBola + volumeKubus) / 3;
        return ratarata;
    }

    //Method untuk menghitung summary
    public static double summary(int volumeBalok, double volumeBola, int volumeKubus) {
        double jumlah;
        jumlah = volumeBalok + volumeBola + volumeKubus;
        return jumlah;
    }

    /** RALAT
    Ternyata tidak perlu di parse dulu ke tipe data yang sama.
    Karena ternyata tipe data integer dan double bisa dilakukan perhitungan langsung (di convert langsung/otomatis).
    Sumber : https://www.javatpoint.com/java-int-to-double
     */
}