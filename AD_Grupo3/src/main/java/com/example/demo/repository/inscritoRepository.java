package com.example.demo.repository;

import java.io.Serializable;
import java.sql.Date;
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
	
	@Query(value="SELECT * FROM inscrito i, user u, oferta o, ciclo c WHERE i.id_usuario = u.id AND"
			+ " id_oferta = o.id AND u.ciclo_id = c.id AND c.id = ?1", nativeQuery = true)
	List<Inscrito> inscritos(Ciclo ciclo);
	@Query(value="SELECT * FROM inscrito i, user u, oferta o WHERE i.id_usuario = u.id AND"
			+ " id_oferta = o.id AND u.empresa = ?1 AND i.fecha_inscripcion BETWEEN ?2 AND ?3", nativeQuery = true)
	List<Inscrito> empresaFechas(String empresa, Date d1, Date d2);
	
}
