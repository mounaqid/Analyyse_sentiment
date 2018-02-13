package com.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bo.Admin;
import com.dao.AdminDao;
import com.services.AdminService;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;
	
	public void addAdmin(Admin a) {
		adminDao.create(a);
	}

	
	public void deleteAdmin(Long pId) {
		
		adminDao.delete(pId);
	}

	
	public List<Admin> getAllAdmins() {
		
		return adminDao.getAll();
	}

	
	public Admin getAdminById(Long pId) {
		
		return adminDao.findById(pId);
	}

}
