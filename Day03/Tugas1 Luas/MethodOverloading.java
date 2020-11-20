public class MethodOverloading {
    public static void main(String[] args) {
        int sisi = 0;
        int alas = 0;
        int tinggi = 0;
        double r = 0;
        double phi = 3.14;
        int result1 = luasBangun(sisi);
        int result2 = luasBangun(alas, tinggi);
        double result3 = luasBangun(r, phi);

        System.out.println("Luas Persegi = " + result1);
        System.out.println("Luas Segitiga = " + result2);
        System.out.println("Luas Lingkaran = " + result3);
    }

    // Untuk Persegi
    public static int luasBangun(int sisi) {
        int persegi;
        persegi = sisi * 2;
        return persegi;
    }

    public static int luasBangun(int alas, int tinggi) {
        int segitiga;
        segitiga = alas * tinggi / 2;
        return segitiga;
    }

    public static double luasBangun(double phi, double r) {
        double lingkaran;
        lingkaran = phi * Math.pow(r, 2);
        return lingkaran;
    }
}