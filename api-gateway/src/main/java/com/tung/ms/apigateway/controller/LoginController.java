package com.tung.ms.apigateway.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tung.ms.apigateway.bean.auth.AuthResponse;
import com.tung.ms.apigateway.bean.auth.LoginRequest;
import com.tung.ms.apigateway.service.LoginService;

@Controller
@RequestMapping("/api")
public class LoginController {

  @Autowired
  private LoginService loginService;

  @PostMapping("/signin")
  @ResponseBody
  public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
    String token = loginService.login(loginRequest.getUsername(), loginRequest.getPassword());
    HttpHeaders headers = new HttpHeaders();
    List<String> headerlist = new ArrayList<>();
    List<String> exposeList = new ArrayList<>();
    headerlist.add("Content-Type");
    headerlist.add(" Accept");
    headerlist.add("X-Requested-With");
    headerlist.add("Authorization");
    headers.setAccessControlAllowHeaders(headerlist);
    exposeList.add("Authorization");
    headers.setAccessControlExposeHeaders(exposeList);
    headers.set("Authorization", token);
    return new ResponseEntity<AuthResponse>(new AuthResponse(token), headers, HttpStatus.CREATED);
  }

  @GetMapping("/version")
  @Secured(value = "ROLE_ADMIN")
  public ResponseEntity<?> version() {
    return new ResponseEntity(Collections.singletonMap("version", "1"), HttpStatus.OK);
  }

}