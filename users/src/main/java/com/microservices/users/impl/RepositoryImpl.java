package com.microservices.users.impl;

import com.microservices.users.entity.Users;

public interface RepositoryImpl {
    void save(Users user);

    Users findById(int id);

    Users findByEmail(String email);
}
