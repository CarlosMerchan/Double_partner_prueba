package com.api.ticket.grahpql.exceptions;

public class UserValidationException  extends  RuntimeException{

    public UserValidationException(String message){
        super(message);
    }
}
