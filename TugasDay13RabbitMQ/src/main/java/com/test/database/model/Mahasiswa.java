package com.test.database.model;

import javax.persistence.*;

@Entity
@Table(name = "header")
public class Mahasiswa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String fullname, address, status;
    int absensi;

    public Mahasiswa() {}

    public Mahasiswa(Long id, String fullname, String address, String status, int absensi) {
        this.id = id;
        this.fullname = fullname;
        this.address = address;
        this.status = status;
        this.absensi = absensi;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setAbsensi(int absensi) {
        this.absensi = absensi;
    }

    public int getAbsensi() {
        return absensi;
    }
}
