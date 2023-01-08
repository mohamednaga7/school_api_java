package com.mohamednagah.school_api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "School API", version = "1.0", description = "Backend API for a school"))
public class SchoolApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolApiApplication.class, args);
    }

}
