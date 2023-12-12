package br.com.fiap.postech.soat.techchallenger1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class Techchallenger1Application {

	public static void main(String[] args) {
		SpringApplication.run(Techchallenger1Application.class, args);
	}

}