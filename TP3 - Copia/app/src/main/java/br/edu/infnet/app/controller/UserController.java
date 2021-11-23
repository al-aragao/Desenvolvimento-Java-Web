package br.edu.infnet.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.app.model.CreateUserModel;
import br.edu.infnet.app.model.UpdateUserModel;
import br.edu.infnet.app.model.User;
import br.edu.infnet.app.repository.IUserRepository;
import br.edu.infnet.app.services.AmazonService;

@RestController
public class UserController {

	@Autowired
	private IUserRepository _userRepository;

	@GetMapping("/users/all")
	public List<User> get() {
		return (List<User>)_userRepository.findAll();
	}

	@GetMapping("/users/{id}")
	public Optional<User> get(@PathVariable Integer id) {
		 Optional<User> user = _userRepository.findById(id);
		return user;
	}

	@PostMapping("/users/add")
	public User post(@RequestBody CreateUserModel model) {
		
		User user = new User(model.getName(), model.getEmail(), model.getPhone(), model.getAddressCode(), model.getStreet(), model.getNumber(),
				model.getComplement(), model.getCity(), model.getDistrict(), model.getState(), model.getPassword(), model.getProfileImage());
		
		return _userRepository.save(user);
	}

	@PutMapping("/users/update")
	public User put(@RequestBody UpdateUserModel model) {
		
		Optional<User> user = _userRepository.findById(model.getId());
		
		if(user.isPresent())
		{
			User us = user.get();
			
			us.setName(model.getName()); 
			us.setEmail(model.getEmail()); 
			us.setPhone(model.getPhone());
			us.setAddressCode(model.getAddressCode()); 
			us.setStreet(model.getStreet());
			us.setNumber(model.getNumber());
			us.setComplement(model.getComplement()); 
			us.setCity(model.getCity());
			us.setDistrict(model.getDistrict()); 
			us.setState(model.getState());
			us.setPassword(model.getPassword()); 
			us.setProfileImage(model.getProfileImage());
			
			return _userRepository.save(us);
		}
		
		return null;
	}

	@DeleteMapping("/users/{id}")
	public void delete(@PathVariable Integer id) {
		_userRepository.deleteById(id);
	}

}
