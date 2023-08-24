package org.jsp.UserProductApp.exception;

public class IdNotFoundException  extends RuntimeException{
    private static final long serialVersionUID=1L;
    @Override
    public String getMessage(){
        return "The Id Is Invalid";

    }
}
