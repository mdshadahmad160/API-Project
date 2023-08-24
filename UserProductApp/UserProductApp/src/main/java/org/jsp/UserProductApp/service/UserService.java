package org.jsp.UserProductApp.service;

import org.jsp.UserProductApp.dao.ResponseStructure;
import org.jsp.UserProductApp.dao.UserDao;

import org.jsp.UserProductApp.dto.User;
import org.jsp.UserProductApp.exception.IdNotFoundException;
import org.jsp.UserProductApp.exception.InvalidCredentialException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
        ResponseStructure<User> structure = new ResponseStructure<>();
        structure.setData(userDao.saveUser(user));
        structure.setMessage("User Saved With Id: " + user.getId());
        structure.setStatusCode(HttpStatus.CREATED.value());
        return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.CREATED);
    }

    public ResponseEntity<ResponseStructure<User>> updateUser( User user) {
        ResponseStructure<User> structure = new ResponseStructure<>();
        structure.setData(userDao.updateUser(user));
        structure.setMessage("User Updated Successfully: ");
        structure.setStatusCode(HttpStatus.ACCEPTED.value());
        return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.ACCEPTED);
    }

    public ResponseEntity<ResponseStructure<User>> findById(int id) {
        ResponseStructure<User> structure = new ResponseStructure<>();
        Optional<User> recUser = userDao.findById(id);
        if (recUser.isPresent()) {
            structure.setData(recUser.get());
            structure.setMessage("User Found: ");
            structure.setStatusCode(HttpStatus.OK.value());
            return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
        }
        throw new IdNotFoundException();
    }

    public ResponseEntity<ResponseStructure<String>> deleteUser( int id) {
        ResponseStructure<String> structure = new ResponseStructure<>();
        Optional<User> recUser = userDao.findById(id);
        if (recUser.isPresent()) {
            structure.setData("User Found: ");
            structure.setMessage("User Deleted : ");
            structure.setStatusCode(HttpStatus.OK.value());
            userDao.deleteUser(id);
            return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
        }else{
            structure.setData("User Not Found: ");
            structure.setMessage("User Deleted: ");
            structure.setStatusCode(HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<ResponseStructure<List<User>>> findAll(){
        ResponseStructure<List<User>> structure=new ResponseStructure<>();
        structure.setData(userDao.findAll());
        structure.setMessage("List Of User: ");
        structure.setStatusCode(HttpStatus.OK.value());
        return new ResponseEntity<ResponseStructure<List<User>>> (structure,HttpStatus.OK);
    }
    public ResponseEntity<ResponseStructure<User>> verifyUser(long phone,String password) {
        ResponseStructure<User> structure = new ResponseStructure<>();
        Optional<User> recUser = userDao.verifyUser(phone, password);
        if (recUser.isPresent()) {
            structure.setData(recUser.get());
            structure.setMessage("User Verified With Phone And Password : ");
            structure.setStatusCode(HttpStatus.OK.value());
            return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
        }
        throw new InvalidCredentialException();
    }
    public ResponseEntity<ResponseStructure<User>> verifyUser(String email,String password){
        ResponseStructure<User> structure=new ResponseStructure<>();
        Optional<User> recUser=userDao.verifyUser(email,password);
        if (recUser.isPresent()){
            structure.setData(recUser.get());
            structure.setMessage("User Verified With Email And Password: ");
            structure.setStatusCode(HttpStatus.OK.value());
            return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
        }
        throw new InvalidCredentialException();
    }

}
