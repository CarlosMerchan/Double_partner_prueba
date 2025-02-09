package com.api.ticket.grahpql.utils;

import com.api.ticket.grahpql.exceptions.UserValidationException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationEmail {

    private static final String EMAIL_REGEX = "^[^@]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    public static void validateEmail(String email) throws UserValidationException {


        // Crea un objeto Pattern usando la expresión regular
        Pattern pattern = Pattern.compile(EMAIL_REGEX);

        // Crea un Matcher que se utilizará para verificar si el correo cumple con la expresión regular
        Matcher matcher = pattern.matcher(email);

        // Retorna si el correo coincide con el patrón
        if(!matcher.matches()){
            throw  new UserValidationException("The email entered is not valid");
        }
    }
}
