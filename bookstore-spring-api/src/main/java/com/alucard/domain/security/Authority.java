package com.alucard.domain.security;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

/**
 * Created by Alucard on 12-May-17.
 */
public class Authority implements GrantedAuthority, Serializable {

  private static final long serialVersionUID = 123123L;
  private final String authority;

  public Authority(String authority) {
    this.authority = authority;
  }

  @Override
  public String getAuthority() {
    return authority;
  }
}
