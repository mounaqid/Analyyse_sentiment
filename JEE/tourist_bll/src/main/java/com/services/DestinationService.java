package com.services;

import java.util.List;

import com.bo.Commentaire;
import com.bo.Destination;

public interface DestinationService {

	public List<Destination> getAllDestinations();

	public void addDestination(Destination pDestination);

	public void updateDestination(Destination destination);

	public  List<Destination> getDestinationByUser(Long id);
	
	public  List<Destination> getDestinationByAdmin(Long id);
	
	public  List<Commentaire> getCommentsByDestination(Long id);
	public Destination getDestinationById(Long id);
	
	public void deleteDestination(Long pId);
	
	
	
}
