package it.gianluca_spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import it.gianluca.Connessione;
import it.gianluca.Effettua;

@Configuration
@ComponentScan(basePackageClasses = Effettua.class)
public class Config {

	@Bean
	public  Connessione getConnessione() {
		return new Connessione("com.mysql.jdbc.Driver","jdbc:mysql://localhost/gestione_officina","gianluca","gianluca","SELECT * FROM veicolo WHERE 1;");
	}
}
