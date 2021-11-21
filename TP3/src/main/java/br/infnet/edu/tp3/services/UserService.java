package br.infnet.edu.tp3.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.infnet.edu.tp3.domain.entities.User;
import br.infnet.edu.tp3.infrastructure.respository.IUserRepository;

@Service
public class UserService {
	
	@Autowired
	private IUserRepository _userRepository;
	
	public List<String> add(User user, String confirmPassword) {
				
		if(user.IsValid(confirmPassword)) {
			_userRepository.save(user);
		}
				
		return user.GetValidationErrors();
	}
	
	public Optional<User> getById(Integer id){
		return _userRepository.findById(id);
	}

	public User getByLogin(String email, String password) {		
		return _userRepository.getByLogin(email, password);
	}
	
//	public User getByEmail(String email) {
//		return _userRepository.getByEmail(email);
//	}
	
	public List<User> getAll() {
		return (List<User>)_userRepository.findAll();
	}
}
