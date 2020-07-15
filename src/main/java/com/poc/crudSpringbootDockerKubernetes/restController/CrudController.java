package com.poc.crudSpringbootDockerKubernetes.restController;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.poc.crudSpringbootDockerKubernetes.model.Employee;
import com.poc.crudSpringbootDockerKubernetes.service.EmployeeService;

@RequestMapping("/api")
@RestController
public class CrudController {
	
	private static final Logger logger = LoggerFactory.getLogger(CrudController.class);

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Employee> getEmployee(){
		return employeeService.getEmployee();
	}
	
	@GetMapping(value = "/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Employee> getEmployee(@PathVariable Integer id){
		return employeeService.getEmployee(id);
	}
	
	@PostMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	@PutMapping(value = "/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Object> updateEmployee(@RequestBody Employee employee, @PathVariable Integer id) {
		return employeeService.updateEmployee(employee,id);
	}
	
	@DeleteMapping(value = "/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteEmployee(@PathVariable Integer id) {
		logger.debug("Deleted employee having customer Id- {}", id);
		employeeService.deleteEmployee(id);
	}
}
