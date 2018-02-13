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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Destination_Table")
public class Destination {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String photo;
	private double note;
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="Destination_id")
	private Collection<Commentaire> comments = new ArrayList<Commentaire>();
	

	public void addComment(Commentaire c)
	{
		comments.add(c);
	}
	public void removeComment(Commentaire c)
	{
		comments.remove(c);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public double getNote() {
		return note;
	}
	public void setNote(double note) {
		this.note = note;
	}

	public Collection<Commentaire> getComments() {
		return comments;
	}

	public void setComments(Collection<Commentaire> comments) {
		this.comments = comments;
	}
	
	
}
