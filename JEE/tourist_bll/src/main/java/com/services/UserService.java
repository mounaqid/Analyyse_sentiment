package com.services;

import java.util.List;

import com.bo.Commentaire;
import com.bo.User;

public interface UserService {

	public void addUser(User u);
	public List<User> getAllUsers();
	public User getUserById(Long pId);
	public Commentaire getCommentById(Long pId);
	public List<Commentaire> getAllComents();
	
}
