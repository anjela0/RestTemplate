package com.example.resttemplate.endpoint;

import com.example.resttemplate.dto.*;
import com.example.resttemplate.mapper.UserMapper;
import com.example.resttemplate.model.User;
import com.example.resttemplate.security.CurrentUser;
import com.example.resttemplate.service.MailService;
import com.example.resttemplate.service.UserService;
import com.example.resttemplate.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserEndpoint {

    private final UserService userService;

    private final UserMapper userMapper;

    private final MailService mailService;

    private final PasswordEncoder passwordEncoder;

    private final JwtTokenUtil tokenUtil;

    @DeleteMapping("/user")
    public ResponseEntity<?> delete(@RequestBody UserDeleteDto userDeleteDto, @AuthenticationPrincipal CurrentUser currentUser) {
        log.info("endpoint /user called by {}", currentUser.getUser().getEmail());
        Optional<User> byEmail = userService.findByEmail(userDeleteDto.getEmail());
        if (byEmail.isEmpty()) {
            ResponseEntity.notFound().build();
        }
        userService.delete(byEmail.get());
        log.info("endpoint /user completed by {}", currentUser.getUser().getEmail());
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/user")
    public ResponseEntity<?> update(@RequestBody UserUpdateDto userUpdateDto) {
        Optional<User> byId = userService.findById(userUpdateDto.getId());
        if (byId.isEmpty()) {
            ResponseEntity.notFound().build();
        }
        userService.update(userMapper.map(userUpdateDto));
        return ResponseEntity.ok().build();
    }

    @PostMapping("/user")
    public ResponseEntity<?> register(@RequestBody UserCreateDto userCreateDto) {
//        log.info("endpoint /user called by {}", currentUser.getUser().getEmail());
        userCreateDto.setPassword(passwordEncoder.encode(userCreateDto.getPassword()));
        mailService.sendEmail(userCreateDto.getEmail(), "Hi " + userCreateDto.getName(), "Congratulations, you are registered!");
        return ResponseEntity.ok(userService.save(userMapper.map(userCreateDto)));
    }

    @PostMapping("/user/auth")
    public ResponseEntity<?> auth(@RequestBody UserAuthDto userAuthDto) {
        Optional<User> byEmail = userService.findByEmail(userAuthDto.getEmail());
        if (byEmail.isPresent()) {
            User user = byEmail.get();
            if (passwordEncoder.matches(userAuthDto.getPassword(), user.getPassword())) {
//                log.info("User with username {} get auth token", user.getEmail());
                return ResponseEntity.ok(UserAuthResponseDto.builder()
                        .token(tokenUtil.generateToken(user.getEmail()))
                        .user(userMapper.map(user))
                        .build());
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }



}
