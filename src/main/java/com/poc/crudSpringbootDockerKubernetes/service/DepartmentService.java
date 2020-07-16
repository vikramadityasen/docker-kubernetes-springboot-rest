package com.poc.crudSpringbootDockerKubernetes.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.poc.crudSpringbootDockerKubernetes.model.Department;

public interface DepartmentService {

	List<Department> getDepartment();

	ResponseEntity<Department> getDepartment(Integer id);

}
