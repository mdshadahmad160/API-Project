package org.jsp.springbootdemo.dao;
import java.util.List;
import java.util.Optional;
import org.jsp.springbootdemo.dto.User;
import org.jsp.springbootdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	
	@Autowired
	private UserRepository repository;
	
	public User saveUser(User user) {
		return repository.save(user);
	}
	public User updateUser(User user) {
		return repository.save(user);
	}
	public Optional<User> findById(int id){
		return repository.findById(id);
	}
	public void deleteUser(int id) {
		repository.deleteById(id);
	}
	public List<User> findAll(){
		 return repository.findAll() ;
	}
	public Optional<User> verifyUser(long phone,String password){
		return repository.verifyUser(phone, password);
	}
	public Optional<User> verifyUser(String email,String password){
		return repository.verifyUser(email, password);
	}

}
