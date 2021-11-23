package br.infnet.edu.clientapi.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.infnet.edu.clientapi.services.models.UserServiceModel;

@FeignClient(url="http://localhost:8080/users", name = "userService")
public interface IUserService {

	@GetMapping("/{id}")
	UserServiceModel GetById(@PathVariable("id") Integer id);
	
	@GetMapping("/all")
	List<UserServiceModel> GetAll();
	
	@PostMapping("/add")
	UserServiceModel Add(@RequestBody UserServiceModel model);
	
	@PutMapping("/update")
	UserServiceModel Update(@RequestBody UserServiceModel model);
	
	@DeleteMapping("/{id}")
	UserServiceModel Delete(@PathVariable("id") Integer id);
}
