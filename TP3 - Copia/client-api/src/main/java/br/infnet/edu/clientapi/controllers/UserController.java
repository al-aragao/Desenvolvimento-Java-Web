package br.infnet.edu.clientapi.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import br.infnet.edu.clientapi.services.AmazonService;
import br.infnet.edu.clientapi.services.ICepService;
import br.infnet.edu.clientapi.services.IUserService;
import br.infnet.edu.clientapi.services.models.AddressServiceModel;
import br.infnet.edu.clientapi.services.models.Test;
import br.infnet.edu.clientapi.services.models.UserServiceModel;

@Controller
public class UserController {

	@Autowired
	private AmazonService _amazonService;

	@Autowired
	private IUserService _userService;

	@GetMapping(value = "/")
	public String MainPage(Model model) {

		model.addAttribute("users", _userService.GetAll());

		return "main.html";
	}

	@PostMapping
	public String post(@RequestPart(value = "file") MultipartFile file, @RequestPart(value = "name") String name) {
		System.out.println(name);

		_amazonService.save(file);

		return "redirect:/";
	}

	@GetMapping(value = "/user")
	public String UserPage(Model model) {

		model.addAttribute("errors", new ArrayList<String>());

		return "user.html";
	}


	@PostMapping(value="/user")
	public String createUser(
			@RequestPart(value = "file") MultipartFile file, 
			UserServiceModel model) {
		
		model.setProfileImage(_amazonService.getFileName(file));
		_userService.Add(model);
		_amazonService.save(file);
		
		return "redirect:/";
	}

	@GetMapping(value = "/{fileName}")
	public HttpEntity<byte[]> Download(@PathVariable(value = "fileName") String fileName) throws IOException {

		File file = _amazonService.getFile(fileName);
		
		byte[] bytes = Files.readAllBytes(file.toPath());
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		header.setContentLength(bytes.length);
		header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName.replace(" ", "_"));

		return new HttpEntity<byte[]>(bytes, header);
	}

	@GetMapping(value = "/delete/{id}")
	public String Delete(@PathVariable(value = "id") Integer id) {

		UserServiceModel user = _userService.GetById(id);
		
		_userService.Delete(id);
		_amazonService.delete(user.getProfileImage());

		return "redirect:/";
	}

	@GetMapping(value = "/view/{id}")
	public String ViewPage(Model model, @PathVariable(value = "id") Integer id) throws IOException {

		UserServiceModel user = _userService.GetById(id);
				
		File file = _amazonService.getFile(user.getProfileImage());
		byte[] bytes = Files.readAllBytes(file.toPath());
		
		user.setProfileImageBase64(Base64.getEncoder().encodeToString(bytes));
		
		model.addAttribute("user", user);

		return "view.html";
	}

	@GetMapping(value = "/edit/{id}")
	public String EditPage(Model model, @PathVariable(value = "id") Integer id) throws IOException {

		UserServiceModel user = _userService.GetById(id);
				
		File file = _amazonService.getFile(user.getProfileImage());
		byte[] bytes = Files.readAllBytes(file.toPath());
		
		user.setProfileImageBase64(Base64.getEncoder().encodeToString(bytes));
		
		model.addAttribute("user", user);

		return "edit.html";
	}



	@PostMapping(value="/edit")
	public String editUser(
			@RequestPart(value = "file") MultipartFile file, 
			UserServiceModel model) {
		
		if(file.isEmpty() == false)
		{
			model.setProfileImage(_amazonService.getFileName(file));
			_amazonService.save(file);
		}
		
		_userService.Update(model);
		
		return "redirect:/";
	}

}
