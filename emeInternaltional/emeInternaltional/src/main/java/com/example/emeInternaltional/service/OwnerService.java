package com.example.emeInternaltional.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.emeInternaltional.entity.Owner;
import com.example.emeInternaltional.entity.Pet;
import com.example.emeInternaltional.repository.OwnerRepository;

@Service
public class OwnerService implements IOwnerService {

	@Autowired
	private OwnerRepository ownerRepository;
	
	@Transactional
	@Override
	public Owner findById(int id) {
		return ownerRepository.findById(id).get();
	}

	@Transactional
	@Override
	public List<Pet> findPetByOwnerId(int id) {
		return ownerRepository.findPetByOwnerId(id);
	}

	@Transactional
	@Override
	public List<Owner> findAll() {
		return ownerRepository.findAll();
	}

	@Transactional
	@Override
	public Owner addOwner(Owner owner) {
		if(owner != null)
			return ownerRepository.save(owner);
		
		return null;
	}
	
	

}
