package com.boot.blog.controller;

import com.boot.blog.model.Users;
import com.boot.blog.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users/")
@CrossOrigin(origins = "http://localhost:4300")
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping("all")
    public List<Users> getAll() {
        return usersService.getAll();
    }

    @GetMapping("{id}")
    public Users getUsers(@PathVariable Long id) {
        return usersService.findById(id);
    }

    @DeleteMapping("{id}")
    public Users delete(@PathVariable Long id) {
        return usersService.softDelete(id);
    }

    @PostMapping("create")
    public Users create(@RequestBody Users users) {
        return usersService.create(users);
    }
}
