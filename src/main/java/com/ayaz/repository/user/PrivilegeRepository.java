package com.ayaz.repository.user;

import org.springframework.data.repository.CrudRepository;

import com.ayaz.domain.user.Privilege;

public interface PrivilegeRepository extends CrudRepository<Privilege, Long> {

}
