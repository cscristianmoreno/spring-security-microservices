package com.microservices.users.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.microservices.users.dao.UsersDAO;
import com.microservices.users.entity.Users;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@ResponseBody
@RequestMapping("/api/users")
public class UserController {
    
    private final UsersDAO usersDAO;

    public UserController(final UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    @PostMapping("/save")
    public String save(Users user) {
        usersDAO.save(user);
        return "El usuario fue almacenado";
    }

    @GetMapping("/find/id/{id}")
    public Users findById(@RequestParam int id) {
        Users user = usersDAO.findById(id);
        return user;
    }

    @GetMapping("/find/email/{email}")
    public Users findByEmail(@RequestParam String email) {
        Users user = usersDAO.findByEmail(email);
        return user;
    }
}
