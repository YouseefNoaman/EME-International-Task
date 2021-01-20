package com.example.emeInternaltional.service;

import java.util.List;
import java.util.Optional;

import com.example.emeInternaltional.entity.Visit;

public interface IVisitService {
	Visit findById(int id);
	List<Visit> findAll();
	
	Visit addVisit(Visit visit);
}
