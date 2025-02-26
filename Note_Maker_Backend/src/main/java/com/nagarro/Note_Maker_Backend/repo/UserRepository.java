package com.nagarro.Note_Maker_Backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nagarro.Note_Maker_Backend.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	// Retrieves a user by their email using a custom query.
	@Query("select u from User u where u.email = :email")
	public User getUserByEmail(@Param("email") String email);
}

