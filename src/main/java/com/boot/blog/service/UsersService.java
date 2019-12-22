package com.boot.blog.service;

import com.boot.blog.model.Users;

import java.util.List;

public interface UsersService {

    List<Users> getAll();

    Users softDelete(Long id);

    Users create(Users users);

    Users findById(Long id);
}
