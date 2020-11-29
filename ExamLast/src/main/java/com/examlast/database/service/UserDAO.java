package com.examlast.database.service;

import com.examlast.database.model.User;
import com.google.gson.Gson;

import javax.persistence.EntityManager;

public class UserDAO {

    private EntityManager entityManager;

    public UserDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.entityManager.getTransaction();
    }

    public void registerUserDAO(String userString) {
        User newUser = new Gson().fromJson(userString, User.class);
        entityManager.persist(newUser);
    }

    public User find(Long id) {
        return entityManager.find(User.class, id);
    }

    /** Method UserDAO untuk Login (Kurang lebih logicnya seperti ini,
     * tetapi sepertinya penempatan implementasinya salah) */
    public void loginUserDAO(String userString) {
        User newUser = new Gson().fromJson(userString, User.class);
        User user = entityManager.find(User.class, Long.valueOf(newUser.getId()));
        user.setEmail(newUser.getEmail());
        user.setPassword(newUser.getPassword());
        entityManager.persist(user);
    }

    /** Method UserDAO untuk Informasi Saldo Kurang lebih logicnya seperti ini,
     * tetapi sepertinya penempatan implementasinya salah) */
    public void getInfoSaldoDAO(String id) {
        User user = entityManager.find(User.class, Long.valueOf(id));
        int infoSaldo = user.getSaldo();
    }


}
