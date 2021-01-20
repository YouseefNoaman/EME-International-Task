package com.example.emeInternaltional.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.emeInternaltional.entity.Pet;
import com.example.emeInternaltional.repository.PetRepository;

@Service
public class PetService implements IPetService {

	@Autowired
	private PetRepository petRepository;
	
	@Transactional
	@Override
	public Pet findById(int id) {
		return petRepository.findById(id).get();
	}

	@Transactional
	@Override
	public List<Pet> findAll() {
		return petRepository.findAll();
	}

	@Transactional
	@Override
	public Pet addPet(Pet pet) {
		if(pet != null)
			petRepository.save(pet);
		
		return null;
	}

}
