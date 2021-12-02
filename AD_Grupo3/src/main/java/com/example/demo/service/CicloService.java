package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Ciclo;
import com.example.demo.models.CicloModel;

public interface CicloService {

	List<CicloModel> listAllCiclos();
	Ciclo addCiclo(CicloModel CicloModel);
	int removeCiclo(int id);
	Ciclo updateCiclo(CicloModel CicloModel);
	CicloModel findCiclo(int id);
	abstract List<CicloModel> listAllCiclos(CicloModel CicloModel);
	
}
