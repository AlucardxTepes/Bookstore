package com.alucard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by Alucard on 12-May-17.
 */
@Component
public class SecurityUtility {

  private static final String SALT = "salt"; // TODO: Salt should be protected carefully

  @Bean
  public static BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(12, new SecureRandom(SALT.getBytes()));
  }

  @Bean
  public static String randomPassword() {
    String SALTCHARS = "ABCDEFGHIJKMNOPQRSTUVWXYZ1234567890";
    StringBuilder salt = new StringBuilder();
    Random rnd = new Random();

    while(salt.length() < 18) {
      int index = (int) (rnd.nextFloat() * SALTCHARS.length());
      salt.append(SALTCHARS.charAt(index));
    }

    return salt.toString();
  }
}
