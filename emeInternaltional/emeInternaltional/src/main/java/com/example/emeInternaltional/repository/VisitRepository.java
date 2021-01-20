package com.example.emeInternaltional.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.emeInternaltional.entity.Visit;

@Repository
public interface VisitRepository extends CrudRepository<Visit, Integer> {

	List<Visit> findAll();
}
