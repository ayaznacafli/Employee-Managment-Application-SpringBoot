package com.ayaz.service.employee.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayaz.domain.employee.Location;
import com.ayaz.repository.employee.LocationRepository;
import com.ayaz.service.employee.LocationService;


@Service
public class LocationServiceImpl implements LocationService {

	
	@Autowired
	private LocationRepository locationRepository;
	
	
	@Override
	public boolean insert(Location location) {
		if(location != null) {
			locationRepository.save(location);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean delete(Location location) {
		if(location != null) {
			locationRepository.delete(location);
			return true;
		}else {
			Location deleteLocation = getLocationById(location.getLocationId());
			locationRepository.delete(deleteLocation);
			return true;
		}
	}

	@Override
	public Location update(Location location) {
		if(location != null) {
			locationRepository.save(location);
			return location;
		}else {
			Location updateLocation = getLocationById(location.getLocationId());
			locationRepository.save(updateLocation);
			return updateLocation;
		}
	}

	@Override
	public Location getLocationById(Long locationId) {
		return locationRepository.findById(locationId).get();
	}

	@Override
	public List<Location> getLocations() {
		return (List<Location>) locationRepository.findAll();
	}

}
