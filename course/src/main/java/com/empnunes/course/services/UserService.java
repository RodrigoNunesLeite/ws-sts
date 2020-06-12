package com.empnunes.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empnunes.course.entities.User;
import com.empnunes.course.repositories.UserRepository;

// preciso identificar(registrando como um component) minha classe pra ser possivel
// injeta-lo em outra classe e devolver o resultado em um response

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		// findbyid retorna um optional
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	public User insert(User obj) {
		// o save ja retorna o objeto salvo
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		// o getOne não vai no banco ainda, ele instancia o objeto e 
		// esse objeto fica monitorado pelo JPA
		User entity = repository.getOne(id);
		/*
		 * O valor obj é atribuido ao objeto entity
		 * */
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
	
}
