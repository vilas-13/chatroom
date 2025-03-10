package com.goldencat.chatroom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
public class ChatroomApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ChatroomApplication.class, args);
    }
}
