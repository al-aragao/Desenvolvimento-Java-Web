package br.infnet.edu.tp3.infrastructure.respository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.infnet.edu.tp3.domain.entities.User;

@Repository
public interface IUserRepository extends CrudRepository<User, Integer> {

	@Query(value="from User u where u.Email = :email and u.Password = :password")
	public User getByLogin(String email, String password);
	
	@Query(value = "from User u where u.Email =:email")
	public User getByEmail(String email);
}
