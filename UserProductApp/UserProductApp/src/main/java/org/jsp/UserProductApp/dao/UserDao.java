package org.jsp.UserProductApp.dao;

import org.aspectj.apache.bcel.classfile.Module;
import org.jsp.UserProductApp.dto.User;
import org.jsp.UserProductApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDao {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }
    public User updateUser(User user){
       return userRepository.save(user);
    }
    public Optional<User> findById(int id){
        return userRepository.findById(id);
    }
    public void deleteUser(int id){
        userRepository.deleteById(id);
    }
    public List<User> findAll(){
        return userRepository.findAll();
    }
    public Optional<User> verifyUser(long phone,String password){
        return userRepository.verifyUser(phone,password);
    }
    public Optional<User> verifyUser(String email,String password){
        return userRepository.verifyUser(email,password);
    }
}
