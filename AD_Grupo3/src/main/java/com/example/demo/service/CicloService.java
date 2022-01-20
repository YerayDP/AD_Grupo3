package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Ciclo;
import com.example.demo.entity.User;
import com.example.demo.models.CicloModel;
import com.example.demo.models.NoticiaModel;

public interface CicloService {

	List<CicloModel> listAllCiclos();
	Ciclo addCiclo(CicloModel CicloModel);
	int removeCiclo(int id);
	Ciclo updateCiclo(CicloModel CicloModel);
	CicloModel transform(Ciclo ciclo);
	CicloModel findCiclo(int id);
	Ciclo transform(CicloModel ciclo);
	Ciclo findbyUserCicloId(User User);
	List<NoticiaModel> listByCiclo(CicloModel ciclo);
	Ciclo findCicloById(int id);

}
