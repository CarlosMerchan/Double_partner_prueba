package com.api.ticket.grahpql.graphql;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InputCloseTicket {

    private String idTicket;
    private String descriptionSolution;
}
