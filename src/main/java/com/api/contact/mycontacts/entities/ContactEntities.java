package com.api.contact.mycontacts.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ContactEntities {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private int contact;
	private String relation;
	private String gmail;
	
	public ContactEntities(int id, String name, int contact, String relation, String gmail) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.relation = relation;
		this.gmail = gmail;
	}
	public ContactEntities() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	@Override
	public String toString() {
		return "ContactEntities [id=" + id + ", name=" + name + ", contact=" + contact + ", relation=" + relation
				+ ", gmail=" + gmail + "]";
	}
	

}
