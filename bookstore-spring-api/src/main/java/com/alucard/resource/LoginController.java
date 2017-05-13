package com.alucard.resource;

import com.alucard.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Alucard on 12-May-17.
 */
@RestController
public class LoginController {

  @Autowired
  private UserService userService;

  @RequestMapping("/token")
  public Map<String, String> token(HttpSession session, HttpServletRequest request) {
    System.out.println(request.getRemoteHost());
    String remoteHost = request.getRemoteHost();
    int portNumber = request.getRemotePort();

    System.out.println(remoteHost + ":" + portNumber);
    System.out.println(request.getRemoteAddr());

    return Collections.singletonMap("token", session.getId());
  }

  @RequestMapping("/checkSession")
  public ResponseEntity checkSession() {
    // will only be visible if authorized, otherwise will return 401
    return new ResponseEntity("Session active", HttpStatus.OK);
  }

  @PostMapping("/user/logout")
  public ResponseEntity logout() {
    SecurityContextHolder.clearContext();
    return new ResponseEntity("Logged out successfully", HttpStatus.OK);
  }

}
