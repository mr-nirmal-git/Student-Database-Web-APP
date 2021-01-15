package com.bway.springproject.dao;

import java.util.List;

import com.bway.springproject.model.Employee;

public interface EmployeeDao {

	void add(Employee emp);
	void delete(int id);
	void update(Employee emp);
	Employee getById(int id);
	List<Employee> getAll();	
	
}
