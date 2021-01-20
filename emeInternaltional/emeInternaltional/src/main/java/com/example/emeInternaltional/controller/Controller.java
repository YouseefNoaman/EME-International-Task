package com.example.emeInternaltional.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.emeInternaltional.entity.Clinic;
import com.example.emeInternaltional.entity.Doctor;
import com.example.emeInternaltional.entity.Owner;
import com.example.emeInternaltional.entity.Pet;
import com.example.emeInternaltional.entity.Visit;
import com.example.emeInternaltional.service.IClinicService;
import com.example.emeInternaltional.service.IDoctorService;
import com.example.emeInternaltional.service.IOwnerService;
import com.example.emeInternaltional.service.IPetService;
import com.example.emeInternaltional.service.IVisitService;

@RestController
@RequestMapping("/home")
public class Controller {

	@Autowired
	private IClinicService clinicService;

	@Autowired
	private IPetService petService;

	@Autowired
	private IDoctorService doctorService;

	@Autowired
	private IVisitService visitService;

	@Autowired
	private IOwnerService ownerService;

	@GetMapping(value = "/api/clinics")
	public List<Clinic> getClinics() {

		List<Clinic> clinics = clinicService.findAll();

		return clinics;
	}

	@GetMapping(value = "/api/doctors")
	public List<Doctor> getDoctors() {

		List<Doctor> doctors = doctorService.findAll();

		return doctors;
	}

	@GetMapping(value = "/api/pets")
	public List<Pet> getPets() {

		List<Pet> pets = petService.findAll();

		return pets;
	}

	@GetMapping(value = "/api/owners")
	public List<Owner> getOwners() {

		List<Owner> owners = ownerService.findAll();

		return owners;
	}

	@GetMapping(value = "/api/visits")
	public List<Visit> getVisits() {

		List<Visit> visits = visitService.findAll();

		return visits;
	}

	@RequestMapping(value = "/api/saveDoctor", method = RequestMethod.POST)
	@ResponseBody
	public Doctor save(@RequestBody Doctor doctor) {
		Doctor doctorResponse = (Doctor) doctorService.addDoctor(doctor);
		return doctorResponse;
	}

	@RequestMapping(value = "/doctor/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Doctor getDoctor(@PathVariable int id) {
		Doctor doctorResponse = (Doctor) doctorService.findById(id);
		return doctorResponse;
	}

	@RequestMapping(value = "/clinic/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Clinic getClinic(@PathVariable int id) {
		Clinic clinicResponse = (Clinic) clinicService.findById(id);
		return clinicResponse;
	}

	@RequestMapping(value = "/pet/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Pet getPet(@PathVariable int id) {
		Pet petResponse = (Pet) petService.findById(id);
		return petResponse;
	}

	@RequestMapping(value = "/owner/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Owner getOwner(@PathVariable int id) {
		Owner ownerResponse = (Owner) ownerService.findById(id);
		return ownerResponse;
	}

	@RequestMapping(value = "/visit/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Visit getVisit(@PathVariable int id) {
		Visit visitResponse = (Visit) visitService.findById(id);
		return visitResponse;
	}

	
	@RequestMapping(value = "owner/listPets/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<Pet> listPetsByOwnerID(@PathVariable int id) {
		List<Pet> petsResponse = (List<Pet>) ownerService.findPetByOwnerId(id);
		return petsResponse;
	}
	
	@RequestMapping(value = "clinic/listDoctors/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<Doctor> listDoctorsByClinicID(@PathVariable int id) {
		List<Doctor> doctorsResponse = (List<Doctor>) clinicService.listAllDoctors(id);
		return doctorsResponse;
	}
	
	@RequestMapping(value = "owner/listClinic/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<Pet> listPetsyOwnerID(@PathVariable int id) {
		List<Pet> petsResponse = (List<Pet>) ownerService.findPetByOwnerId(id);
		return petsResponse;
	}
	
	@RequestMapping(value = "clinic/searchClinic/find", method = RequestMethod.GET)
	@ResponseBody
	public Clinic findByphoneOrAddr(@RequestParam("PA") String searchP_A) {
	    return clinicService.findByPhoneOrAddress(searchP_A);
	}
	
	
	  @PutMapping("/clinic/doctors/{id}")
	  Doctor assignDoctor(@RequestBody Doctor newDoctor, @PathVariable int id) {

	    return clinicService.assignDoctor(newDoctor.getId(), id);
	  }
	  @PutMapping("/clinic/doctors/{id}")
	  Doctor deassignDoctor(@RequestBody Doctor newDoctor, @PathVariable int id) {
		  return clinicService.deassignDoctor(newDoctor.getId(), id);
	    
	  }
	
	
	
	@GetMapping("/error")
	public void error(){
		System.out.println("It is working but has an error!!");
	}
	
}
