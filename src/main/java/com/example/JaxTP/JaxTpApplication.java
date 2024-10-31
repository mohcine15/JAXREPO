package com.example.JaxTP;



import com.example.JaxTP.Entity.Compte;
import com.example.JaxTP.Entity.TypeCompte;
import com.example.JaxTP.Repository.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class JaxTpApplication {

	public static void main(String[] args) {
		SpringApplication.run(JaxTpApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CompteRepository compteRepository
	){
		return args -> {
			compteRepository.save(new Compte(null, 9000, new Date(), TypeCompte.COURANT));
			compteRepository.save(new Compte(null, 6000, new Date(), TypeCompte.EPARGNE));
			compteRepository.save(new Compte(null, 3000, new Date(), TypeCompte.COURANT));
			compteRepository.findAll().forEach(c->{
				System.out.println(c.toString());
			});
		};
	}
}
