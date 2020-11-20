// Membuat Objek class Siswa
class Siswa {
    // Inisialisasi State
    String nama = "";
    int nilai = 80;
    String gender = "";
    private int umur = 0;
    private int day = 0;
	private int month = 0;
	private int year = 0;
    private int histori = 0;
    // private int histori = [1998, 1999, 2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009
    //                     2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020];

    // Buat Contructor
    public Siswa(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /** Contructor yang tidak dibutuhkan(tidak terpakai)
    // public Siswa(Siswa date) {
    //     this.day = date.day;
    //     this.month = date.month;
    //     this.year = date.year;
    // }
    */

    // Method/behavior untuk umur dari perhitungan lahir
    public int getUmur(int thisYear) {
        this.umur = thisYear - this.year;
        return this.umur;
    }

    // Method/behavior untuk memiliki nilai huruf
    void printNilai() {
        // String retNilai;
        if (this.nilai >=  80) {
            System.out.println("Nilai " + nilai + " = A");
            // retNilai = "A";
        } else  if (this.nilai >= 70) {
            System.out.println("Nilai : B");
            // retNilai = "B";
        } else if (this.nilai >= 60) {
            System.out.println("Nilai : C");
            //  retNilai = "C";
        } else {
            System.out.println("Nilai : D");
        }
    }

    // Method/behavior untuk memiliki kelas berdasarkan umur
    void kelas() {
        if (this.umur == 15) {
            System.out.println("SMA Kelas 1");
        } else if (this.umur == 16) {
            System.out.println("SMA Kelas 2");
        } else if (this.umur == 17) {
            System.out.println("SMA Kelas 3");
        } else if (this.umur == 18) {
            System.out.println("Kuliah Tingkat 1");
        } else if (this.umur == 19) {
            System.out.println("Kuliah Tingkat 2");
        } else if (this.umur == 20) {
            System.out.println("Kuliah Tingkat 3");
        } else if (this.umur == 21) {
            System.out.println("Kuliah Tingkat Akhir");
        } else if (this.umur == 22) {
            System.out.println("Mahasiswa Abadi");
        } else if (this.umur >= 23) {
            System.out.println(umur + " -> Sudah lulus, sedang bekerja");
        }
    }

    // Method/behavior untuk memiliki format tanggal lahir berupa string
    void formatTanggal() {
        int month = 3;
        String monthString;
        switch (month) {
            case 1 : monthString = "Januari";
                    break;
            case 2 : monthString = "Februari";
                    break;
            case 3 : monthString = "Maret";
                    break;
            case 4 : monthString = "April";
                    break;
            case 5 : monthString = "Mei";
                    break;
            case 6 : monthString = "Juni";
                    break;
            case 7 : monthString = "Juli";
                    break;
            case 8 : monthString = "Agustus";
                    break;
            case 9 : monthString = "September";
                    break;
            case 10 : monthString = "Oktober";
                    break;
            case 11 : monthString = "November";
                    break;
            case 12 : monthString = "Desember";
                    break;
            default : monthString = "What Month ?";
                    break;
        }
        System.out.println("3 " + monthString + " 1997");
    }

    // Method/behavior untuk bisa print history umur sejak lahir
    int printHistory(int history) {
        this.histori = history - this.year;
        return this.histori;
        // for (this.histori; histori.length; histori++) {
        //     System.out.println(histori + " -> " + histori.length + " Tahun");
        // }
    }
}