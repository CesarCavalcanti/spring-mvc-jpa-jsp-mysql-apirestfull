package br.edu.infnet.gestaodebatalhao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GestaoDeBatalhaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestaoDeBatalhaoApplication.class, args);
    }

}
