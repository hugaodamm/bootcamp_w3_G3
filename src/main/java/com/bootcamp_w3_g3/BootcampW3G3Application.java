package com.bootcamp_w3_g3;

import com.bootcamp_w3_g3.model.entity.Armazem;
import com.bootcamp_w3_g3.service.ArmazemService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BootcampW3G3Application implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(BootcampW3G3Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        System.out.println(bc.encode("123"));
    }
}
