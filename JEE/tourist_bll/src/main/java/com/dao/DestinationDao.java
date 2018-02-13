package com.dao;

import java.util.List;

import com.bo.Commentaire;
import com.bo.Destination;
import com.genericdao.api.GenericDao;

public interface DestinationDao extends GenericDao<Destination, Long>{
	public List<Destination>  getDestinationByUserId(Long id);
	public List<Destination>  getDestinationByAdminId(Long id);
	public  List<Commentaire> getCommentsByDest(Long id);

}
