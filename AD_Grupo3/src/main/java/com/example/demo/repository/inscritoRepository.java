package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Inscrito;
import com.example.demo.entity.User;

@Repository("inscritoRepository")
public interface inscritoRepository extends JpaRepository <Inscrito, Serializable>{

	List <Inscrito> findByUsuario(User user);
	
}
