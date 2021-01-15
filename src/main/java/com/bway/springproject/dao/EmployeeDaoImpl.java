package com.bway.springproject.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bway.springproject.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void add(Employee emp) {
		
		Session sess = sessionFactory.getCurrentSession();
		sess.save(emp.getAddress());
		sess.save(emp);
		
	}

	@Override
	@Transactional
	public void delete(int id) {
		
		Session sess = sessionFactory.getCurrentSession();
		Employee e=(Employee) sess.get(Employee.class, id);
		sess.delete(e);	
		
	}

	@Override
	@Transactional
	public void update(Employee emp) {
		
		Session sess = sessionFactory.getCurrentSession();
		sess.update(emp);
		
	}

	@Override
	@Transactional
	public Employee getById(int id) {
		
		Session sess = sessionFactory.getCurrentSession();
		Employee e=(Employee) sess.get(Employee.class, id);
		return e;
	}

	@Override
	@Transactional
	public List<Employee> getAll() {
		
		Session sess = sessionFactory.getCurrentSession();
		Criteria crt = sess.createCriteria(Employee.class);
		return crt.list();
	}

}
