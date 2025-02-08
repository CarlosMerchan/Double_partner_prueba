package com.api.ticket.grahpql.service.implementation;

import com.api.ticket.grahpql.entity.Ticket;
import com.api.ticket.grahpql.entity.Users;
import com.api.ticket.grahpql.graphql.InputCloseTicket;
import com.api.ticket.grahpql.graphql.InputTicket;
import com.api.ticket.grahpql.persistence.ITicketDao;
import com.api.ticket.grahpql.service.ITicketService;
import com.api.ticket.grahpql.utils.StatusTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketServiceImpl implements ITicketService {

    @Autowired
    private ITicketDao ticketDao;

    @Override
    @Transactional(readOnly = true)
    public Ticket findById(Long id) {
        return ticketDao.findById(id).orElseThrow();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Ticket> findAll() {
        return  ticketDao.findAll();
    }

    @Override
    @Transactional
    public Long createTicket(InputTicket inputTicket) {
        Ticket ticket = Ticket.builder()
                .user(Users.builder()
                        .email(inputTicket.getInputUser().getEmail())
                        .firstName(inputTicket.getInputUser().getFirstName())
                        .secondName(inputTicket.getInputUser().getSecondName())
                        .documentNumber(inputTicket.getInputUser().getDocumentNumber())
                        .lastName(inputTicket.getInputUser().getLastName())
                        .build())
                .description(inputTicket.getDescription())
                .creationDate(LocalDateTime.now())
                .status(StatusTicket.OPEN.name())
                .build();
        ticket = ticketDao.save(ticket);
        return ticket.getId();
    }

    @Override
    public void deleteById(Long id) {
        ticketDao.deleteById(id);
    }

    @Override
    public void closeTicket(InputCloseTicket inputCloseTicket) {
        Ticket ticket = ticketDao.findById(Long.parseLong(inputCloseTicket.getIdTicket())).orElseThrow();
        ticket.setSolution(inputCloseTicket.getDescriptionSolution());
        ticket.setUpdateDate(LocalDateTime.now());
        ticket.setStatus(StatusTicket.CLOSE.name());
        ticketDao.save(ticket);
    }
}
