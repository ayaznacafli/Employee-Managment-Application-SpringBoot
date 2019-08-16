package com.ayaz.repository.employee;

import org.springframework.data.repository.CrudRepository;

import com.ayaz.domain.employee.Location;

public interface LocationRepository extends CrudRepository<Location, Long> {
 
}
