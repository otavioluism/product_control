package com.otavioluism.projeto_spring_boot.controllers;

import com.otavioluism.projeto_spring_boot.entity.UserEntity;
import com.otavioluism.projeto_spring_boot.security.JwtUtil;
import com.otavioluism.projeto_spring_boot.service.UserService;
import io.jsonwebtoken.Jwts;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody Map<String, String> request) {
        UserEntity user = this.userService.createUser(request.get("username"), request.get("password"));
        return ResponseEntity.ok().body(user);
    }


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Map<String, String> request) {
         Optional<UserEntity> user = this.userService.getByUsername(request.get("username"));
         if (user.isPresent() && user.get().getPassword().equals(request.get("password"))){
             String token = JwtUtil.generateToken(request.get("username"));
             return ResponseEntity.status(200).body(Map.of("Token", token));
         }
         return ResponseEntity.status(401).body("Credentials invalids!");
    }


}
