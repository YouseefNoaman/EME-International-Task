package com.example.emeInternaltional.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "visit")
public class Visit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@NonNull
	@OneToMany(mappedBy = "pet_id", cascade = CascadeType.ALL)
	private Pet pet;

	@NonNull
	@OneToMany(mappedBy = "doctor_id", cascade = CascadeType.ALL)
	private Doctor doctor;

	@NonNull
	@OneToMany(mappedBy = "clinic_id", cascade = CascadeType.ALL)
	private Clinic clinic;

	@NonNull
	@OneToMany(mappedBy = "owner_id", cascade = CascadeType.ALL)
	private Owner owner;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_visit")
	private Date dateOfVisit;

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public Date getDateOfVisit() {
		return dateOfVisit;
	}

	public void setDateOfVisit(Date dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	public int getId() {
		return id;
	}

	public Visit(Pet pet, Doctor doctor, Clinic clinic, Owner owner, Date dateOfVisit) {
		super();
		this.pet = pet;
		this.doctor = doctor;
		this.clinic = clinic;
		this.owner = owner;
		this.dateOfVisit = dateOfVisit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clinic == null) ? 0 : clinic.hashCode());
		result = prime * result + ((dateOfVisit == null) ? 0 : dateOfVisit.hashCode());
		result = prime * result + ((doctor == null) ? 0 : doctor.hashCode());
		result = prime * result + id;
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + ((pet == null) ? 0 : pet.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Visit other = (Visit) obj;
		if (clinic == null) {
			if (other.clinic != null)
				return false;
		} else if (!clinic.equals(other.clinic))
			return false;
		if (dateOfVisit == null) {
			if (other.dateOfVisit != null)
				return false;
		} else if (!dateOfVisit.equals(other.dateOfVisit))
			return false;
		if (doctor == null) {
			if (other.doctor != null)
				return false;
		} else if (!doctor.equals(other.doctor))
			return false;
		if (id != other.id)
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (pet == null) {
			if (other.pet != null)
				return false;
		} else if (!pet.equals(other.pet))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Visit [id=" + id + ", pet=" + pet.toString() + ", doctor=" + doctor.toString() + ", clinic=" + clinic.toString() + ", owner=" + owner.toString()
				+ ", dateOfVisit=" + dateOfVisit + "]";
	}
	
	
	
}
