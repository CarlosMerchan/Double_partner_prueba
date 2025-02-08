package com.api.ticket.grahpql.controllers;

import com.api.ticket.grahpql.entity.Ticket;
import com.api.ticket.grahpql.graphql.InputCloseTicket;
import com.api.ticket.grahpql.graphql.InputTicket;
import com.api.ticket.grahpql.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ControllerTicket {
    @Autowired
    private ITicketService ticketService;

    @QueryMapping(name="findTicketById")
    public Ticket findById(@Argument(name="ticketId") String id){
        Long ticketId = Long.parseLong(id);
        return  ticketService.findById(ticketId);
    }

    @QueryMapping
    public List<Ticket> findAllTickets(){
        return  ticketService.findAll();
    }


    @MutationMapping
    public String createTicket(@Argument InputTicket inputTicket){
        Long idTicket = ticketService.createTicket(inputTicket);

        return  "El Ticket ha sido creado satisfactoriamente, se puede realizar seguimiento con el siguiente codigo: ".concat(String.valueOf(idTicket));
    }

    @MutationMapping
    public String deleteTicket(@Argument String idTicket){
        ticketService.deleteById(Long.parseLong(idTicket));
        return  "El Ticket con numero: ".concat(idTicket).concat(" sido eliminado satisfactoriamente");
    }

    @MutationMapping
    public String closeTicket(@Argument InputCloseTicket inputCloseTicket ){
        ticketService.closeTicket(inputCloseTicket);
        return  "El Ticket con numero: ".concat(inputCloseTicket.getIdTicket()).concat(" ha sido cerrado satisfactoriamente");
    }
}
