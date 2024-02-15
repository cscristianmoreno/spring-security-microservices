package com.microservices.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.users.entity.Users;


@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findById(int id);

    Users findByEmail(String email);
}
