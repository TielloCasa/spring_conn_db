package it.gianluca;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.gianluca_spring.Config;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		Effettua effettua = context.getBean(Effettua.class);
		System.out.println(effettua);
	}

}
