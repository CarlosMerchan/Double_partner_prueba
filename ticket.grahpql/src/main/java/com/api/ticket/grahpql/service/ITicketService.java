package com.api.ticket.grahpql.service;

import com.api.ticket.grahpql.entity.Ticket;
import com.api.ticket.grahpql.graphql.InputCloseTicket;
import com.api.ticket.grahpql.graphql.InputTicket;

import java.util.List;

public interface ITicketService {

    Ticket findById(Long id);

    List<Ticket> findAll();

    Long createTicket(InputTicket inputTicket);

    void deleteById(Long id);

    void closeTicket(InputCloseTicket inputCloseTicket);
}
