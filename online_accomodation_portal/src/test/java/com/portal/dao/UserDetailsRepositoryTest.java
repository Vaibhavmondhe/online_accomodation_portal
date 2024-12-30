package com.portal.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.portal.entities.Status;
import com.portal.entities.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserDetailsRepositoryTest {

	@Autowired
	private UserDao userRepo;

	@Test
	void testFindByStatus() {
		List<User> list = userRepo.findByStatus(Status.APPROVED);
		list.forEach(System.out::println);
		assertEquals(8, list.size());
	}
}
