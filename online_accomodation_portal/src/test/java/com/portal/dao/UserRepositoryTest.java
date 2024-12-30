package com.portal.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.portal.entities.Gender;
import com.portal.entities.Status;
import com.portal.entities.User;
import com.portal.entities.UserRole;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class UserRepositoryTest {

	@Autowired
	private UserDao userRepo;

	@Value("${ADMIN_FIRSTNAME}")
	private String adminFirstName;

	@Value("${ADMIN_LASTNAME}")
	private String adminLastName;

	@Value("${ADMIN_MAIL}")
	private String adminMail;

	@Value("${ADMIN_PASSWORD}")
	private String adminPassword;

	@Autowired
	private PasswordEncoder encoder;

	/*
	 * public User(String firstName, String lastName, long mobileNo, String email,
	 * String password, String address, Gender gender, UserRole role, Status status)
	 */

	@Test
	void testSaveUser() {
		User admin = new User(adminFirstName, adminLastName, 9527265737l, adminMail, adminPassword, "Pune", Gender.MALE,
				UserRole.ROLE_ADMIN, Status.APPROVED);

		admin.setPassword(encoder.encode(adminPassword));

		User a = userRepo.save(admin);

		assertEquals(1, a != null ? 1 : 0);
	}

}
