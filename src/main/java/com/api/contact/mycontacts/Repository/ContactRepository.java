package com.api.contact.mycontacts.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.api.contact.mycontacts.entities.ContactEntities;

public interface ContactRepository extends CrudRepository<ContactEntities,Integer>{
	
	public ContactEntities findById(int id);
	
	@Query("select u.name from ContactEntities u")
	public List<String> getAllAurthor();
}
