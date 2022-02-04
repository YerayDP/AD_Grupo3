package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Ciclo;
import com.example.demo.entity.Inscrito;
import com.example.demo.entity.User;

@Repository("inscritoRepository")
public interface inscritoRepository extends JpaRepository <Inscrito, Serializable>{

	List <Inscrito> findByUsuario(User user);

	@Query(value="SELECT * FROM oferta o, inscrito i WHERE o.cicloid = ?1", nativeQuery = true)
	List<Inscrito> findByCiclo(Ciclo ciclo);
	
	@Query(value="SELECT DISTINCT * FROM oferta o LEFT JOIN inscrito i ON i.id_oferta = o.id WHERE o.cicloid=?1", nativeQuery = true)
	List<Inscrito> inscritos(Ciclo ciclo);
	
}
