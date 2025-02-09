package com.api.ticket.grahpql.service;

import com.api.ticket.grahpql.entity.Ticket;
import com.api.ticket.grahpql.entity.Users;
import com.api.ticket.grahpql.graphql.InputUser;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IUserService {

    Users findById(Long id);

    Page<Ticket> findTicketsByUsers(Long userId,PageRequest pr);

    String updateUser(InputUser inputUser);
}
