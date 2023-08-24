package org.jsp.UserProductApp.dao;

import lombok.Data;

@Data
public class ResponseStructure<T>{
    private T data;
    private String message;
    private int statusCode;
}
