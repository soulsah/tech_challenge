package br.com.fiap.postech.soat.techchallenger1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication()
public class Techchallenger1Application {

	public static void main(String[] args) {
		SpringApplication.run(Techchallenger1Application.class, args);
	}

}
