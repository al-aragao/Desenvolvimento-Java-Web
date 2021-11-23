package br.infnet.edu.clientapi.controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.infnet.edu.clientapi.services.AmazonService;

@RestController
@RequestMapping("File")
public class FileController {

	@Autowired
	private AmazonService _amazonService;
	
	@GetMapping
	public List<String> getAllFileNames(){
		return _amazonService.getAllFileNames();
	}
	
	@GetMapping("/{fileName}")
	public File getAllFileNames(@PathVariable(name = "fileName") String fileName) throws IOException{
		return _amazonService.getFile(fileName);
	}
	
	@PostMapping
	public String post(@RequestPart(value="file") MultipartFile file){
		_amazonService.save(file);
		return "The file '" + file.getName() + "' was saved succesfully";
	}
	
	@DeleteMapping
	public String delete(@RequestPart(value = "fileName") String fileName){
		_amazonService.delete(fileName);
		return "The file '" + fileName + "' was deleted succesfully";
	}
}
