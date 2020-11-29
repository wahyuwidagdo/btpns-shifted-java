package com.codeflex.springboot.model;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class Staff extends Worker {

    private static final AtomicLong counter = new AtomicLong();

    int tunjanganMakan;

    ArrayList email = new ArrayList();

    Staff() {
        this.id = counter.incrementAndGet();
    }

//    Staff(long id, String name, ArrayList email) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//    }

    public void setTunjanganMakan(int tunjanganMakan) {
        this.tunjanganMakan = this.absensi * 20000;
    }

    public int getTunjanganMakan() {
        return this.tunjanganMakan;
    }

    public ArrayList<String> getEmail() {
        return this.email;
    }

    public void setEmail(ArrayList<String> email) {
        this.email = email;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getTunjanganPulsa() {
        return this.tunjanganPulsa;
    }

    @Override
    public void setTunjanganPulsa(int tunjanganPulsa) {
        this.tunjanganPulsa = tunjanganPulsa;
    }

    @Override
    public int getGajiPokok() {
        return this.gajiPokok;
    }

    @Override
    public void setGajiPokok(int gajiPokok) {
        this.gajiPokok = gajiPokok;
    }

    @Override
    public int getAbsensi() {
        return this.absensi;
    }

    @Override
    public void tambahAbsensi() {
        this.absensi += 1;
    }

    @Override
    public String toString() {
        return "Staff [id=" + id + ", name=" + name + ", absensi=" + this.absensi
                + ", tunjanganPulsa=" + this.tunjanganPulsa
                + ", tunjanganMakan=" + this.tunjanganMakan
                + ", gajiPokok=" + this.gajiPokok + "]";
    }
}
