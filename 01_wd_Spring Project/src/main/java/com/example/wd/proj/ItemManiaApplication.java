package com.example.wd.proj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ItemManiaApplication {
    final static Logger log =
            LoggerFactory.getLogger(ItemManiaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ItemManiaApplication.class, args);
    }
}
