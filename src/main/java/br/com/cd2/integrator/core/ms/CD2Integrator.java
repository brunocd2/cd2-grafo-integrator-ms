package br.com.cd2.integrator.core.ms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EntityScan(basePackages = { "br.com.cd2.integrator" })
@EnableJpaRepositories(basePackages = { "br.com.cd2.integrator" })
@ComponentScan(basePackages = {"br.com.cd2.integrator"})
public class CD2Integrator {

	public static void main(String[] args) {
		SpringApplication.run(CD2Integrator.class, args);
		
	}

}
