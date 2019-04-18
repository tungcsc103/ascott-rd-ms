package com.tung.ms.apigateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tung.ms.apigateway.bean.auth.User;

@Service
public class UserService {

  @Autowired
  private PasswordEncoder passwordEncoder;

  public User getUserByEmail(String email) {
    User user = new User();
    user.setEmail(email);
    if (email.contains("admin")) {
      user.setPassword(passwordEncoder.encode("pass"));
      user.setAuthority(new String[] { "ADMIN", "USER" });
    } else {
      user.setPassword(passwordEncoder.encode("pass"));
      user.setAuthority(new String[] { "USER" });
    }

    return user;
  }
}
