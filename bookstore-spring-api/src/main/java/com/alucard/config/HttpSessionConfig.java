package com.alucard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by Alucard on 12-May-17.
 */
@Configuration
@EnableRedisHttpSession
public class HttpSessionConfig {

  @Bean
  public LettuceConnectionFactory connectionFactory() {
    return new LettuceConnectionFactory();
  }
}
