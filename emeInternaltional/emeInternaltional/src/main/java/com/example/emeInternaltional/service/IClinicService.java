package com.example.emeInternaltional.service;

import java.util.List;
import java.util.Optional;

import com.example.emeInternaltional.entity.Clinic;
import com.example.emeInternaltional.entity.Doctor;

public interface IClinicService {
	Clinic findById(int id);

	List<Doctor> listAllDoctors(int id);

	Clinic findByPhoneOrAddress(String searchP_A);

	Doctor assignDoctor(int docID, int clinicID);

	Doctor deassignDoctor(int docID, int clinicID);

	List<Clinic> findAll();

}
