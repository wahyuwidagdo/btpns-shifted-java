class Car {
    String merek = "Tesla";
    String warna = "Dark Grey";
    int gigi = 0;
    int kecepatan = 10;

    void tambahGigi(int increment) {
        gigi = gigi + increment;
    }

    void kurangGigi(int decrement) {
        gigi = gigi - decrement;
    }

    void mengerem(int decrement) {
        kecepatan = decrement;
    }

    void printStates() {
        System.out.println("gigi : " + gigi + " kecepatan : " + kecepatan);
    }
}