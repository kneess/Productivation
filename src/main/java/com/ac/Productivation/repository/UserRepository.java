package com.ac.Productivation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ac.Productivation.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	public User findByUsername(String username);
}
