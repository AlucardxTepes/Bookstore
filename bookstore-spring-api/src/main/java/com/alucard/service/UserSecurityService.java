package com.alucard.service;

import com.alucard.domain.User;
import com.alucard.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Alucard on 12-May-17.
 */
@Service
public class UserSecurityService implements UserDetailsService {

  private static final Logger log = LoggerFactory.getLogger(UserSecurityService.class);

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username);
    if(null == user) {
      log.warn("Username {} not found", username);
      throw new UsernameNotFoundException("Username " + username + " not found");
    }
    return user;
  }
}
