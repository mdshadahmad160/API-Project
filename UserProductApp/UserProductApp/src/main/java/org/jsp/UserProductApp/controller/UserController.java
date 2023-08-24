package org.jsp.UserProductApp.controller;

import java.util.List;
import java.util.Optional;
import org.hibernate.sql.Update;
import org.jsp.UserProductApp.dao.ResponseStructure;
import org.jsp.UserProductApp.dto.User;
import org.jsp.UserProductApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController

public class UserController {

//	@Autowired
//	private UserRepository repository;

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }



    @PutMapping("/users")
    public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user){
        return userService.updateUser(user);

    }

    @GetMapping("/users/{id}")
    public ResponseEntity<ResponseStructure<User>> findById(@PathVariable int id){
        return userService.findById(id);
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<ResponseStructure<String>> deleteUser(@PathVariable int id){
        return userService.deleteUser(id);
    }

    @GetMapping("/users")
    public ResponseEntity<ResponseStructure<List<User>>> findAll(){
        return userService.findAll();
    }

    @GetMapping("/users/verifyByphone")
    public ResponseEntity<ResponseStructure<User>> verifyUser(@RequestParam long phone, @RequestParam String password){
        return userService.verifyUser(phone, password);
    }

    @GetMapping("/users/verifyByemail")
    public ResponseEntity<ResponseStructure<User>> verifyUser(@RequestParam String email, @RequestParam String password){
        return userService.verifyUser(email, password);
    }




}
