package com.examlast.database;

import com.examlast.database.rabbitmq.DatabaseRecv;

public class DatabaseMain {

    public static DatabaseRecv receive = new DatabaseRecv();

    public static void main(String[] args) {
        try {
            System.out.println(" [*] Waiting for messages..");
            receive.registerUser();
        } catch (Exception e) {
            System.out.println("Error DatabaseMain = " + e);
        }
    }
}
