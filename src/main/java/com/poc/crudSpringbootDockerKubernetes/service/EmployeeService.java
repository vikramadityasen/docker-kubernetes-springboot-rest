package com.poc.crudSpringbootDockerKubernetes.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.poc.crudSpringbootDockerKubernetes.model.Employee;

public interface EmployeeService {

	List<Employee> getEmployee();

	ResponseEntity<Employee> getEmployee(Integer id);

	Employee saveEmployee(Employee employee);

	ResponseEntity<Object> updateEmployee(Employee employee, Integer id);

	void deleteEmployee(Integer id);

}
