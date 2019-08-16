package com.ayaz.service.employee;

import java.util.List;

import com.ayaz.domain.employee.Location;

public interface LocationService {

	
	boolean insert(Location location);

	boolean delete(Location location);

	Location update(Location location);

	Location getLocationById(Long locationId);

	List<Location> getLocations();
}
