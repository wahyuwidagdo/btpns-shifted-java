class MahasiswaDemo {
    public static void main(String[] args) {
        Mahasiswa Udin = new Mahasiswa();
        Mahasiswa Ucup = new Mahasiswa();

        Udin.setNama("Udin");
        Udin.getNama();
        Udin.setJK("Laki Cyn");
        Udin.getJK();
        Udin.setUmur(23);
        Udin.getUmur();
        Udin.printStates();
        Udin.printLines();

        Ucup.setNama("Ucup");
        Ucup.getNama();
        Ucup.setJK("Tom-Dee");
        Ucup.getJK();
        Ucup.setUmur(23);
        Ucup.getUmur();
        Ucup.printStates();
    }
}