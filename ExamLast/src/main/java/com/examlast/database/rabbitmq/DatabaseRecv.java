package com.examlast.database.rabbitmq;

import com.examlast.database.service.UserDAO;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DeliverCallback;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class DatabaseRecv {

    private ConnectionFactory connectionFactory;
    private Connection connection;
    private Channel channel;
    private EntityManager entityManager;
    private UserDAO userDAO;

    public void connectJPA() {
        this.entityManager = Persistence
                .createEntityManagerFactory("user-unit")
                .createEntityManager();
        userDAO = new UserDAO(entityManager);
        try {
            entityManager.getTransaction().begin();
        } catch (IllegalAccessError e) {
            entityManager.getTransaction().rollback();
        }
    }

    public void commitJPA() {
        try {
            entityManager.getTransaction().commit();
        } catch (IllegalAccessError e) {
            entityManager.getTransaction().rollback();
        }
    }

    public void connectRabbitMQ() throws IOException, TimeoutException {
        connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connection = connectionFactory.newConnection();
    }

    public void registerUser() {
        try {
            connectRabbitMQ();
            channel = connection.createChannel();
            channel.queueDeclare("registerUser", false, false, false, null);
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String userString = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + userString + "'");
                connectJPA();
                userDAO.registerUserDAO(userString);
                commitJPA();
            };
            channel.basicConsume("registerUser", true, deliverCallback, consumerTag -> {
            });
        } catch (Exception e) {
            System.out.println("Error registerUser = " + e);
        }
    }

    /** Method untuk Login (Kurang lebih logicnya seperti ini,
     * tetapi sepertinya penempatan implementasinya salah) */
    public void loginUser() {
        try {
            connectRabbitMQ();
            channel = connection.createChannel();
            channel.queueDeclare("loginUser", false, false, false, null);
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String userString = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + userString + "'");
                connectJPA();
                userDAO.loginUserDAO(userString);
                commitJPA();
            };
            channel.basicConsume("loginUser", true, deliverCallback, consumerTag -> {
            });
        } catch (Exception e) {
            System.out.println("Error loginUser = " + e);
        }
    }

    /** Method untuk Informasi Saldo Kurang lebih logicnya seperti ini,
     * tetapi sepertinya penempatan implementasinya salah) */
    public void getInfoSaldo() {
        try {
            connectRabbitMQ();
            channel = connection.createChannel();
            channel.queueDeclare("getInfoSaldo", false, false, false, null);
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String idString = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + idString + "'");
                connectJPA();
                userDAO.getInfoSaldoDAO(idString);
                commitJPA();
            };
            channel.basicConsume("getInfoSaldo", true, deliverCallback, consumerTag -> {
            });
        } catch (Exception e) {
            System.out.println("Error getInfoSaldo = " + e);
        }
    }
}
