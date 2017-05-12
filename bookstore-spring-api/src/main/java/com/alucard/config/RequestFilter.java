package com.alucard.config;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Alucard on 12-May-17.
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RequestFilter {
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) {
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;

    response.setHeader("Access-Control-Allow-Origin", "*"); // allow any origin [UNSAFE]
    response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
    response.setHeader("Access-Control-Allow-Headers", "x-requested-with, x-auth-token");
    response.setHeader("Access-Control-Max-Age", "3600");
    response.setHeader("Access-Control-Allow-Credentials", "true");

    if (!(request.getMethod().equalsIgnoreCase("OPTIONS"))) {
      try {
        chain.doFilter(req, res);
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else {
      System.out.println("Pre-flight");
      response.setHeader("Access-Control-Allowed-Methods", "POST, GET, DELETE");
      response.setHeader("Access-Control-Max-Age", "3600");
      response.setHeader("Access-Control-Allow-Headers", "x-requested-with, x-auth-token" +
              "access-control-request-headers, access-control-request-method, accept,origin, authorization, x-requested-with");
      response.setStatus(HttpServletResponse.SC_OK);
    }
  }

  public void init(FilterConfig filterConfig) {}

  public void destroy() {}
}
