package br.infnet.edu.tp3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.infnet.edu.tp3.domain.entities.User;
import br.infnet.edu.tp3.infrastructure.respository.IUserRepository;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private IUserRepository _userRepository;
	
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
	
		_userRepository.save(new User("Thiago Aragão", "tbaragao@gmail.com", "(21) 9-9136-9912", "21921680", "Rua muiatuca 51 - Cobertura 304", "123456"));
		_userRepository.save(new User("Enzo Aragão", "enzo.tuzu@gmail.com", "(21) 9-9136-9912", "21921680", "Rua muiatuca 51 - Cobertura 304", "123456"));
		
	}

}
