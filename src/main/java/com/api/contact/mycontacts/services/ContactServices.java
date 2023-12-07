package com.api.contact.mycontacts.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.contact.mycontacts.Repository.ContactRepository;
import com.api.contact.mycontacts.entities.ContactEntities;

@Component
public class ContactServices {
	
	@Autowired
	private ContactRepository contactRepository;

	public List<ContactEntities> getAllContacts() {
		return (List<ContactEntities>) contactRepository.findAll();
	}

	public ContactEntities getContactById(int id) {
		ContactEntities contact=null;
		try {
			contact=this.contactRepository.findById(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return contact;
	}

	public ContactEntities addContact(ContactEntities contact) {
		ContactEntities result=this.contactRepository.save(contact);
		return result;
	}

	public void deleteById(int id) {
		this.contactRepository.deleteById(id);
	}

	public ContactEntities updateContact(ContactEntities contact, int id) {
		contact.setId(id);
		return this.contactRepository.save(contact);
	}

	public void deleteAll() {
		this.contactRepository.deleteAll();
	}
	
	public List<String> getAllNames(){
		return this.contactRepository.getAllAurthor();
	}

}
