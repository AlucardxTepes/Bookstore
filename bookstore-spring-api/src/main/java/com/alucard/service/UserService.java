package com.alucard.service;

import com.alucard.domain.User;
import com.alucard.domain.security.UserRole;

import java.util.Set;

/**
 * Created by Alucard on 12-May-17.
 */
public interface UserService {

  User createUser(User user, Set<UserRole> userRoles);
}
