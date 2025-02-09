package com.api.ticket.grahpql.controllers;

import com.api.ticket.grahpql.entity.Ticket;
import com.api.ticket.grahpql.entity.Users;
import com.api.ticket.grahpql.graphql.InputUser;
import com.api.ticket.grahpql.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ControllerUser {
    @Autowired
    private IUserService userService;


    @QueryMapping
    public Users findUserById(@Argument String userId){
        return userService.findById(Long.parseLong(userId));
    }

    @QueryMapping
    public Page<Ticket>  findTicketsForUser(@Argument String userId,@Argument int page, @Argument int size){
        PageRequest pr = PageRequest.of(page,size);
        return userService.findTicketsByUsers(Long.parseLong(userId),pr);
    }

    @MutationMapping
    public String updateUser(@Argument InputUser inputUser){
       return userService.updateUser(inputUser);

    }
}
