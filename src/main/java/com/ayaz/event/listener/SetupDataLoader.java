package com.ayaz.event.listener;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ayaz.domain.employee.Department;
import com.ayaz.domain.employee.Employee;
import com.ayaz.domain.employee.Job;
import com.ayaz.domain.employee.Location;
import com.ayaz.domain.user.Privilege;
import com.ayaz.domain.user.Role;
import com.ayaz.domain.user.User;
import com.ayaz.service.employee.DepartmentService;
import com.ayaz.service.employee.EmployeeService;
import com.ayaz.service.employee.JobService;
import com.ayaz.service.employee.LocationService;
import com.ayaz.service.user.PrivilegeService;
import com.ayaz.service.user.RoleService;
import com.ayaz.service.user.UserService;


@Component
@Transactional
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private LocationService locationService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private JobService jobService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private PrivilegeService privilegeService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserService userService;
	
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

//		if(event.getApplicationContext().getParent() == null){
//			createEmployees();
//			createUser();
//		}	
	}
/*
	private void createUser(){
		Privilege readPrivilege = createPrivilegeIfNotFound("ROLE_READ_PRIVILEGE");
		Privilege writePrivilege = createPrivilegeIfNotFound("ROLE_WRITE_PRIVILEGE");
		
		List<Privilege> adminPrivilege = Arrays.asList(readPrivilege, writePrivilege);
		List<Privilege> userPrivilege = Arrays.asList(readPrivilege);
		
		Role roleUser = createRoleIfNotFound("ROLE_USER", userPrivilege);
		Role roleAdmin = createRoleIfNotFound("ROLE_ADMIN", adminPrivilege);
		createRoleIfNotFound("ROLE_USER", userPrivilege);
		
		User user = new User("Ayaz", "Nacafli", "ayaz.nacafli@mail.ru");
		user.setUsername("ayaznacafli");
		user.setPassword(passwordEncoder.encode("ayaz1997"));
		user.setEnabled(true);
		user.setRole(roleAdmin);
		userService.insert(user);
		
		User user2 = new User("Vusal", "Hasanov", "vusal.hasanov@mail.ru");
		user2.setUsername("vusalhasanov");
		user2.setPassword(passwordEncoder.encode("vusal2002"));
		user2.setEnabled(true);
		user2.setRole(roleUser);
		userService.insert(user2);
		
		User user3 = new User("Vugar", "Gasanov", "vugargasanov@gmail.com");
		user3.setUsername("vugargasanov");
		user3.setPassword(passwordEncoder.encode("vugar1998"));
		user3.setEnabled(true);
		user3.setRole(roleUser);
		userService.insert(user3);
		
	}


	private Role createRoleIfNotFound(String name, List<Privilege> privileges) {
		Role role = new Role(name, privileges);
		roleService.insert(role);
		return role;
	}


	private Privilege createPrivilegeIfNotFound(String name) {
		Privilege privilege = new Privilege();
		privilege.setName(name);
		privilegeService.insert(privilege);
		return privilege;
	}


	private void createEmployees(){
		Location location1 = new Location("Ilgar Zulfugarov 45", 1234, "Baki");
		Location location2 = new Location("Aga Nematulla", 3232, "Baki");
		Location location3 = new Location("Heyder Eliyev Prospekti 12", 7434, "Gence");
		Location location4 = new Location("Heyder Eliyev pro 1564", 1234, "Tovuz");

		locationService.insert(location1);
		locationService.insert(location2);
		locationService.insert(location3);
		locationService.insert(location4);
		
		Department department1 = new Department("SOFTWARE", location1);
		Department department2 = new Department("NETWORK", location2);
		Department department3 = new Department("COURSE", location3);
		Department department4 = new Department("HEALTH", location4);
		
		departmentService.insert(department4);
		departmentService.insert(department3);
		departmentService.insert(department2);
		departmentService.insert(department1);
		
	    Job job1 = new Job("JAVA DEVELOPER", 1500, 2000);
	    Job job2 = new Job("SEBEKE ADNINSTRATOR", 1000, 2000);
		Job job3 = new Job("IOS DEVELOPER", 2000, 2500);
		Job job4 = new Job("ORACLE DEVELOPER", 2000, 2500);
		
		jobService.insert(job4);
		jobService.insert(job3);
		jobService.insert(job2);
		jobService.insert(job1);
		
		
		Date date1 = new Date(1997, 10, 10);
		Date date2 = new Date(1996, 12, 27);
		Date date3 = new Date(1996, 10, 03);
		Date date4 = new Date(1997, 12, 07);
		
		Employee employee1 = new Employee("Ayaz", "Nacafli", "ayaz.nacafli@mail.ru", "+994507522200",date1 , job1, 1700, department1);
		Employee employee2 = new Employee("Elnur", "Babazade", "elnur.babazade@mail.ru", "+994553425464", date2, job3, 2000, department1);
		Employee employee3 = new Employee("Babek", "Hasanov", "babek.hasanov@mail.ru", "+994514567676", date3, job2, 1300, department3);
		Employee employee4 = new Employee("Vugar", "Hasanov", "vugar.hasanov@mail.ru", "+994705556754", date4, job4, 2300, department2);
		
		
		employeeService.insert(employee4);
		employeeService.insert(employee3);
		employeeService.insert(employee2);
		employeeService.insert(employee1);
	}
	
	*/
	
}
