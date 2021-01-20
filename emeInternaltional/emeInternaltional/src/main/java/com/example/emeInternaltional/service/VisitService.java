package com.example.emeInternaltional.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.emeInternaltional.entity.Visit;
import com.example.emeInternaltional.repository.VisitRepository;

@Service
public class VisitService implements IVisitService {

	@Autowired
	private VisitRepository visitRepository;
	
	@Transactional
	@Override
	public Visit findById(int id) {
		return visitRepository.findById(id).get();
	}

	@Transactional
	@Override
	public List<Visit> findAll() {
		return visitRepository.findAll();
	}

	@Transactional
	@Override
	public Visit addVisit(Visit visit) {
		if(visit != null)
			visitRepository.save(visit);
		
		return null;
	}

}
