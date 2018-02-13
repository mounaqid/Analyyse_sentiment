package com.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bo.Commentaire;
import com.bo.Destination;
import com.dao.DestinationDao;
import com.genericdao.impl.HibernateSpringGenericDaoImpl;

@Repository
public class DestinationDaoImpl extends HibernateSpringGenericDaoImpl<Destination, Long> implements DestinationDao{
	@PersistenceContext
	private EntityManager em;
	public DestinationDaoImpl() {
		super(Destination.class);
	
	}

	@Override
	public List<Destination>  getDestinationByUserId(Long userId) {
		
			Query req=em.createQuery("select d from Destination d where d.idUser.idDestination=:x");
			req.setParameter("x",userId);
			return req.getResultList();
		
	}

	@Override
	public List<Destination>  getDestinationByAdminId(Long adminId) {
		Query req=em.createQuery("select d from Destination d where d.idAdmin.idDestination=:x");
		req.setParameter("x",adminId);
		return  req.getResultList();
	}
	public  List<Commentaire> getCommentsByDest(Long id)
	{
		Query req=em.createQuery("select c from Commentaire c where c.idCommentaire.idDestination=:x");
		req.setParameter("x",id);
		return  req.getResultList();
	}

}
