package com.example.emeInternaltional.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.emeInternaltional.entity.Owner;
import com.example.emeInternaltional.entity.Pet;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Integer> {


    @Query("SELECT t FROM pet t WHERE " +
            "owner_id = :id")
	List<Pet> findPetByOwnerId(@Param("id") int id);
	
    List<Owner> findAll();
    
}
