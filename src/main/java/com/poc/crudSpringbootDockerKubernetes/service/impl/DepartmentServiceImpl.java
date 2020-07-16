package com.poc.crudSpringbootDockerKubernetes.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.poc.crudSpringbootDockerKubernetes.exception.RecordNotFoundException;
import com.poc.crudSpringbootDockerKubernetes.model.Department;
import com.poc.crudSpringbootDockerKubernetes.repository.DepartmentRepository;
import com.poc.crudSpringbootDockerKubernetes.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public List<Department> getDepartment() {
		return departmentRepository.findAll();
	}

	@Override
	public ResponseEntity<Department> getDepartment(Integer id) {
		Optional<Department> DepartmentOpt = departmentRepository.findById(id);
		if(!DepartmentOpt.isPresent()) {
			throw new RecordNotFoundException("Department Not available or invalid Id: " + id);
		}
		return ResponseEntity.ok(DepartmentOpt.get());
	}

}
