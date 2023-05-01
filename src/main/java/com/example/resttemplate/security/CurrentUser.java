package com.example.resttemplate.security;

import com.example.resttemplate.model.User;
import org.springframework.security.core.authority.AuthorityUtils;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private final User user;

    public CurrentUser(User user) {
        super(user.getEmail(), user.getPassword(), AuthorityUtils.NO_AUTHORITIES);
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
