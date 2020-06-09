package com.empnunes.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.empnunes.course.entities.Order;
import com.empnunes.course.entities.User;
import com.empnunes.course.entities.enums.OrderStatus;
import com.empnunes.course.repositories.OrderRepository;
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
	
	@Autowired
	private OrderRepository orderRepository;
	
	// executa quando a função é iniciada
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1); 
		
		// salva uma lista de objetos no banco
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
	}
}
