package com.examlast.restapi.controller;

import com.examlast.database.model.User;
import com.examlast.restapi.rabbitmq.RestApiSend;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestApiController {

    public final Logger logger = LoggerFactory.getLogger(RestApiController.class);

    // -------------------Register a User-------------------------------------------

    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody User user) {
        try {
            RestApiSend.registerUser(new Gson().toJson(user));
        } catch (Exception e) {
            System.out.println("Error = " + e);
        }
        return new ResponseEntity<>("Register User Berhasil", HttpStatus.OK);
    }
}
