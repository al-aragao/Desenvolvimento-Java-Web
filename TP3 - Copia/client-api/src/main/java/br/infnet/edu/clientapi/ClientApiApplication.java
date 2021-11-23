package br.infnet.edu.clientapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import br.infnet.edu.clientapi.services.IUserService;
import br.infnet.edu.clientapi.services.models.UserServiceModel;
import feign.codec.Decoder;
import feign.jackson.JacksonDecoder;

@SpringBootApplication
@EnableFeignClients
public class ClientApiApplication implements CommandLineRunner {

	@Autowired
	private IUserService _userService;
	
	@Bean
	public Decoder decoder() {return new JacksonDecoder();}
	
	public static void main(String[] args) {
		SpringApplication.run(ClientApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		List<UserServiceModel> users = _userService.GetAll();		
//		System.out.println(users);
	}

}
