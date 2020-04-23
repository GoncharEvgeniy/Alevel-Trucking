package com.alevel.trucking.config.jwt;

import com.alevel.trucking.dto.LoginForm;
import com.alevel.trucking.model.user.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final static Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

    private AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        LoginForm loginForm = null;
        try {
            loginForm = new ObjectMapper().readValue(request.getInputStream(), LoginForm.class);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                loginForm.getUsername(), loginForm.getPassword(), new ArrayList<>());
        Authentication authenticate = authenticationManager.authenticate(token);
        return authenticate;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) {
        User principal = (User) authResult.getPrincipal();
        String role = principal.getRole().getName();
        String token = JWT.create()
                .withSubject(principal.getUsername())
                .withClaim("username", principal.getUsername())
                .withClaim("role", role)
                .sign(Algorithm.HMAC512(JwtProperties.SECRET.getBytes()));
        response.addHeader(JwtProperties.HEADER_STRING, JwtProperties.TOKEN_PREFIX + token);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException failed) throws IOException {
        response.sendError((HttpServletResponse.SC_UNAUTHORIZED), failed.getMessage());
    }

}
