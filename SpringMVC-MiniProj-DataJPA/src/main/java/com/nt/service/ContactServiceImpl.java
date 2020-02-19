package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.nt.contact.Contact;
import com.nt.entity.Contact_Info;
import com.nt.repo.ContactDetailsRepo;



@Service("Contactservice")
@Configuration
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDetailsRepo repo;
	
	@Override
	public String saveContact(Contact_Info entity) {
		
		entity.setActiveSwch("Y");
		
		Contact_Info entity1=repo.save(entity);
		
		return entity1.getId()==0?"Entity details are not saved":"entity details are saved";
	}

	@Override
	public Iterable<Contact_Info> retrieveAllContacts() {
		
		//gets the all the records with out filetering the records
		
		List<Contact_Info> ContactList=repo.findByActiveSwch("Y");
		
		return ContactList;
	}



	
	@Override
	public Contact retrieveContactById(int id) {
		Optional<Contact_Info> cnt= null;
		cnt =repo.findById(id);
		
		if (cnt.isPresent()) {
			Contact_Info contactDtlsEntity = cnt.get();// source
			Contact c = new Contact();// target
			BeanUtils.copyProperties(contactDtlsEntity, c);
			return c;
		}
		return  null;
	}
	
	public String deleteContact(Contact_Info entity) {
		entity.setActiveSwch("N");
		Contact_Info  info=repo.save(entity);
		return info==null?"Contact is   not Deleted":"Contact is deleted succesfully";
	}	
	
}
