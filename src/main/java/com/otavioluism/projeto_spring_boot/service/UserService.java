package com.otavioluism.projeto_spring_boot.service;

import com.otavioluism.projeto_spring_boot.entity.UserEntity;
import com.otavioluism.projeto_spring_boot.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }


    public UserEntity createUser(String username, String password) {
        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setPassword(this.passwordEncoder.encode(password));
        return this.userRepository.save(user);
    }

    public Optional<UserEntity> getByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }



}
