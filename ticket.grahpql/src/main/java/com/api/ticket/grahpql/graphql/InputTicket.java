package com.api.ticket.grahpql.graphql;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InputTicket {
    private InputUser inputUser;
    private String description;
}
