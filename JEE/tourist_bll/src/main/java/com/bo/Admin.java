package com.bo;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Admin_Table")
public class Admin {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String pseudo;
	private String password;
	
//	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
//	@JoinColumn(name="Admin_id")
//	private Collection<Commentaire> comments = new ArrayList<Commentaire>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Admin_Destinaton", joinColumns = { @JoinColumn(name = "Admin_ID") }, inverseJoinColumns = { @JoinColumn(name = "Destination_ID") })
	private Collection<Destination> destinations = new ArrayList<Destination>();
	
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="Admin_id")
	private Collection<WordPolarity> wordpolaritys=new ArrayList<WordPolarity>();
	
	//Ajout dans les listes
	public void addDestination(Destination d)
	{
		destinations.add(d);
	}
	public void addWordpolarity(WordPolarity w)
	{
		wordpolaritys.add(w);
	}
//	public void addComment(Commentaire c)
//	{
//		comments.add(c);
//	}
//	// suppression 
//	
//	public void removeComment(Commentaire c)
//	{
//		comments.remove(c);
//	}
	
	public void removeDestination(Destination c)
	{
		destinations.remove(c);
	}
	public void removeWordpolarity(WordPolarity w)
	{
		wordpolaritys.remove(w);
	}
	//Getters et Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
//	public Collection<Commentaire> getComments() {
//		return this.comments;
//	}
//	public void setComments(Collection<Commentaire> comments) {
//		this.comments = comments;
//	}
	public Collection<Destination> getDestinations() {
		return this.destinations;
	}
	public void setDestinations(Collection<Destination> destinations) {
		this.destinations = destinations;
	}
	public Collection<WordPolarity> getWordpolaritys() {
		return this.wordpolaritys;
	}
	public void setWordpolaritys(Collection<WordPolarity> wordpolaritys) {
		this.wordpolaritys = wordpolaritys;
	}
		

}