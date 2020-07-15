package com.poc.crudSpringbootDockerKubernetes.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.poc.crudSpringbootDockerKubernetes.exception.RecordNotFoundException;
import com.poc.crudSpringbootDockerKubernetes.model.Employee;
import com.poc.crudSpringbootDockerKubernetes.repository.EmployeeRepository;
import com.poc.crudSpringbootDockerKubernetes.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public ResponseEntity<Employee> getEmployee(Integer id) {
		Optional<Employee> employeeOpt = employeeRepository.findById(id);
		if(!employeeOpt.isPresent()) {
			throw new RecordNotFoundException("Employee Not available or invalid Id: " + id); 
		}
		return ResponseEntity.ok(employeeOpt.get());
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public ResponseEntity<Object> updateEmployee(Employee employee, Integer id) {
		Optional<Employee> employeeOpt = employeeRepository.findById(id);
		if(!employeeOpt.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		employee.setId(id);
		employeeRepository.save(employee);
		return ResponseEntity.ok(employeeOpt.get());
	}

	@Override
	public void deleteEmployee(Integer id) {
		employeeRepository.deleteById(id);
		
	}
}
