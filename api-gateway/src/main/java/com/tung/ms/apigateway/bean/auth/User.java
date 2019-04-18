package com.tung.ms.apigateway.bean.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

  private String email;
  private String password;
  private Integer active;
  private boolean isLocked;
  private boolean isExpired;
  private boolean isEnabled;
  private String[] authority;
}
