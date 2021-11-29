package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.RRHH;

public interface RRHHService {

	List<RRHHModel> listAllRRHHs();
	RRHH addRRHH(RRHHModel RRHHModel);
	int removeRRHH(int id);
	RRHH updateRRHH(RRHHModel RRHHModel);
	RRHHModel findRRHH(int id);
	abstract List<RRHHsModel> listAllRRHHs(RRHHModel RRHHModel);
	
}
