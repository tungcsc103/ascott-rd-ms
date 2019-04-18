package com.tung.ms.apigateway.bean.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tung.ms.apigateway.exception.CustomException;
import com.tung.ms.apigateway.service.UserService;

@Service
public class AuthUserService implements UserDetailsService {
  @Autowired
  private UserService userService;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    User user = userService.getUserByEmail(email);
    if (user == null || user.getAuthority() == null || user.getAuthority().length == 0) {
      throw new CustomException("Invalid username or password.", HttpStatus.UNAUTHORIZED);
    }

    BasicUserDetails userDetails = new BasicUserDetails(user.getEmail(), user.getPassword(), 1, false, user.isExpired(),
        true, user.getAuthority());
    return userDetails;
  }

}