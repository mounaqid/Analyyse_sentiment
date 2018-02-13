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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="User_table")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	private String email;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Collection<Destination> destinations = new ArrayList<Destination>();
	
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="User_id")
	private Collection<Commentaire> comments = new ArrayList<Commentaire>();
	
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public void addComment(Commentaire c)
	{
		comments.add(c);
	}

	public void addDestination(Destination c)
	{
		destinations.add(c);
	}
	
	public void removeComment(Commentaire c)
	{
		comments.remove(c);
	}
	
	public void removeDestination(Destination c)
	{
		destinations.remove(c);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Collection<Destination> getDestinations() {
		return this.destinations;
	}
	public void setDestinations(Collection<Destination> destinations) {
		this.destinations = destinations;
	}
	public Collection<Commentaire> getComments() {
		return this.comments;
	}
	public void setComments(Collection<Commentaire> comments) {
		this.comments = comments;
	}
	
	
}
