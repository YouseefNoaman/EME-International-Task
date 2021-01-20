package com.example.emeInternaltional.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.emeInternaltional.entity.Pet;

@Repository
public interface PetRepository extends CrudRepository<Pet, Integer> {

	List<Pet> findAll();
	
}
