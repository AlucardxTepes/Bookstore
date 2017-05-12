package com.alucard.service;

import com.alucard.domain.User;
import com.alucard.domain.security.UserRole;
import com.alucard.repository.RoleRepository;
import com.alucard.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by Alucard on 12-May-17.
 */
@Service
public class UserServiceImpl implements UserService {

  private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Transactional
  @Override
  public User createUser(User user, Set<UserRole> userRoles) {
    User localUser = userRepository.findByUsername(user.getUsername());

    if(localUser != null) {
      log.info("User with username {} already exists. No action taken", user.getUsername());
    } else {
      for(UserRole ur : userRoles){
        roleRepository.save(ur.getRole());
      }
      user.getUserRoles().addAll(userRoles);
      localUser = userRepository.save(user);
    }
    return localUser;
  }
}
