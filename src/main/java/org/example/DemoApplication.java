package org.example;  // <--- CAMBIA ESTA LÍNEA

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/")
    public String home() {
        logger.info("Solicitud recibida - Todo OK");
        return "Microservicio Operativo v1.0";
    }

    @GetMapping("/error-test")
    public String triggerError() {
        logger.error("ALERTA: Fallo crítico invocado.");
        throw new RuntimeException("Falla simulada IE6");
    }
}