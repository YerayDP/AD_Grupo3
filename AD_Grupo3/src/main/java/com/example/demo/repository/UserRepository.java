package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository <User, Serializable>{

	public abstract User findByEmail(String email);
	
	public abstract User findById(long id);
	public abstract List<User> findByRole(String role);
	public abstract User findByCiclo_id(long id);
	public abstract User findByToken(String token);

	@Query(value="SELECT * FROM User u, Oferta o, Inscrito i WHERE i.id_usuario = u.id AND o.id = i.id_oferta AND o.id = ?1", nativeQuery = true)
	List<User> alumnos(int id);
	
}
 