package com.services;

import java.util.List;

import com.bo.Admin;
import com.bo.User;

public interface AdminService {

	public void addAdmin(Admin a);
	public void deleteAdmin(Long pId);
	public List<Admin> getAllAdmins();
	public Admin getAdminById(Long pId);
}
