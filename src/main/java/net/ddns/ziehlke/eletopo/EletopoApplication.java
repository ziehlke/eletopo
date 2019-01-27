package net.ddns.ziehlke.eletopo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

@SpringBootApplication
public class EletopoApplication {
	public static void main(String[] args) {
		SpringApplication.run(EletopoApplication.class, args);
	}

}

