package com.api.ticket.grahpql.graphql;

import lombok.Data;

@Data
public class InputUser {

    private String documentNumber;
    private String firstName;
    private String secondName;
    private String lastName;
    private String email;
}

