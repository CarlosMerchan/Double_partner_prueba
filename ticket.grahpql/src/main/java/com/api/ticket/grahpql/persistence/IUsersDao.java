package com.api.ticket.grahpql.persistence;

import com.api.ticket.grahpql.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsersDao extends JpaRepository<Users,Long> {
}
