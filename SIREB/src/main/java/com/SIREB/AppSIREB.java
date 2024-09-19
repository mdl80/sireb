package com.SIREB;

import com.SIREB.controladores.ControladorUsuarioContraseña;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class AppSIREB {
	public static void main(String[] args) {
		SpringApplication.run(AppSIREB.class, args);
    System.out.println("A la espera de bomberos, spring funcionando");
            
	}

}
