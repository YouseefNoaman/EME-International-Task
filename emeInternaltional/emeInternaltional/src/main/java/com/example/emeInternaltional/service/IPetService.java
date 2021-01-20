package com.example.emeInternaltional.service;

import java.util.List;
import java.util.Optional;

import com.example.emeInternaltional.entity.Pet;

public interface IPetService {
	Pet findById(int id);
	List<Pet> findAll();
	
	Pet addPet(Pet pet);
}
