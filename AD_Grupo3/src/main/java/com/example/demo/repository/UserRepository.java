package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository <User, Serializable>{

	public abstract User findByEmail(String email);
	public abstract User findById(long id);
	public abstract List<User> findByRole(String role);
	public abstract User findByCiclo_id(long id);
	
}
 