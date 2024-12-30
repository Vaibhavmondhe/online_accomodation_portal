package com.portal.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.entities.Status;
import com.portal.entities.User;
import com.portal.entities.UserRole;

public interface UserDao extends JpaRepository<User, Long> {

	User findByEmail(String email);

	Optional<User> findByEmailAndPassword(String email, String password);

	public List<User> findByStatus(Status statusType);

	public List<User> findByRole(UserRole role);

}
