package com.nt.service;

import java.util.Optional;

import com.nt.contact.Contact;
import com.nt.entity.Contact_Info;

public interface ContactService {

	public String saveContact(Contact_Info contact);
	public Iterable<Contact_Info> retrieveAllContacts();
	
	public Contact retrieveContactById(int id);
	public String deleteContact(Contact_Info entity);

}
