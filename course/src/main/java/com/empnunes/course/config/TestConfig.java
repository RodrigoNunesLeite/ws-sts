package com.empnunes.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.empnunes.course.entities.User;
import com.empnunes.course.repositories.UserRepository;

// classe de configuração
@Configuration
@Profile("test") // o nome test aqui, deve ser igual ao do properties, assim o spring sabe que vamos rodar essa classe apenas para testes
public class TestConfig implements CommandLineRunner{
	
	/*
	 * @Autowired = injeçao de dependencia, essa notação serve para o spring
	 * identificar a instanciação do objeto repository dentro do testConfig
	 * */
	@Autowired
	private UserRepository userRepository;

	// executa quando a função é iniciada
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		// salva uma lista de objetos no banco
		userRepository.saveAll(Arrays.asList(u1,u2));
	}
}
