package com.example.emeInternaltional.service;

import java.util.List;
import java.util.Optional;

import com.example.emeInternaltional.entity.Owner;
import com.example.emeInternaltional.entity.Pet;

public interface IOwnerService {

	Owner findById(int id);
	List<Pet> findPetByOwnerId(int id);
	List<Owner> findAll();
	
	Owner addOwner(Owner owner);

}
