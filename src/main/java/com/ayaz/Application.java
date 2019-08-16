package com.ayaz;

import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ayaz.domain.employee.Department;
import com.ayaz.domain.employee.Employee;
import com.ayaz.domain.employee.Job;
import com.ayaz.domain.employee.Location;
import com.ayaz.service.employee.DepartmentService;
import com.ayaz.service.employee.EmployeeService;
import com.ayaz.service.employee.JobService;
import com.ayaz.service.employee.LocationService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
/*		
		JobService jobService = applicationContext.getBean(JobService.class);
		LocationService locationService = applicationContext.getBean(LocationService.class);
		DepartmentService departmentService = applicationContext.getBean(DepartmentService.class);
		EmployeeService employeeService = applicationContext.getBean(EmployeeService.class);
		
		Job job1 = new Job("JAVA DEVELOPER", 1500, 2000);
		Job job2 = new Job("SEBEKE ADNINSTRATOR", 1000, 2000);
		Job job3 = new Job("IOS DEVELOPER", 2000, 2500);
		Job job4 = new Job("ORACLE DEVELOPER", 2000, 2500);
		jobService.insert(job1);
		jobService.insert(job2);
		jobService.insert(job3);
		jobService.insert(job4);
	
		Location location1 = new Location("Ilgar Zulfugarov 45", 1234, "Baki");
		Location location2 = new Location("Aga Nematulla", 3232, "Baki");
		Location location3 = new Location("Heyder Eliyev Prospekti 12", 7434, "Gence");
		Location location4 = new Location("Heyder Eliyev pro 1564", 1234, "Tovuz");
		
		
		Department department1 = new Department("SOFTWARE", location1);
		Department department2 = new Department("NETWORK", location2);
		Department department3 = new Department("COURSE", location3);
		Department department4 = new Department("HEALTH", location4);
		
	
		Date date1 = new Date(1997, 10, 10);
		Date date2 = new Date(1996, 12, 27);
		Date date3 = new Date(1996, 10, 03);
		Date date4 = new Date(1997, 12, 07);
		
		Employee employee1 = new Employee("Ayaz", "Nacafli", "ayaz.nacafli@mail.ru", "+994507522200",date1 , job1, 1700, department1);
		Employee employee2 = new Employee("Elnur", "Babazade", "elnur.babazade@mail.ru", "+994553425464", date2, job3, 2000, department1);
		Employee employee3 = new Employee("Babek", "Hasanov", "babek.hasanov@mail.ru", "+994514567676", date3, job2, 1300, department3);
		Employee employee4 = new Employee("Vugar", "Hasanov", "vugar.hasanov@mail.ru", "+994705556754", date4, job4, 2300, department2);
		
		
		jobService.insert(job1);
		jobService.insert(job2);
		jobService.insert(job3);
		jobService.insert(job4);
		
		locationService.insert(location1);
		locationService.insert(location2);
		locationService.insert(location3);
		locationService.insert(location4);
		
		departmentService.insert(department1);
		departmentService.insert(department2);
		departmentService.insert(department3);
		departmentService.insert(department4);
		
		
		employeeService.insert(employee1);
		employeeService.insert(employee2);
		employeeService.insert(employee3);
		employeeService.insert(employee4);
	
	
*/		
	//	applicationContext.close();
		
		
		
	
	}

}
