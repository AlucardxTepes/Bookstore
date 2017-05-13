package com.alucard.resource;

import com.alucard.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
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
public class LoginResource {

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

}
