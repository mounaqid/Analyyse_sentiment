package com.actions.users;

import java.util.Collection;
import java.util.List;


import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;

import com.actions.BaseAction;
import com.bo.Commentaire;
import com.bo.Destination;
import com.bo.User;
import com.services.DestinationService;
import com.services.UserService;


@ResultPath(value="/pages/")
public class UserAction extends BaseAction {

	private List<Destination> Alldestinations;
	
	private Destination destination;
	
	private Collection<Destination> userdestinations;
	
	private Commentaire userComment;
	
	private Collection<Commentaire> comments;
	
	@Autowired
	private DestinationService destinationService;
	
	@Autowired
	private UserService userService;
	
	@Action(value="/dropDestUser" , results= {  @Result(name="success",type="redirectAction", location="dropDestinationUser")} )
	public String dropDestUser()
	{
		//on reccupere l'id de la destination
		
		getSession().setAttribute("idDest",Long.valueOf(getRequest().getParameter("id")));
		
		
		return SUCCESS;
	}
	@Action(value="/dropDestinationUser" , results= {  @Result(name="success",type="redirectAction", location="getDestinationsAddedByUser")} )
	public String dropDestinationAdmin()
	{
		// la destination on va la reccuperer de la session avec BaseAction
		
		Long id = (Long) getSession().getAttribute("idDest");
		
		// TODO : si destin introubavle
		
		
		Destination dest = (Destination)destinationService.getDestinationById(id);
		
		List<Destination> dests=destinationService.getDestinationByUser(id);
		dests.remove(dest);
		
		return SUCCESS;
	}
	
	@Action(value="/getAllDestinations" , results= {  @Result(name="success", location="listDestination.jsp")} )
	public String getAllDestinations()
	{
		Alldestinations = destinationService.getAllDestinations();
		
		return SUCCESS;
	}
	
	
	
	@Action(value="/commenter" , results= {  @Result(name="success", location="addCommentForm.jsp")} )
	public String showAddCommentForm()
	{
		//on reccupere l id du destination
		
		getSession().setAttribute("idDestination",Long.valueOf(getRequest().getParameter("id")));
		
		
		return SUCCESS;
	}
	
	
	@Action(value="/addComment" , results= {  @Result(name="success", location="addCommentForm.jsp")} )
	public String addComment()
	{
		// la destination on va la reccuperer de la session avec BaseAction
		
		Long id = (Long) getSession().getAttribute("idDestination");
		
		// TODO : si destination introubavle
		
		Destination destination = (Destination) destinationService.getDestinationById(id);
		
	    destination.addComment(userComment);
		
		destinationService.updateDestination(destination);
		
		return SUCCESS;
	}
	
	@Action(value="/getAllCommentsOnAdestination" , results= {  @Result(name="success", location="addCommentForm.jsp")} )
	public String getAllCommentsOnAdestination()
	{
		// la destination on va la reccuperer de la session avec BaseAction
		
		Long id = (Long) getSession().getAttribute("idDestination");
		
		// TODO : si destination introubavle
		
		Destination destination = (Destination) destinationService.getDestinationById(id);
		
		comments = destination.getComments();
		
		return SUCCESS;
	}
	
	@Action(value="/showAddDestinationFormUser" , results= {  @Result(name="success", location="addDestinationForm.jsp")} )
	public String showAddDestinationFormUser()
	{
		//on reccupere le user id
		
		getSession().setAttribute("idUser",Long.valueOf(getRequest().getParameter("id")));
		
		
		return SUCCESS;
	}
	
	
	@Action(value="/addDestinationUser" , results= {  @Result(name="success",type="redirectAction", location="getAllDestinations")} )
	public String addDestinationUser()
	{
		Long id = (Long) getSession().getAttribute("idUser");
		
		// TODO : si user introubavle
		
		User user = (User) userService.getUserById(id);
		
	    user.addDestination(destination);
		
		return SUCCESS;
	}
	@Action(value="/getDestinationsAddedByUser" , results= {  @Result(name="success", location="listDestinationsAddedByUser.jsp")} )
	public String getDestinationsAddedByUser()
	{
		Long id = (Long) getSession().getAttribute("idUser");
		
		// TODO : si user introubavle
		
		User user = (User) userService.getUserById(id);
		
		userdestinations = user.getDestinations();
		
		return SUCCESS;
	}
	
	

	public List<Destination> getAlldestinations() {
		return Alldestinations;
	}



	public void setAlldestinations(List<Destination> alldestinations) {
		Alldestinations = alldestinations;
	}



	public Collection<Destination> getUserdestinations() {
		return userdestinations;
	}



	public void setUserdestinations(Collection<Destination> userdestinations) {
		this.userdestinations = userdestinations;
	}



	public Collection<Commentaire> getComments() {
		return comments;
	}



	public void setComments(Collection<Commentaire> comments) {
		this.comments = comments;
	}



	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public Commentaire getUserComment() {
		return userComment;
	}


	public void setUserComment(Commentaire userComment) {
		this.userComment = userComment;
	}
	
	
}