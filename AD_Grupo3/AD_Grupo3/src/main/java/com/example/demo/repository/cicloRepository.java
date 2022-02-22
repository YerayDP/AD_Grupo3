package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Ciclo;
import com.example.demo.entity.User;
import com.example.demo.models.NoticiaModel;


@Repository("cicloRepository")
public interface cicloRepository extends JpaRepository <Ciclo, Serializable>{
	
	
}
