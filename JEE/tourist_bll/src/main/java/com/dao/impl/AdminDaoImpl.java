package com.dao.impl;

import org.springframework.stereotype.Repository;

import com.bo.Admin;
import com.dao.AdminDao;
import com.genericdao.impl.HibernateSpringGenericDaoImpl;
@Repository
public class AdminDaoImpl extends HibernateSpringGenericDaoImpl<Admin, Long> implements AdminDao {

	public AdminDaoImpl() {
		super(Admin.class);
		
	}

}
