package com.student.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(){
        super ("Resource not available");
    }

    public ResourceNotFoundException(String message){
        super(message);
    }

}
