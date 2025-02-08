package com.api.ticket.grahpql.service;

import com.api.ticket.grahpql.entity.Ticket;
import com.api.ticket.grahpql.entity.Users;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.util.List;

public interface IUserService {

    Users findById(Long id);

    List<Users> findAllUsers();

    void deleteById(Long Id);
}
