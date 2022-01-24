package com.example.demo.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Ciclo;
import com.example.demo.entity.Inscrito;
import com.example.demo.entity.Oferta;
import com.example.demo.entity.User;
import com.example.demo.models.UserModel;


@Repository("ofertaRepository")
public interface ofertaRepository extends JpaRepository <Oferta, Serializable>{

	List<Oferta> findByUsuario(User user);
	
	List<Oferta> findByCiclo(Ciclo ciclo);
	List<Oferta> findByFechamaxBefore(Date fecha);
	
	@Query(value="SELECT * FROM oferta o, inscrito i WHERE  o.id = i.id_oferta AND i.id_usuario= ?1", nativeQuery = true)
	List<Oferta> consulta(int id);
	@Query(value="SELECT * FROM oferta o LEFT JOIN inscrito i ON i.id_oferta = o.id WHERE id_oferta IS NULL", nativeQuery = true)
	List<Oferta> posibles(int id);
	
	
	
}
