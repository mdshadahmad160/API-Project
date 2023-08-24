package org.jsp.UserProductApp.exception;

import org.jsp.UserProductApp.dao.ResponseStructure;
import org.jsp.UserProductApp.dao.UserDao;
import org.jsp.UserProductApp.exception.IdNotFoundException;
import org.jsp.UserProductApp.exception.InvalidCredentialException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UserBootAppExceptionHandler extends ResponseEntityExceptionHandler {
    @Autowired
    private UserDao userDao;

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> handleIdNotFoundException(IdNotFoundException exception) {
        ResponseStructure<String> structure = new ResponseStructure<>();
        structure.setData("User Not Found: ");
        structure.setMessage(exception.getMessage());
        structure.setStatusCode(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);

    }





    @ExceptionHandler(InvalidCredentialException.class)
    public ResponseEntity<ResponseStructure<String>> handleICE(InvalidCredentialException exception){
        ResponseStructure<String> structure = new ResponseStructure<>();
        structure.setData("user Not found");
        structure.setMessage(exception.getMessage());
        structure.setStatusCode(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
    }


}

