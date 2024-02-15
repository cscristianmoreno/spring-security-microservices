package com.microservices.users.dao;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.microservices.users.entity.Users;
import com.microservices.users.impl.RepositoryImpl;
import com.microservices.users.repository.UserRepository;

@Service
public class UsersDAO implements RepositoryImpl {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UsersDAO(final UserRepository userRepository, final PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void save(Users user) {
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }

    @Override
    public Users findById(int id) {
        Users user = userRepository.findById(id);
        return user;
    }

    @Override
    public Users findByEmail(String email) {
        Users user = userRepository.findByEmail(email);
        return user;
    }
    
}
