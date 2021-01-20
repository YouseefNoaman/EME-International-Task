package com.example.emeInternaltional.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.emeInternaltional.entity.Doctor;
import com.example.emeInternaltional.repository.DoctorRepository;

@Service
public class DoctorService implements IDoctorService {

	@Autowired
	private DoctorRepository doctorRepository;
	
	@Transactional
	@Override
	public Doctor findById(int id) {
		return doctorRepository.findById(id).get();
	}

	@Transactional
	@Override
	public List<Doctor> findAll() {
		return doctorRepository.findAll();
	}

	@Transactional
	@Override
	public Doctor addDoctor(Doctor doctor) {
		if(doctor != null)
			return doctorRepository.save(doctor);
		
		return null;
	}
	
	

}
