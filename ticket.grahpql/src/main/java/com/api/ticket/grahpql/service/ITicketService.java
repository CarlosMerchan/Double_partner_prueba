package com.api.ticket.grahpql.service;

import com.api.ticket.grahpql.entity.Ticket;
import com.api.ticket.grahpql.graphql.InputCloseTicket;
import com.api.ticket.grahpql.graphql.InputTicket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ITicketService {

    Ticket findById(Long id);

    Page<Ticket> findAll(PageRequest pr);

    Long createTicket(InputTicket inputTicket);

    void deleteById(Long id);

    void closeTicket(InputCloseTicket inputCloseTicket);
}
