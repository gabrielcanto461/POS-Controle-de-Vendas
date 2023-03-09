package br.com.posprodutos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.SpringDataWebConfiguration;

@SpringBootApplication
public class PosProdutosApplication {

    public static void main(String[] args) {
        SpringApplication.run(PosProdutosApplication.class, args);
    }

}
