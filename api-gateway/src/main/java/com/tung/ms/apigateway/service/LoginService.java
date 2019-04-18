package com.tung.ms.apigateway.service;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tung.ms.apigateway.bean.auth.User;
import com.tung.ms.apigateway.exception.CustomException;
import com.tung.ms.apigateway.security.JwtTokenProvider;

@Service
public class LoginService {
  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private JwtTokenProvider jwtTokenProvider;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private UserService userService;

  public String login(String username, String password) {
    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
      User user = userService.getUserByEmail(username);
      if (user == null || user.getAuthority() == null || user.getAuthority().length == 0) {
        throw new CustomException("Invalid username or password.", HttpStatus.UNAUTHORIZED);
      }
      // NOTE: normally we dont need to add "ROLE_" prefix. Spring does automatically
      // for us.
      // Since we are using custom token using JWT we should add ROLE_ prefix
      String token = jwtTokenProvider.createToken(username, Arrays.asList(user.getAuthority()).stream()
          .map((String role) -> "ROLE_" + role).collect(Collectors.toList()));
      return token;

    } catch (AuthenticationException e) {
      throw new CustomException("Invalid username or password.", HttpStatus.UNAUTHORIZED);
    }
  }
}