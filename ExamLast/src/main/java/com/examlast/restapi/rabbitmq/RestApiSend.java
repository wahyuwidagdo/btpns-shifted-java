package com.examlast.restapi.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class RestApiSend {

    public static void registerUser(String userString) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare("registerUser", false, false, false, null);
            channel.basicPublish("", "registerUser", null, userString.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + userString + "'");
        }
    }
}
