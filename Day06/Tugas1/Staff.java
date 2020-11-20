class Staff extends Worker {
    // String jabatan;
    int tunjanganMakan;

    Staff(int id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    // public String getJabatan() {
    //     return jabatan;
    // }

    void hitungTunjanganMakan() {
        this.tunjanganMakan = this.absensi * 20000;
    }

    public int getTunjanganMakan() {
        return this.tunjanganMakan;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return this.nama;
    }

    public void setTunjanganPulsa(int tunjanganPulsa) {
        this.tunjanganPulsa = tunjanganPulsa;
    }

    public int getTunjanganPulsa() {
        return this.tunjanganPulsa;
    }

    public void setGajiPokok(int gajiPokok) {
        this.gajiPokok = gajiPokok;
    }

    public int getGajiPokok() {
        return this.gajiPokok;
    }

    void tambahAbsensi() {
        this.absensi += 1;
    }

    public int getAbsensi() {
        return this.absensi;
    }

    int hitungGajiTotal() {
         this.gajiTotal = this.gajiPokok + this.tunjanganPulsa + this.tunjanganMakan;
         return this.gajiTotal;
    }

    public void setGajiTotal(int gajiTotal) {
        this.gajiTotal = gajiTotal;
    }

    public int getGajiTotal() {
        return this.gajiTotal;
    }

}