class SiswaDemo {
    public static void main(String[] args) {
        Siswa murid = new Siswa(31, 3, 1997);
        int myAge  = murid.getUmur(2020);
        int myHistory = murid.printHistory(1998);

        System.out.println("31 - 3 - 1997 -> " + myAge);
        murid.printNilai();
        murid.kelas();
        murid.formatTanggal();
        System.out.println(1998 + " -> " +myHistory + " Tahun");
        // murid.printHistory();
    }
}