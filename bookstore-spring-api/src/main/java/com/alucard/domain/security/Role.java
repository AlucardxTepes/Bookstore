package com.alucard.domain.security;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Alucard on 12-May-17.
 */
@Entity
public class Role implements Serializable {

  private static final long serialVersionUID = 103294L;

  @Id
  private int roleId;
  private String name;
  private Set<UserRole> userroles = new HashSet<>();

  Role() {
  }

  public int getRoleId() {
    return roleId;
  }

  public void setRoleId(int roleId) {
    this.roleId = roleId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<UserRole> getUserroles() {
    return userroles;
  }

  public void setUserroles(Set<UserRole> userroles) {
    this.userroles = userroles;
  }
}
