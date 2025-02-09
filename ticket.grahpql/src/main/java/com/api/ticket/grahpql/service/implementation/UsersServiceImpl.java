package com.api.ticket.grahpql.service.implementation;

import com.api.ticket.grahpql.entity.Ticket;
import com.api.ticket.grahpql.entity.Users;
import com.api.ticket.grahpql.exceptions.UserValidationException;
import com.api.ticket.grahpql.graphql.InputUser;
import com.api.ticket.grahpql.persistence.ITicketDao;
import com.api.ticket.grahpql.persistence.IUsersDao;
import com.api.ticket.grahpql.service.IUserService;
import com.api.ticket.grahpql.utils.ValidationEmail;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UsersServiceImpl  implements IUserService {

    @Autowired
    private IUsersDao usersDao;
    @Autowired
    private ITicketDao ticketDao;
    @Override
    @Transactional(readOnly = true)
    public Users findById(Long id) {
        return usersDao.findById(id).orElseThrow(() -> new UserValidationException("User not Found"));
    }

    @Override
    public Page<Ticket> findTicketsByUsers(Long userId, PageRequest pr) {
        Users user = findById(userId);
        return ticketDao.findAllTicketsByUser(user,pr);
    }

    @Override
    public String updateUser(InputUser inputUser) {
        Users user = findById(Long.parseLong(inputUser.getDocumentNumber()));
         ValidationEmail.validateEmail(inputUser.getEmail());
            user.setEmail(inputUser.getEmail());
            user.setLastName(inputUser.getLastName());
            user.setFirstName(inputUser.getFirstName());
            user.setSecondName(inputUser.getSecondName().isBlank()? user.getSecondName() : inputUser.getSecondName());
            usersDao.save(user);


        return "The user has been updated.";
    }





}
