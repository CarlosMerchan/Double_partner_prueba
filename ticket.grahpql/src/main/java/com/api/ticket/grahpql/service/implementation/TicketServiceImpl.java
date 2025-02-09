package com.api.ticket.grahpql.service.implementation;

import com.api.ticket.grahpql.entity.Ticket;
import com.api.ticket.grahpql.entity.Users;
import com.api.ticket.grahpql.exceptions.UserValidationException;
import com.api.ticket.grahpql.graphql.InputCloseTicket;
import com.api.ticket.grahpql.graphql.InputTicket;
import com.api.ticket.grahpql.persistence.ITicketDao;
import com.api.ticket.grahpql.persistence.IUsersDao;
import com.api.ticket.grahpql.service.ITicketService;
import com.api.ticket.grahpql.utils.StatusTicket;
import com.api.ticket.grahpql.utils.ValidationEmail;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TicketServiceImpl implements ITicketService {



    @Autowired
    private ITicketDao ticketDao;
    @Autowired
    private IUsersDao usersDao;

    @Override
    @Transactional(readOnly = true)
    public Ticket findById(Long id) {
        return ticketDao.findById(id).orElseThrow( () -> new RuntimeException("Ticket not Found"));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Ticket> findAll(PageRequest pr) {
        return  ticketDao.findAll(pr);
    }



    @Override
    @Transactional
    public Long createTicket(InputTicket inputTicket) {
          Long documentNumber = Long.parseLong(inputTicket.getInputUser().getDocumentNumber());

            ValidationEmail.validateEmail(inputTicket.getInputUser().getEmail());
            Ticket ticket = Ticket.builder()
                    .description(inputTicket.getDescription())
                    .creationDate(LocalDateTime.now())
                    .status(StatusTicket.OPEN.name())
                    .build();
          if(usersDao.existsById(documentNumber)){
              ticket.setUser(usersDao.findById(documentNumber).orElse(null));
          }else {
              ticket.setUser(Users.builder()
                      .email(inputTicket.getInputUser().getEmail())
                      .firstName(inputTicket.getInputUser().getFirstName())
                      .secondName(inputTicket.getInputUser().getSecondName())
                      .documentNumber(Long.parseLong(inputTicket.getInputUser().getDocumentNumber()))
                      .lastName(inputTicket.getInputUser().getLastName())
                      .build());
          }


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
