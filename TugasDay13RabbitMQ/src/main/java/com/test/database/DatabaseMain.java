package com.test.database;

import com.test.database.rabbitmq.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class DatabaseMain {
//    public static EntityManager entityManager= Persistence
//            .createEntityManagerFactory("mahasiswa-unit")
//            .createEntityManager();

    public static DatabaseRecv receive = new DatabaseRecv();

    public static void main(String[] args) {
        try{
            System.out.println(" [*] Waiting for messages..");
            receive.addMhs();
            receive.updateMhs();
            receive.absensiMhs();
        }catch (Exception e){
            System.out.println("Error DatabaseMain = " + e);
        }
    }
}
