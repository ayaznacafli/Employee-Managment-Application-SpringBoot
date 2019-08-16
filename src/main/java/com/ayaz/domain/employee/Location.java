package com.ayaz.domain.employee;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity 
public class Location {


	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "locationId", nullable = false, unique = true)
	private Long locationId;

	@Column(length = 60)
	private String streetAddress;
	
	private int postalCode;
	
	@Column(name = "city")
	private String city;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "location")
	private List<Department> departments;
	
	public Location() {
	}

	public Location(String streetAddress, int postalCode, String city) {
		this.streetAddress = streetAddress;
		this.postalCode = postalCode;
		this.city = city;
	}


	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
	
}
