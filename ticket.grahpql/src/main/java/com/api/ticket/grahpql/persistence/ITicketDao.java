package com.api.ticket.grahpql.persistence;

import com.api.ticket.grahpql.entity.Ticket;
import com.api.ticket.grahpql.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITicketDao extends JpaRepository<Ticket,Long> {

    Page<Ticket> findAllTicketsByUser(Users users, PageRequest pr);




}
