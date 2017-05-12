package com.alucard.repository;

import com.alucard.domain.User;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

/**
 * Created by Alucard on 12-May-17.
 */
public interface UserRepository extends CrudRepository<User, Long> {
  User findByUsername(String username);
  User findByEmail(String email);
  List<User> findAll();
}
