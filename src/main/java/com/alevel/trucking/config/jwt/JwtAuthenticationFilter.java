package com.alevel.trucking.config.jwt;

import com.alevel.trucking.model.user.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
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

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                request.getParameter("username"), request.getParameter("password"), new ArrayList<>());
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
