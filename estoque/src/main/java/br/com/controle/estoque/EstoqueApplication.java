package br.com.controle.estoque;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EstoqueApplication {

	private static final Logger logger = LoggerFactory.getLogger(EstoqueApplication.class);

	public static void main(String[] args) {
		logger.info("Iniciando a API de Controle de Estoque!");
		SpringApplication.run(EstoqueApplication.class, args);
		logger.info("API de Controle de Estoque inciada e pronta para receber requisições!!!");
	}

}
