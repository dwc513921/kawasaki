package com.csdj.dwc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DriverschoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(DriverschoolApplication.class, args);
    }

}
