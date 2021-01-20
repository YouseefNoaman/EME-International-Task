package com.example.emeInternaltional.service;

import java.util.List;
import java.util.Optional;

import com.example.emeInternaltional.entity.Doctor;

public interface IDoctorService {
	Doctor findById(int id);
	List<Doctor> findAll();
	Doctor addDoctor(Doctor doctor);

}
