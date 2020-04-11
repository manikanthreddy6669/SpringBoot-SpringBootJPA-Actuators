package com.example.exceptions;

@SuppressWarnings("serial")
public class IdAlreadyExistsException extends RuntimeException {
	public IdAlreadyExistsException(String msg){
        super(msg);
    }
}
