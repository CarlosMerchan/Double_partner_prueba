package com.api.ticket.grahpql.persistence;

import com.api.ticket.grahpql.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITicketDao extends JpaRepository<Ticket,Long> {
}
