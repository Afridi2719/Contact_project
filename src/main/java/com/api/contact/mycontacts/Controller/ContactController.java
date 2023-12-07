package com.api.contact.mycontacts.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.contact.mycontacts.entities.ContactEntities;
import com.api.contact.mycontacts.services.ContactServices;

@RestController
public class ContactController {
	
	@Autowired
	private ContactServices contactServices;
	
	@GetMapping("/contact")
	public ResponseEntity<List<ContactEntities>> getAllContacts(){
		List<ContactEntities> list=this.contactServices.getAllContacts();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	@GetMapping("/contact/{id}")
	public ResponseEntity<ContactEntities> getContactById(@PathVariable("id") int  id){
		ContactEntities contact=this.contactServices.getContactById(id);
		if(contact==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(contact));
	}
	
	@PostMapping("/contact")
	public ResponseEntity<ContactEntities> addContact(@RequestBody ContactEntities contact){
		ContactEntities b;
		try {
			b=contactServices.addContact(contact);
			return ResponseEntity.of(Optional.of(b));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/contact")
	public ResponseEntity<Void> deleteAll(){
		try {
			this.contactServices.deleteAll();
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/contact/{id}")
	public ResponseEntity<Void> deleteByid(@PathVariable("id") int id){
		try {
			this.contactServices.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); 
		}
	}
	
	@PutMapping("/contact/{id}")
	public ResponseEntity<ContactEntities> updateContact(@RequestBody ContactEntities contact,@PathVariable("id") int id){
		ContactEntities result=this.contactServices.updateContact(contact,id);
		return ResponseEntity.of(Optional.of(result));
	}
	
	@GetMapping("/names")
	public List<String> getAllNames(){
		return this.contactServices.getAllNames();
	}
}
