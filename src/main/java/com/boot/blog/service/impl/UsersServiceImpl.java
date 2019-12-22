package com.boot.blog.service.impl;

import com.boot.blog.dao.UsersRepository;
import com.boot.blog.model.Users;
import com.boot.blog.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Users> getAll() {
        return usersRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Users softDelete(Long id) {
        Users user = usersRepository.findById(id).get();
        user.setDeletedOn(new Date());
        usersRepository.save(user);
        return user;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Users create(Users users) {
        return usersRepository.save(users);
    }

    @Transactional(readOnly = true)
    @Override
    public Users findById(Long id) {
        return usersRepository.findById(id).get();
    }


}
