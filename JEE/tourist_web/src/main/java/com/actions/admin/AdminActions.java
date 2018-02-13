package com.actions.admin;

import java.util.Collection;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;

import com.actions.BaseAction;
import com.bo.Admin;
import com.bo.Destination;
import com.bo.User;
import com.bo.WordPolarity;
import com.services.SentimentAnalysis;
import com.services.AdminService;
import com.services.DestinationService;

@ResultPath(value="/pages/")
public class AdminActions extends BaseAction{
	
	private Destination destination;
	
	private Collection<Destination> admindestinations;
	
	@Autowired
	private DestinationService destinationService;
	
	@Autowired
	private AdminService adminService;

	private WordPolarity wordPolarity;
	@Autowired
	private SentimentAnalysis sentimentAnalysis;
	private List<Destination> AlldestinationsAdmin;
	
	
	
	public List<Destination> getAlldestinationsAdmin() {
		return AlldestinationsAdmin;
	}
	public void setAlldestinations(List<Destination> AlldestinationsAdmin) {
		this.AlldestinationsAdmin = AlldestinationsAdmin;
	}
		//rec id
		@Action(value="/dropDestAdmin" , results= {  @Result(name="success",type="redirectAction", location="dropDestinationAdmin")} )
		public String dropDestAdmin()
		{
			//on reccupere l'id de la destination
			
			getSession().setAttribute("idDest",Long.valueOf(getRequest().getParameter("id")));
			
			
			return SUCCESS;
		}
		@Action(value="/dropDestinationAdmin" , results= {  @Result(name="success",type="redirectAction", location="getAllDestinations")} )
		public String dropDestinationAdmin()
		{
			// la destination on va la reccuperer de la session avec BaseAction
			
			Long id = (Long) getSession().getAttribute("idDest");
			
			// TODO : si destin introubavle
			
			
			Destination dest = (Destination)destinationService.getDestinationById(id);
			
			List<Destination> dests=destinationService.getAllDestinations();
			dests.remove(dest);
			
			return SUCCESS;
		}
		
	
	
	@Action(value="/addWord" , results= {  @Result(name="success", location="addWordForm.jsp")} )
	public String addWord()
	{
		sentimentAnalysis.addWord(wordPolarity);
		
		addActionMessage("Mot bien ajouté ");
		
		return SUCCESS;
	}
	
	@Action(value="/showAddDestinationFormAdmin" , results= {  @Result(name="success", location="addDestinationForm.jsp")} )
	public String showAddDestinationFormAdmin()
	{
		//on reccupere le admin id
		
		getSession().setAttribute("idAdmin",Long.valueOf(getRequest().getParameter("id")));
		
		
		return SUCCESS;
	}
	
	
	@Action(value="/addDestinationAdmin" , results= {  @Result(name="success",type="redirectAction", location="getAllDestinations")} )
	public String addDestinationAdmin()
	{
		// la destination on va la reccuperer de la session avec BaseAction
		
		Long id = (Long) getSession().getAttribute("idAdmin");
		
		// TODO : si admin introubavle
		
		Admin admin = (Admin) adminService.getAdminById(id);
		
	    admin.addDestination(destination);
		
		return SUCCESS;
	}
	@Action(value="/getAllDestinationsAdmin" , results= {  @Result(name="success", location="listDestinationAdmin.jsp")} )
	public String getAllDestinationsAdmin()
	{
		AlldestinationsAdmin = destinationService.getAllDestinations();
		
		return SUCCESS;
	}
	
	
	
	@Action(value="/GetDestinationsAddedByAdmin" , results= {  @Result(name="success", location="listDestinationAddedByAdmin.jsp")} )
	public String GetDestinationsAddedByAdmin()
	{
		Long id = (Long) getSession().getAttribute("idUser");
		
		// TODO : si user introubavle
		
		Admin admin = (Admin) adminService.getAdminById(id);
		
		admindestinations=admin.getDestinations();
		
		return SUCCESS;
	}

	public WordPolarity getWordPolarity() {
		return wordPolarity;
	}

	public void setWordPolarity(WordPolarity wordPolarity) {
		this.wordPolarity = wordPolarity;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public Collection<Destination> getAdmindestinations() {
		return admindestinations;
	}

	public void setAdmindestinations(Collection<Destination> admindestinations) {
		this.admindestinations = admindestinations;
	}
    
	
	
}