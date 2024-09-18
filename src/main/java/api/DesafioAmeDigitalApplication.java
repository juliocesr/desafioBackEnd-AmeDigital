package api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DesafioAmeDigitalApplication {
    public static void main(String[] args) {
        SpringApplication.run(DesafioAmeDigitalApplication.class, args);
    }
}
