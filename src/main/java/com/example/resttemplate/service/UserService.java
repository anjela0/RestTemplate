package com.example.resttemplate.service;

import com.example.resttemplate.model.Client;
import com.example.resttemplate.model.User;
import com.example.resttemplate.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }

    public void update(User user) {
        save(user.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .password(user.getPassword())
                .build());
    }
}
