package com.bway.springproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bway.springproject.dao.EmployeeDao;
import com.bway.springproject.model.Employee;

@RestController
@RequestMapping("/api/employee")
public class EmployeeRestController {

	@Autowired
	private EmployeeDao edao;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ResponseEntity<List<Employee>>  getAllEmployee() {
		
		ResponseEntity<List<Employee>> elist = new ResponseEntity<List<Employee>>(edao.getAll(),HttpStatus.OK);
		
		return elist;
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id) {
		
		ResponseEntity<Employee> emp = new ResponseEntity<Employee>(edao.getById(id), HttpStatus.OK);
		
		return emp;
		
	}
	
}
