package com.dao.impl;


import org.springframework.stereotype.Repository;

import com.bo.Commentaire;
import com.dao.CommentDao;
import com.genericdao.impl.HibernateSpringGenericDaoImpl;
@Repository
public class CommentDaoImpl extends HibernateSpringGenericDaoImpl<Commentaire, Long> implements CommentDao {

	public CommentDaoImpl() {
		super(Commentaire.class);
	}

}
