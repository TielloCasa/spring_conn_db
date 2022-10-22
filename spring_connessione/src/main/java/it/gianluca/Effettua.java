package it.gianluca;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.ToString;

@Component
@Data
@ToString
public class Effettua {

	Connessione connessione = new Connessione();
}
