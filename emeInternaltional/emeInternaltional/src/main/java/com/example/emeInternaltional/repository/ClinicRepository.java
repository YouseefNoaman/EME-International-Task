package com.example.emeInternaltional.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.emeInternaltional.entity.Clinic;
import com.example.emeInternaltional.entity.Doctor;

@Repository
public interface ClinicRepository extends CrudRepository<Clinic, Integer> {

	
    @Query("SELECT t FROM clinic t WHERE " +
            "doctor_id = :id")
	public List<Doctor> listAllDoctors(@Param("id") int id);

    @Query("SELECT t FROM clinic t WHERE " +
            "phone = :PA OR address = :PA")
	public Clinic findByPhoneOrAddress(@Param("PA") String PA);
	
    @Query("update doctor d set d.clinic = :clinic_id WHERE " +
            "d.clinic = :clinic_id AND d.id = :id")
	public Doctor assignDoctor(@Param("id") int docID, @Param("clinic_id") int clinicID);
	
    @Query("update doctor d set d.clinic = 0 WHERE " +
            "d.clinic = :clinic_id AND d.id = :id")
	public Doctor deassignDoctor(@Param("id") int docID, @Param("clinic_id") int clinicID);
	
    
    List<Clinic> findAll();
    
    
}
