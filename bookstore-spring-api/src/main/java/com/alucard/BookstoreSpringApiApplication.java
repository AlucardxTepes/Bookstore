package com.alucard;

import com.alucard.config.SecurityUtility;
import com.alucard.domain.User;
import com.alucard.domain.security.Role;
import com.alucard.domain.security.UserRole;
import com.alucard.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class BookstoreSpringApiApplication implements CommandLineRunner{

	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreSpringApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User();
		user1.setFirstName("Alucard");
		user1.setLastName("Tepes");
		user1.setUsername("alucard");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("pass"));
		user1.setEmail("alucard@tepes.com");
		Set<UserRole> userRoles = new HashSet<>();
		Role role1 = new Role();
		role1.setRoleId(1);
		role1.setName("ROLE_USER");
		userRoles.add(new UserRole(user1, role1));

		userService.createUser(user1, userRoles);

		userRoles.clear();

		User user2 = new User();
		user2.setFirstName("Administrator");
		user2.setLastName("KLK");
		user2.setUsername("admin");
		user2.setPassword(SecurityUtility.passwordEncoder().encode("pass"));
		user2.setEmail("admin@klk.com");
		Role role2 = new Role();
		role2.setRoleId(0);
		role2.setName("ROLE_ADMIN");
		userRoles.add(new UserRole(user2, role2));

		userService.createUser(user2, userRoles);

	}
}
