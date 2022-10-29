package com.Zakaria.rest.webservices.restfulwebservices.jwt;

import com.Zakaria.rest.webservices.restfulwebservices.jwt.resource.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

    static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

    static {
        inMemoryUserList.add(new JwtUserDetails(1L, "in28minutes",
                "$2a$10$3zHzb.Npv1hfZbLEU5qsdOju/tk2je6W6PnNnY.c1ujWPcZh4PL6e", "ROLE_USER_2"));

        inMemoryUserList.add(new JwtUserDetails(1L, "Zakaria",
                "$2a$10$.8EYvfao5dMnsmrZJmlEfeRgYqpObC5IZOJbVgDCEDm5JgPCtA7.W", "ROLE_USER_2"));

        inMemoryUserList.add(new JwtUserDetails(1L, "Anissa",
                "$2a$10$q.PBqkftB1826zoM4u1AnuyeNiGqondN0kYPta9boby30za/gmbhi", "ROLE_USER_2"));

        //$2a$10$.8EYvfao5dMnsmrZJmlEfeRgYqpObC5IZOJbVgDCEDm5JgPCtA7.W
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
                .filter(user -> user.getUsername().equals(username)).findFirst();

        if (!findFirst.isPresent()) {
            throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
        }

        return findFirst.get();
    }

}


