package com.example.emeInternaltional.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "clinic")
public class Clinic {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@NonNull
	@Column(name = "name")
	private String name;

	@NonNull
	@Column(name = "address")
	private String address;

	@NonNull
	@Column(name = "phone")
	private String phone;

	// working days will be saved in the format ["Sunday", "Monday", ...]
	@NonNull
	@Column(name = "working_days")
	private List<String> workingDays;

	// working hours will be saved in the format ["9", "12", "9", "12", ...]
	// every 2 consecutive numbers will mean the start and end working hours of a
	// day
	@NonNull
	@Column(name = "working_hours")
	private List<String> workingHours;

	@Column(name = "email")
	private String email;

	@Column(name = "social_media_url")
	private List<String> SMURL;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_id")
	private List<Doctor> doctors;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "visit_id")
	private List<Visit> visits;

	public Clinic(String name, String address, String phone, List<String> workingDays, List<String> workingHours,
			String email, List<String> sMURL, List<Doctor> doctors, List<Visit> visits) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.workingDays = workingDays;
		this.workingHours = workingHours;
		this.email = email;
		SMURL = sMURL;
		this.doctors = doctors;
		this.visits = visits;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<String> getWorkingDays() {
		return workingDays;
	}

	public void setWorkingDays(List<String> workingDays) {
		this.workingDays = workingDays;
	}

	public List<String> getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(List<String> workingHours) {
		this.workingHours = workingHours;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getSMURL() {
		return SMURL;
	}

	public void setSMURL(List<String> sMURL) {
		SMURL = sMURL;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public List<Visit> getVisits() {
		return visits;
	}

	public void setVisits(List<Visit> visits) {
		this.visits = visits;
	}

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((SMURL == null) ? 0 : SMURL.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((doctors == null) ? 0 : doctors.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((visits == null) ? 0 : visits.hashCode());
		result = prime * result + ((workingDays == null) ? 0 : workingDays.hashCode());
		result = prime * result + ((workingHours == null) ? 0 : workingHours.hashCode());
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
		Clinic other = (Clinic) obj;
		if (SMURL == null) {
			if (other.SMURL != null)
				return false;
		} else if (!SMURL.equals(other.SMURL))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (doctors == null) {
			if (other.doctors != null)
				return false;
		} else if (!doctors.equals(other.doctors))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (visits == null) {
			if (other.visits != null)
				return false;
		} else if (!visits.equals(other.visits))
			return false;
		if (workingDays == null) {
			if (other.workingDays != null)
				return false;
		} else if (!workingDays.equals(other.workingDays))
			return false;
		if (workingHours == null) {
			if (other.workingHours != null)
				return false;
		} else if (!workingHours.equals(other.workingHours))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Clinic [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", workingDays="
				+ workingDays.toString() + ", workingHours=" + workingHours.toString() + ", email=" + email + ", SMURL=" + SMURL.toString() 
				+ ", doctors=" + doctors.toString() + ", visits=" + visits.toString() + "]";
	}


	
	
}
