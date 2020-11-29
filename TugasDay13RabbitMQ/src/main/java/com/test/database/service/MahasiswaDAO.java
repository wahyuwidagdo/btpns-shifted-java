package com.test.database.service;

import com.google.gson.Gson;
import com.test.database.model.Mahasiswa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class MahasiswaDAO {

    private EntityManager entityManager;
    private EntityTransaction entityTransaction;
    public MahasiswaDAO() {}

    public MahasiswaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.entityTransaction = this.entityManager.getTransaction();
    }

    public void addMhsDAO(String mhsString) {
//        beginTransaction();
        Mahasiswa mhsnew = new Gson().fromJson(mhsString, Mahasiswa.class);
        entityManager.persist(mhsnew);
//        commitTransaction();
    }

    public Mahasiswa find(Long id) {
        return entityManager.find(Mahasiswa.class, id);
    }

    public void absensiDAO(String id) {
//        beginTransaction();
        Mahasiswa mhs = entityManager.find(Mahasiswa.class, Long.valueOf(id));
        int newAbsensi = mhs.getAbsensi() + 1;
        mhs.setAbsensi(newAbsensi);
//        commitTransaction();
    }

    public void updateMhsDAO(String mhsString) {
//        beginTransaction();
        Mahasiswa mhsnew = new Gson().fromJson(mhsString, Mahasiswa.class);
        Mahasiswa  mhs = entityManager.find(Mahasiswa.class, mhsnew.getId());
        mhs.setFullname(mhsnew.getFullname());
        mhs.setAddress(mhsnew.getAddress());
        mhs.setStatus(mhsnew.getStatus());
        entityManager.merge(mhs);
//        commitTransaction();
    }

//    private void beginTransaction() {
//        try {
//            entityTransaction.begin();
//        } catch (IllegalStateException e) {
//            rollbackTransaction();
//        }
//    }

//    private void commitTransaction() {
//        try {
//            entityTransaction.commit();
//            entityManager.close();
//        } catch (IllegalStateException e) {
//            rollbackTransaction();
//        }
//    }

//    private void rollbackTransaction() {
//        try {
//            entityTransaction.rollback();
//        } catch (IllegalStateException e) {
//            e.printStackTrace();
//        }
//    }
}
