package com.bway.springproject.dao;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bway.springproject.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Resource
	 private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void signup(User u) {
		
		Session sess = sessionFactory.getCurrentSession();
		sess.save(u);
		
	}

	@Override
	@Transactional
	public boolean login(String un, String psw) {
		
		Session sess= sessionFactory.getCurrentSession();
		Criteria crt =sess.createCriteria(User.class);
		crt.add(Restrictions.eq("username", un)).add(Restrictions.eq("password", psw));
		
		User u = (User) crt.uniqueResult();
		
		if ( u!= null ) 	
			return true;
			 
		return false;
		
	}

}
