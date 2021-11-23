package br.edu.infnet.app.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import br.edu.infnet.app.model.User;

@Repository
public interface IUserRepository extends CrudRepository<User, Integer> {
	
//	private static List<User> _users = new ArrayList<>();
//	
//	public User save(User user) {		
//		user.setId(_users.size() + 1);
//		
//		_users.add(user);
//		
//		return user;
//	}
//	
//	public User get(Integer id) {
//		if(id == null)
//		{
//			return null;
//		}
//		
//		for (User user : _users) {
//			if(user.getId().equals(id))
//			{
//				return user;
//			}			
//		}
//		
//		return null;
//	}
//	
//	public void delete(Integer id) {
//		User user = get(id);
//		
//		if(user != null) {
//			_users.remove(user);
//		}
//	}
//	
//	public User update(Integer id, String name) {
//		User user = get(id);
//		
//		if(user != null) {
//			user.setName(name);
//		}
//		
//		return user;
//	}
//	
//	public List<User> getAll() {
//		return _users;
//	}
//	

}
