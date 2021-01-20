package com.example.emeInternaltional.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.emeInternaltional.entity.Clinic;
import com.example.emeInternaltional.entity.Doctor;
import com.example.emeInternaltional.repository.ClinicRepository;

@Service
public class ClinicService implements IClinicService {

	@Autowired
	private ClinicRepository clinicRepository;
	
	@Transactional
	@Override
	public Clinic findById(int id) {
		return clinicRepository.findById(id).get();
	}

	@Transactional
	@Override
	public List<Doctor> listAllDoctors(int id) {
		return clinicRepository.listAllDoctors(id);
	}

	@Transactional
	@Override
	public Clinic findByPhoneOrAddress(String searchP_A) {
		return clinicRepository.findByPhoneOrAddress(searchP_A);
	}

	@Transactional
	@Override
	public Doctor assignDoctor(int docID, int clinicID) {
		return clinicRepository.assignDoctor(docID, clinicID);
	}

	@Transactional
	@Override
	public Doctor deassignDoctor(int docID, int clinicID) {
		return clinicRepository.deassignDoctor(docID, clinicID);
	}
	
	@Transactional
	@Override
	public List<Clinic> findAll(){
		return clinicRepository.findAll();
	}

}
