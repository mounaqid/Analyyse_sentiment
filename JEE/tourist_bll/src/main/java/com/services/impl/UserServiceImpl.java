package com.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bo.Commentaire;
import com.bo.User;
import com.dao.CommentDao;
import com.dao.UserDao;
import com.services.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private CommentDao commentDao;
	
	public void addUser(User u) {
		
		userDao.create(u);
	}

	public List<User> getAllUsers() {
		return userDao.getAll();
	}

	
	public User getUserById(Long pId) {
		return userDao.findById(pId);
	}

	public Commentaire getCommentById(Long pId) {
		return commentDao.findById(pId);
	}
	
	public List<Commentaire> getAllComents() {
		return commentDao.getAll();
	}

}
