package com.api.ticket.grahpql.service.implementation;

import com.api.ticket.grahpql.entity.Users;
import com.api.ticket.grahpql.persistence.IUsersDao;
import com.api.ticket.grahpql.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UsersServiceImpl  implements IUserService {

    @Autowired
    private IUsersDao usersDao;
    @Override
    @Transactional(readOnly = true)
    public Users findById(Long id) {
        return usersDao.findById(id).orElseThrow();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Users> findAllUsers() {
        return List.of();
    }

    @Override
    public void deleteById(Long Id) {

    }
}
