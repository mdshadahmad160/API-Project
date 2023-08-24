package org.jsp.springbootdemo.service;

import java.util.List;
import java.util.Optional;

import org.jsp.springbootdemo.exception.InvalidCredentialsException;
import org.jsp.springbootdemo.dao.UserDao;
import org.jsp.springbootdemo.dto.ResponseStructure;
import org.jsp.springbootdemo.dto.User;
import org.jsp.springbootdemo.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public ResponseEntity<ResponseStructure<User>> saveUser(User user){
		ResponseStructure<User> structure=new ResponseStructure<>();
		structure.setData(userDao.saveUser(user));
		structure.setMessage("User Saved With Id : "+user.getId());
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.CREATED);
		
	}
	public ResponseEntity<ResponseStructure<User>> updateUser(User user){
		ResponseStructure<User> structure=new ResponseStructure<>();
		structure.setData(userDao.updateUser(user));
		structure.setMessage("User Updated: ");
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.ACCEPTED);
	}
	public ResponseEntity<ResponseStructure<User>> findById(int id){
		ResponseStructure<User> structure=new ResponseStructure<>();
		Optional<User> recUser=userDao.findById(id);
		if(recUser.isPresent()) {
			structure.setMessage("User Found: ");
			structure.setData(recUser.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
	public ResponseEntity<ResponseStructure<String>> deleteUser(int id){
		ResponseStructure<String> structure=new ResponseStructure<>();
		Optional<User> recUser=userDao.findById(id);
		if(recUser.isPresent()) {
			structure.setData("User Found: ");
			structure.setMessage("User Deleted: ");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
	public ResponseEntity<ResponseStructure<List<User>>> findAll(){
		ResponseStructure<List<User>> structure=new ResponseStructure<>();
		structure.setData(userDao.findAll());
		structure.setMessage("List Of Users: ");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<User>>>(structure,HttpStatus.OK);
	}
	

	public ResponseEntity<ResponseStructure<User>> verifyUser(long phone, String password) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		Optional<User> recUser = userDao.verifyUser(phone, password);
		if (recUser.isPresent()) {
			structure.setData(recUser.get());
			structure.setMessage("User verified Succesfully");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}
		throw new InvalidCredentialsException();
	}

	public ResponseEntity<ResponseStructure<User>> verifyUser(String email, String password) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		Optional<User> recUser = userDao.verifyUser(email, password);
		if (recUser.isPresent()) {
			structure.setData(recUser.get());
			structure.setMessage("User verified Succesfully");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}
		throw new InvalidCredentialsException();
	}

}
