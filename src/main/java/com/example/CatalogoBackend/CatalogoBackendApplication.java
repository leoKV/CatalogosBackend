package com.example.CatalogoBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;

@SpringBootApplication
public class CatalogoBackendApplication implements WebServerFactoryCustomizer<ConfigurableWebServerFactory>{

	public static void main(String[] args) {
		SpringApplication.run(CatalogoBackendApplication.class, args);
	}
	
	@Override
	public void customize(ConfigurableWebServerFactory factory) {
		factory.setPort(9000);
	}

}
